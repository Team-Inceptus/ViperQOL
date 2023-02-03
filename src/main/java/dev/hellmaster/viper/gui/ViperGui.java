package dev.hellmaster.viper.gui;

import gg.essential.elementa.ElementaVersion;
import gg.essential.elementa.WindowScreen;
import gg.essential.elementa.components.*;
import gg.essential.elementa.constraints.CenterConstraint;
import gg.essential.elementa.constraints.PixelConstraint;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class ViperGui extends WindowScreen {

    private static float numSections = 1f;
    private static List<String> sectionTitles = new ArrayList<>();

    UIContainer mainContainer = (UIContainer) new UIContainer()
            .setX(new CenterConstraint())
            .setY(new CenterConstraint())
            .setHeight(new PixelConstraint((float) (getWindow().getHeight() * 0.9)))
            .setWidth(new PixelConstraint((float) (getWindow().getWidth() * 0.9)))
            .setChildOf(getWindow());

    UIText title = (UIText) new UIText("Viper QOL", false)
            .setColor(Color.GREEN)
            .setChildOf(getWindow())
            .setX(new CenterConstraint())
            .setY(new PixelConstraint((float) (getWindow().getHeight() * 0.02)));

    UIContainer sectionContainer = (UIContainer) new UIContainer()
            .setX(new PixelConstraint((float) (mainContainer.getWidth() * 0.05)))
            .setY(new CenterConstraint())
            .setHeight(new PixelConstraint((float) (mainContainer.getHeight() * 0.9)))
            .setWidth(new PixelConstraint((float) (mainContainer.getWidth() * 0.15)))
            .setChildOf(mainContainer);

    UIBlock sectionContainer1 = (UIBlock) new UIBlock()
            .setX(new PixelConstraint((float) (mainContainer.getWidth() * 0.05)))
            .setY(new CenterConstraint())
            .setHeight(new PixelConstraint((float) (mainContainer.getHeight() * 0.9)))
            .setWidth(new PixelConstraint((float) (mainContainer.getWidth() * 0.15)))
            .setChildOf(mainContainer);

    UIRoundedRectangle titleContainer = (UIRoundedRectangle) new UIRoundedRectangle(20)
            .setX(new PixelConstraint((float) (mainContainer.getWidth() * 0.33)))
            .setY(new PixelConstraint((float) (mainContainer.getHeight() * 0.05)))
            .setHeight(new PixelConstraint((float) (mainContainer.getHeight() * 0.2)))
            .setWidth(new PixelConstraint((float) (mainContainer.getWidth() * 0.65)))
            .setChildOf(mainContainer);
    UIWrappedText titleAndText = (UIWrappedText) new UIWrappedText("test text, this is super cool and will end up being the title.", false)
            .setChildOf(titleContainer)
            .setWidth(new PixelConstraint((float) (titleContainer.getWidth() * 0.9)))
            .setHeight(new PixelConstraint((float) (titleContainer.getHeight() * 0.9)))
            .setX(new CenterConstraint())
            .setY(new PixelConstraint((float) (titleContainer.getHeight() * 0.1)))
            .setColor(Color.BLACK);

    public ViperGui() {
        super(ElementaVersion.V2);
        clearSections();
        setSectionCount(2);
        addSectionTitle("test1");
        addSectionTitle("test2");
        for(int i = 0; i < numSections; i++) {
            /*UIRoundedRectangle rect = (UIRoundedRectangle) new UIRoundedRectangle((circle.getWidth()/8)/(2*numSections))
                    .setColor(Color.CYAN)
                    .setChildOf(circle)
                    //.setY(new CenterConstraint())
                    .setHeight(new PixelConstraint((float) (circle.getWidth()*(0.2))))
                    .setWidth(new PixelConstraint((float) (circle.getWidth()*0.2)))
                    .enableEffect(new ScissorEffect());
            rect.setComponentName(sectionTitles.get(i));*/
        }
        /*
        mainCircle.onMouseClick((uiComponent, uiClickEvent) -> {
            Viper.sendMarkedChatMessage("Test!");
            return null;
        });*/
    }

    public static void setSectionCount(int count) {
        numSections = count;
    }
    public static void addSectionTitle(String title) {
        sectionTitles.add(title);
    }
    public static void clearSections() {
        sectionTitles.clear();
        numSections = 1f;
    }
}