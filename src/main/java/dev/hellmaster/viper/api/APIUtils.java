package dev.hellmaster.viper.api;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mojang.realmsclient.gui.ChatFormatting;
import dev.hellmaster.viper.Viper;
import dev.hellmaster.viper.gui.vigilance.ViperVigilanceConfig;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class APIUtils {

    //auction items


    //prevent multiple updates from happening at once

    static boolean isUpdating = false;

    //tick counter to measure time
    private static int tick = 0;
    private static int maxTick = 1;
    //Auto update API
    @SubscribeEvent
    public void updateAPIAuto(ClientTickEvent event) {
        if(Viper.mc.theWorld != null) {
            switch (ViperVigilanceConfig.apiRate) {
                case 0:
                    maxTick = 1200;
                    break;
                case 1:
                    maxTick = 6000;
                    break;
                case 2:
                    maxTick = 12000;
                    break;
                case 3:
                    maxTick = 36000;
                    break;
                case 4:
                    maxTick = 72000;
                    break;
            }

            if (!(ViperVigilanceConfig.apiRate == 5)) {
                tick++;
            }

            if (tick >= maxTick) {
                updateAPI();
                tick = 0;
            }
        }

    }
    //Manually update API
    public static void updateAPI() {
        if (!isUpdating) {
            isUpdating = true;
            //avoid initial freeze when making API request
            new Thread(() -> {
                try {
                    long startTime = System.currentTimeMillis();
                    URL auctionUrl = new URL("https://api.hypixel.net/skyblock/auctions");
                    HttpURLConnection connection = (HttpURLConnection) auctionUrl.openConnection();
                    InputStream response = connection.getInputStream();
                    if (response != null) {
                        try (Scanner scanner = new Scanner(response)) {
                            String responsebody = scanner.useDelimiter("\\A").next();

                            JsonElement jelement = new JsonParser().parse(responsebody);
                            JsonObject jobject = jelement.getAsJsonObject();
                            int numPages = jobject.get("totalPages").getAsInt();

                            if (ViperVigilanceConfig.fastAPIUpdates) {
                                int numThreads = 2;
                                AtomicBoolean sentMessage = new AtomicBoolean(false);
                                if (ViperVigilanceConfig.doAPIMessage)
                                    Viper.sendMarkedChatMessage("Updating API...");

                                for (int t = 0; t < numThreads; t++) {
                                    final int t1 = t;
                                    new Thread(() -> {
                                        //Looks really complex but all this really does is splits the total number of pages to scan in half and assigns a separate thread to each half (only if fast api updates is turned on.)
                                        int pageHelper = numPages % 2 == 0 ? (numPages / 2) : ((numPages - 1) / 2);
                                        for (int page = t1 * pageHelper; page < ((t1 == 0) ? ((t1 + 1) * pageHelper) : (((t1 + 1) * pageHelper) + 1)); page++) {

                                            try {
                                                checkItems(page);
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            page++;

                                        }
                                        if (!sentMessage.get()) {
                                            long endTime = System.currentTimeMillis();
                                            if (ViperVigilanceConfig.doAPIMessage)
                                                Viper.sendMarkedChatMessage("Update Complete! Time taken: ~" + (endTime - startTime)/1000 + " seconds.");
                                            sentMessage.set(true);
                                        }
                                        isUpdating = false;
                                    }).start();
                                }
                            }
                            else {

                                if (ViperVigilanceConfig.doAPIMessage)
                                    Viper.sendMarkedChatMessage("Updating API...");
                                for (int page = 0; page < numPages; page++) {

                                    try {
                                        checkItems(page);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    page++;

                                }
                                long endTime = System.currentTimeMillis();
                                if (ViperVigilanceConfig.doAPIMessage)
                                    Viper.sendMarkedChatMessage("Update Complete! Time taken: ~" + (endTime - startTime)/1000 + " seconds.");
                                isUpdating = false;
                            }
                        }
                    }
                } catch (IOException e) {
                    Viper.sendMarkedChatMessage("Error updating API! Using outdated API data...");
                }
            }).start();
        }
        else {
            Viper.sendMarkedChatMessage("API still updating, duplicate update canceled!");
        }
    }

    private static void checkItems(int page) throws IOException {
        try {
            URL pageUrl = new URL("https://api.hypixel.net/skyblock/auctions?page=" + page);
            HttpURLConnection connection = (HttpURLConnection) pageUrl.openConnection();
            InputStream response = connection.getInputStream();
            if (response != null) {
                try (Scanner scanner = new Scanner(response)) {
                    String responsebody = scanner.useDelimiter("\\A").next();

                    JsonElement jelement = new JsonParser().parse(responsebody);
                    JsonObject jobject = jelement.getAsJsonObject();
                    JsonArray auctions = jobject.getAsJsonArray("auctions");

                    for (JsonElement item : auctions) {
                        JsonElement getBin = item.getAsJsonObject().get("bin");
                        boolean isBin = Boolean.parseBoolean(String.valueOf(getBin));
                        JsonElement itemLore = item.getAsJsonObject().get("item_lore");
                        JsonElement name = item.getAsJsonObject().get("item_name");
                        JsonElement price = item.getAsJsonObject().get("starting_bid");
                        JsonElement seller = item.getAsJsonObject().get("auctioneer");

                        String lore = ChatFormatting.stripFormatting(itemLore.getAsString());

                        String nameStr = name.getAsString();

                        System.out.println("Item: " + nameStr + ", Lore: " + lore + ", Price: " + price.getAsString() + ", Seller: " + seller.getAsString());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
