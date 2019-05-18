package BreakBreaks;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
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

    public static String path = "Sounds\\Button sound.wav";
    public static Media media = new Media(new File(path).toURI().toString());
    public static MediaPlayer ButtonHovering = new MediaPlayer(media);

    public static String path1 = "Sounds\\Unique.wav";
    public static Media media1 = new Media(new File(path).toURI().toString());
    public static MediaPlayer collidingSound = new MediaPlayer(media);

    public static String path2 = "Sounds\\Applause Crowd Cheering sound effect.wav";
    public static Media media2 = new Media(new File(path).toURI().toString());
    public static MediaPlayer winningSound = new MediaPlayer(media2);


    //Main Menu Game Title
    public static double mainMenuTitleXtranslate = 310;
    public static double mainMenuTitleYtranslate = 150;

    //Main Menu Background Video
    public static String backgroundVideopath = "Assets\\Grid Background.mp4";
    public static Media backgroundLoading= new Media(new File(backgroundVideopath).toURI().toString());
    public static MediaPlayer backgroundMedia = new MediaPlayer(backgroundLoading);
    public static MediaView mediaView = new MediaView(backgroundMedia);

    //Credits
    public static double highestScoresTitleXtranslate = 350;
    public static double highestScoresTitleYtranslate = 25;

    public static Image image1 = new Image("file:Assets\\Space.png");
    public static ImageView creditsBackground = new ImageView(image1);


    public static double backButtonXtranslate = 400;
    public static double backButtonYtranslate = 400;

    public static Color highestScoresTitle = Color.valueOf("#FFFDE7");

    //Game
    public static double scoreIndentation = 25;

    public static Image guideLoading = new Image("file:Assets\\Guide.png");
    public static ImageView guide = new ImageView(guideLoading);

    public static Image playerOneWinsLoading= new Image("file:Assets\\Player one wins.png");
    public static ImageView playerOneWins = new ImageView(playerOneWinsLoading);

    public static Image playerTwoWinsLoading= new Image("file:Assets\\Player two wins.png");
    public static ImageView playerTwoWins = new ImageView(playerTwoWinsLoading);


    public static Font scoreFont = Font.loadFont("file:Fonts\\hemi head bd.ttf",18);

    //Stick
    public static double stickWidth= 150;
    public static double stickHeight= 15;
    public static double stickArcWidth= 7;
    public static double stickArcHeight= 7;
    public static double stickSpeed= 10;
    public static Color stickColor= Color.valueOf("#FFAB40");

    //Right Stick
    public static Image rightStickLoading = new Image("file:Assets\\Right Stick.png");
    public static ImagePattern rightStickColor= new ImagePattern(rightStickLoading);

    //Left Stick
    public static Image leftStickLoading = new Image("file:Assets\\Left Stick.png");
    public static ImagePattern leftStickColor= new ImagePattern(leftStickLoading);

    //Ball
    public static double ballRadius= 10;
    public static Image ballLoading = new Image("file:Assets\\PlanetB.png");
    public static ImagePattern ballColor = new ImagePattern(ballLoading);
    public static double maxSpeed= 7;

    //Bricks
    public static double brickWidth= 50;
    public static double brickHeight= 15;
    public static double brickNumCols= 10;
    public static double brickNumRows= 20;
    public static double uniqueRocksNum= 10;

    public static Image normalBrick = new Image("file:Assets\\Normal Brick.png");
    public static Image addingBallsBrick = new Image("file:Assets\\Unique Brick 1.png");
    public static Image removingBricks = new Image("file:Assets\\Unique Brick 2.png");


    //Multiple balls feature
    public static double numAdditionBalls= 5;

    //Destroy rows and colls feature

    //Fonts
    public static Font buttonFont = Font.loadFont("file:Fonts\\hemi head bd.ttf",18);
    public static Font creditsFont = Font.loadFont("file:Fonts\\hemi head bd.ttf",25);
    public static Font titleFont = Font.loadFont("file:Fonts\\Future TimeSplitters.otf",115);

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
