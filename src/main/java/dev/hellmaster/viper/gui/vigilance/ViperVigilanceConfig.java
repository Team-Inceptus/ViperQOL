package dev.hellmaster.viper.gui.vigilance;

import com.sun.scenario.effect.Crop;
import dev.hellmaster.viper.api.APIUtils;
import gg.essential.vigilance.Vigilant;
import gg.essential.vigilance.data.Property;
import gg.essential.vigilance.data.PropertyType;
import gg.essential.vigilance.gui.VigilancePalette;
import net.minecraft.client.Minecraft;
import java.io.File;

public class ViperVigilanceConfig extends Vigilant {

    public static ViperVigilanceConfig INSTANCE;
    public static boolean awaitShowColourWindow = false;

    public final VigilancePalette getPalette() {
        return VigilancePalette.INSTANCE;
    }

    public final ViperVigilanceConfig getINSTANCE() { return INSTANCE; }

    public final void setINSTANCE(ViperVigilanceConfig var1) { INSTANCE = var1; }

    public static final File modDir = new File(Minecraft.getMinecraft().mcDataDir, "config/ViperVigilanceConfig");

    public static final File configFile = new File(modDir + "/ViperVigilanceConfig.toml");

    public ViperVigilanceConfig() {
        super(configFile, "Viper Config", new ViperPropertyCollector(), new ViperSB());
        this.preload();
        this.writeData();
        modDir.mkdirs();
        this.initialize();
    }

    //DATA

    //Api
    @Property(
            type = PropertyType.TEXT,
            name = "API Key",
            description = "Your Hypixel API key. Automatically configures itself, however if some things don't work then manually updating this may help.",
            category = "API"
    )
    public static String apiKey = "";

    @Property(
            type = PropertyType.SELECTOR,
            name = "API Auto Update Rate",
            description = "Automatically updates the api at the set interval above.",
            category = "API",
            options = {"1 Minute (Not Recommended)", "5 Minutes (Recommended)", "10 Minutes", "30 Minutes", "1 Hour", "Manually"}
    )
    public static int apiRate = 1;

    @Property(
            type = PropertyType.BUTTON,
            name = "Update API",
            description = "Updates the API. API Automatically updates at your set interval, but this manually refreshes the API.",
            category = "API"
    )
    public static void updateAPI() {
        APIUtils.updateAPI();
    }

    @Property(
            type = PropertyType.SWITCH,
            name = "Faster API Updates",
            description = "Updates the API faster, but uses an extra thread.",
            category = "API"
    )
    public static boolean fastAPIUpdates = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Enable API Update messages",
            description = "If the constant spam from the API updating bothers you, then turn this off to disable them! (The API will still update, just silently.",
            category = "API"
    )
    public static boolean doAPIMessage = true;

    //BLACKLIST

    //Ultimate Enchants

    @Property(
            type = PropertyType.CHECKBOX,
            name = "Bank",
            description = "Blacklists any item with Bank on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Ultimate Enchants"
    )
    public static boolean blacklistBank = false;
    @Property(
            type = PropertyType.CHECKBOX,
            name = "Bobbin Time",
            description = "Blacklists any item with Bobbin Time on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Ultimate Enchants"
    )
    public static boolean blacklistBobbinTime = false;

    @Property(
            type = PropertyType.CHECKBOX,
            name = "Chimera",
            description = "Blacklists any item with Chimera on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Ultimate Enchants"
    )
    public static boolean blacklistChimera = false;

    @Property(
            type = PropertyType.CHECKBOX,
            name = "Combo",
            description = "Blacklists any item with Combo on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Ultimate Enchants"
    )
    public static boolean blacklistCombo = false;

    @Property(
            type = PropertyType.CHECKBOX,
            name = "Duplex",
            description = "Blacklists any item with Duplex on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Ultimate Enchants"
    )
    public static boolean blacklistDuplex = false;

    @Property(
            type = PropertyType.CHECKBOX,
            name = "Fatal Tempo",
            description = "Blacklists any item with Fatal Tempo on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Ultimate Enchants"
    )
    public static boolean blacklistFatalTempo = false;

    @Property(
            type = PropertyType.CHECKBOX,
            name = "Flash",
            description = "Blacklists any item with Flash on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Ultimate Enchants"
    )
    public static boolean blacklistFlash = false;

    @Property(
            type = PropertyType.CHECKBOX,
            name = "Habanero Tactics",
            description = "Blacklists any item with Habanero Tactics on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Ultimate Enchants"
    )
    public static boolean blacklistHabaneroTactics = false;

    @Property(
            type = PropertyType.CHECKBOX,
            name = "Inferno",
            description = "Blacklists any item with Inferno on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Ultimate Enchants"
    )
    public static boolean blacklistInferno = false;

    @Property(
            type = PropertyType.CHECKBOX,
            name = "Last Stand",
            description = "Blacklists any item with Last Stand on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Ultimate Enchants"
    )
    public static boolean blacklistLastStand = false;

    @Property(
            type = PropertyType.CHECKBOX,
            name = "Legion",
            description = "Blacklists any item with Legion on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Ultimate Enchants"
    )
    public static boolean blacklistLegion = false;

    @Property(
            type = PropertyType.CHECKBOX,
            name = "No Pain No Gain",
            description = "Blacklists any item with No Pain No Gain on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Ultimate Enchants"
    )
    public static boolean blacklistNoPainNoGain = false;

    @Property(
            type = PropertyType.CHECKBOX,
            name = "One For All",
            description = "Blacklists any item with One For All on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Ultimate Enchants"
    )
    public static boolean blacklistOneForAll = false;

    @Property(
            type = PropertyType.CHECKBOX,
            name = "Rend",
            description = "Blacklists any item with Rend on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Ultimate Enchants"
    )
    public static boolean blacklistRend = false;

    @Property(
            type = PropertyType.CHECKBOX,
            name = "Soul Eater",
            description = "Blacklists any item with Soul Eater on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Ultimate Enchants"
    )
    public static boolean blacklistSoulEater = false;

    @Property(
            type = PropertyType.CHECKBOX,
            name = "Swarm",
            description = "Blacklists any item with Swarm on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Ultimate Enchants"
    )
    public static boolean blacklistSwarm = false;

    @Property(
            type = PropertyType.CHECKBOX,
            name = "Ultimate Jerry",
            description = "Blacklists any item with Ultimate Jerry on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Ultimate Enchants"
    )
    public static boolean blacklistUltimateJerry = false;

    @Property(
            type = PropertyType.CHECKBOX,
            name = "Ultimate Wise",
            description = "Blacklists any item with Ultimate Wise on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Ultimate Enchants"
    )
    public static boolean blacklistUltimateWise = false;

    @Property(
            type = PropertyType.CHECKBOX,
            name = "Wisdom",
            description = "Blacklists any item with Wisdom on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Ultimate Enchants"
    )
    public static boolean blacklistWisdom = false;

    //Normal Enchants


    @Property(
            type = PropertyType.CHECKBOX,
            name = "Angler",
            description = "Blacklists any item with Angler on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistAngler = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Aqua Affinity",
            description = "Blacklists any item with Aqua Affinity on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistAquaAffinity = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Bane of Arthropods",
            description = "Blacklists any item with Bane of Arthropods on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistBaneOfArthropods = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Big Brain",
            description = "Blacklists any item with Big Brain on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistBigBrain = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Blast Protection",
            description = "Blacklists any item with Blast Protection on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants")
    public static boolean blacklistBlastProtection = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Blessing",
            description = "Blacklists any item with Blessing on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistBlessing = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Caster",
            description = "Blacklists any item with Caster on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistCaster = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Cayenne",
            description = "Blacklists any item with Cayenne on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistCayenne = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Champion",
            description = "Blacklists any item with Champion on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistChampion = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Chance",
            description = "Blacklists any item with Chance on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistChance = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Charm",
            description = "Blacklists any item with Charm on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistCharm = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Cleave",
            description = "Blacklists any item with Cleave on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistCleave = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Compact",
            description = "Blacklists any item with Compact on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistCompact = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Corruption",
            description = "Blacklists any item with Corruption on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistCorruption = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Counter-Strike",
            description = "Blacklists any item with Counter-Strike on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistCounterStrike = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Critical",
            description = "Blacklists any item with Critical on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistCritical = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Cubism",
            description = "Blacklists any item with Cubism on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistCubism = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Cultivating",
            description = "Blacklists any item with Cultivating on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistCultivating = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Delicate",
            description = "Blacklists any item with Delicate on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistDelicate = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Depth Strider",
            description = "Blacklists any item with Depth Strider on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistDepthStrider = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Divine Gift",
            description = "Blacklists any item with Divine Gift on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistDivineGift = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Dragon Hunter",
            description = "Blacklists any item with Dragon Hunter on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistDragonHunter = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Dragon Tracer",
            description = "Blacklists any item with Dragon Tracer on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistDragonTracer = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Efficiency",
            description = "Blacklists any item with Efficiency on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistEfficiency = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Ender Slayer",
            description = "Blacklists any item with Ender Slayer on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistEnderSlayer = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Execute",
            description = "Blacklists any item with Execute on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistExecute = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Experience",
            description = "Blacklists any item with Experience on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistExperience = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Expertise",
            description = "Blacklists any item with Expertise on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistExpertise = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Feather Falling",
            description = "Blacklists any item with Feather Falling on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistFeatherFalling = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Ferocious Mana",
            description = "Blacklists any item with Ferocious Mana on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistFerociousMana = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Fire Aspect",
            description = "Blacklists any item with Fire Aspect on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistFireAspect = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Fire Protection",
            description = "Blacklists any item with Fire Protection on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistFireProtection = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "First Strike",
            description = "Blacklists any item with First Strike on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistFirstStrike = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Flame",
            description = "Blacklists any item with Flame on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistFlame = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Fortune",
            description = "Blacklists any item with Fortune on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistFortune = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Frail",
            description = "Blacklists any item with Frail on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistFrail = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Frost Walker",
            description = "Blacklists any item with Frost Walker on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistFrostWalker = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Giant Killer",
            description = "Blacklists any item with Giant Killer on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistGiantKiller = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Growth",
            description = "Blacklists any item with Growth on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistGrowth = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Hardened Mana",
            description = "Blacklists any item with Hardened Mana on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistHardenedMana = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Harvesting",
            description = "Blacklists any item with Harvesting on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistHarvesting = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Hecatomb",
            description = "Blacklists any item with Hecatomb on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistHecatomb = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Impaling",
            description = "Blacklists any item with Impaling on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistImpaling = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Infinite Quiver",
            description = "Blacklists any item with Infinite Quiver on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistInfiniteQuiver = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Knockback",
            description = "Blacklists any item with Knockback on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistKnockback = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Lethality",
            description = "Blacklists any item with Lethality on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistLethality = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Life Steal",
            description = "Blacklists any item with Life Steal on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistLifeSteal = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Looting",
            description = "Blacklists any item with Looting on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistLooting = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Luck",
            description = "Blacklists any item with Luck on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistLuck = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Luck of the Sea",
            description = "Blacklists any item with Luck of the Sea on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistLuckOfTheSea = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Lure",
            description = "Blacklists any item with Lure on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistLure = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Mana Steal",
            description = "Blacklists any item with Mana Steal on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistManaSteal = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Mana Vampire",
            description = "Blacklists any item with Mana Vampire on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistManaVampire = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Magnet",
            description = "Blacklists any item with Magnet on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistMagnet = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Overload",
            description = "Blacklists any item with Overload on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistOverload = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Piercing",
            description = "Blacklists any item with Piercing on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistPiercing = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Piscary",
            description = "Blacklists any item with Piscary on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistPiscary = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Power",
            description = "Blacklists any item with Power on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistPower = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Pristine",
            description = "Blacklists any item with Pristine on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistPristine = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Projectile Protection",
            description = "Blacklists any item with Projectile Protection on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistProjectileProtection = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Prosecute",
            description = "Blacklists any item with Prosecute on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistProsecute = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Prosperity",
            description = "Blacklists any item with Prosperity on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistProsperity = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Protection",
            description = "Blacklists any item with Protection on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistProtection = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Punch",
            description = "Blacklists any item with Punch on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistPunch = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Rainbow",
            description = "Blacklists any item with Rainbow on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistRainbow = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Rejuvenate",
            description = "Blacklists any item with Rejuvenate on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistRejuvenate = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Replenish",
            description = "Blacklists any item with Replenish on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistReplenish = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Respiration",
            description = "Blacklists any item with Respiration on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistRespiration = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Respite",
            description = "Blacklists any item with Respite on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistRespite = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Scavenger",
            description = "Blacklists any item with Scavenger on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistScavenger = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Sharpness",
            description = "Blacklists any item with Sharpness on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistSharpness = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Silk Touch",
            description = "Blacklists any item with Silk Touch on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistSilkTouch = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Smelting Touch",
            description = "Blacklists any item with Smelting Touch on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistSmeltingTouch = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Smarty Pants",
            description = "Blacklists any item with Smarty Pants on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistSmartyPants = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Smite",
            description = "Blacklists any item with Smite on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistSmite = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Snipe",
            description = "Blacklists any item with Snipe on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistSnipe = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Spiked Hook",
            description = "Blacklists any item with Spiked Hook on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistSpikedHook = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Strong Mana",
            description = "Blacklists any item with Strong Mana on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistStrongMana = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Sugar Rush",
            description = "Blacklists any item with Sugar Rush on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistSugarRush = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Syphon",
            description = "Blacklists any item with Syphon on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistSyphon = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Tabasco",
            description = "Blacklists any item with Tabasco on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistTabasco = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Thorns",
            description = "Blacklists any item with Thorns on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistThorns = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Thunderbolt",
            description = "Blacklists any item with Thunderbolt on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistThunderbolt = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Thunderlord",
            description = "Blacklists any item with Thunderlord on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistThunderlord = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Titan Killer",
            description = "Blacklists any item with Titan Killer on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistTitanKiller = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Triple-Strike",
            description = "Blacklists any item with Triple-Strike on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistTripleStrike = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "True Protection",
            description = "Blacklists any item with True Protection on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistTrueProtection = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Turbo-Crop",
            description = "Blacklists any item with Turbo-Crop on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistTurboCrop = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Vampirism",
            description = "Blacklists any item with Vampirism on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistVampirism = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Venomous",
            description = "Blacklists any item with Venomous on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistVenomous = false;



    @Property(
            type = PropertyType.CHECKBOX,
            name = "Vicious",
            description = "Blacklists any item with Vicious on it, regardless of level.",
            category = "Blacklists",
            subcategory = "Normal Enchants"
    )
    public static boolean blacklistVicious = false;



}
