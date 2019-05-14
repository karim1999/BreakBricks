package BreakBreaks;

import javafx.scene.paint.Color;

public class Config {
    public static String gameTitle= "Game Name";
    public static double screenWidth = 500;
    public static double screenHeight = 500;

    //Stick
    public static double stickWidth= 150;
    public static double stickHeight= 15;
    public static double stickArcWidth= 7;
    public static double stickArcHeight= 7;
    public static Color stickColor= Color.RED;

    public static double getStickWidth() {
        return stickWidth;
    }

    public static double getStickHeight() {
        return stickHeight;
    }

    public static double getStickArcWidth() {
        return stickArcWidth;
    }

    public static double getStickArcHeight() {
        return stickArcHeight;
    }

    public static Color getStickColor() {
        return stickColor;
    }

    public static String getGameTitle() {
        return gameTitle;
    }

    public static void setGameTitle(String gameTitle) {
        Config.gameTitle = gameTitle;
    }

    public static double getScreenWidth() {
        return screenWidth;
    }

    public static void setScreenWidth(double screenWidth) {
        Config.screenWidth = screenWidth;
    }

    public static double getScreenHeight() {
        return screenHeight;
    }

    public static void setScreenHeight(double screenHeight) {
        Config.screenHeight = screenHeight;
    }
}
