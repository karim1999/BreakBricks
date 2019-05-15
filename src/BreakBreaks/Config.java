package BreakBreaks;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.File;

public class Config {
    //Screen Properties
    public static String gameTitle= "Game Name";
    public static double screenWidth = 1022;
    public static double screenHeight = 575;

    //Main Menu Buttons
    public static double mainMenuButtonWidth  = 225;
    public static double mainMenuButtonHeight = 50;

    public static double menuBoxXtranslation = 400;
    public static double menuBoxYtranslation = 230;

    //Main Menu Game Title
    public static double mainMenuTitleXtranslate = 310;
    public static double mainMenuTitleYtranslate = 150;

    //Main Menu Background Video
    public static String backgroundVideopath = "Assets\\Grid Background.mp4";
    public static Media backgroundLoading= new Media(new File(backgroundVideopath).toURI().toString());
    public static MediaPlayer backgroundMedia = new MediaPlayer(backgroundLoading);
    public static MediaView mediaView = new MediaView(backgroundMedia);

    //Highest Scores
    public static double highestScoresTitleXtranslate = 310;
    public static double highestScoresTitleYtranslate = 25;

    public static double backButtonXtranslate = 400;
    public static double backButtonYtranslate = 400;

    public static Color highestScoresTitle = Color.valueOf("#212121");

    //Stick
    public static double stickWidth= 150;
    public static double stickHeight= 15;
    public static double stickArcWidth= 7;
    public static double stickArcHeight= 7;
    public static Color stickColor= Color.RED;

    //Ball
    public static double ballRadius= 7;
    public static Color ballColor= Color.BLACK;

    //Fonts
    public static Font HemiHeadButtons = Font.loadFont("file:Fonts\\hemi head bd.ttf",18);
    public static Font HemiHeadTitle = Font.loadFont("file:Fonts\\Future TimeSplitters.otf",115);

    public static Font HighestScoresTitleFont= Font.loadFont("file:Fonts\\astron boy.ttf",70);

    //Button Texts Colors
    public static Color buttonTextColor = Color.valueOf("#FFFF8D");
    public static Color buttonTextColorOnAction = Color.valueOf("#212121");

    public Config(double screenWidth, double screenHeight) {
        //Load data from config file
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
    }
    public static void setVideo(MediaPlayer mediaPlayer)
    {

    }


}
