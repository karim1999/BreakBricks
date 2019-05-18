package BreakBreaks.Interface;


import BreakBreaks.Config;
import BreakBreaks.Game.GameScene;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.io.File;

import static BreakBreaks.Config.backgroundMedia;
import static BreakBreaks.Config.mediaView;

public class MainMenuPane extends Pane {
    Stage primaryStage;
    HighestScoresScene highestScoresScene;
    GameScene gameScene;

    private int currentItem = 0;

    public MainMenuPane(Stage primaryStage,Scene startGameScene)
    {
        this.setPrefSize(Config.screenWidth, Config.screenHeight);

        double screenWidth= Config.screenWidth;
        double screenHeight= Config.screenHeight;

        //Background Video
        setBackgroundVideo(true);
        getChildren().add(mediaView);

        //Uploading Sounds
        String path = "Sounds\\Button sound.wav";
        Media media = new Media(new File(path).toURI().toString());
        MediaPlayer ButtonHovering = new MediaPlayer(media);

        //3. Title
        Text gameTitle= new Text(Config.mainMenuTitleXtranslate,Config.mainMenuTitleYtranslate,"Break Bricks");
        gameTitle.setFont(Config.titleFont);

        //Gradient Color For Title
        Stop[] stops = new Stop[] { new Stop(0, Color.valueOf("#845EC2")), new Stop(1, Color.valueOf("#EEFF41"))};
        LinearGradient linearGradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);

        gameTitle.setFill(linearGradient);
        getChildren().add(gameTitle);

        //Buttons
        //Start Game Button
        Button startGame = new Button("Start Game");
        startGame.setStyle("-fx-background-color: black;" + "-fx-opacity: 0.7;");
        startGame.setPrefSize(Config.mainMenuButtonWidth,Config.mainMenuButtonHeight);
        startGame.setTextFill(Config.buttonTextColor);
        startGame.setFont(Config.buttonFont);

        //Highest Scores
        Button highestScore = new Button("Highest Scores");
        highestScore.setStyle("-fx-background-color: black;" + "-fx-opacity: 0.7;");
        highestScore.setPrefSize(Config.mainMenuButtonWidth,Config.mainMenuButtonHeight);
        highestScore.setTextFill(Config.buttonTextColor);
        highestScore.setFont(Config.buttonFont);

        //Exit Button
        Button exit = new Button("Exit");
        exit.setStyle("-fx-background-color: black;" + "-fx-opacity: 0.7;");
        exit.setPrefSize(Config.mainMenuButtonWidth,Config.mainMenuButtonHeight);
        exit.setTextFill(Config.buttonTextColor);
        exit.setFont(Config.buttonFont);

        //Actions
        //Start Game Button
        startGame.setOnMouseEntered(event1 -> {
            startGame.setTextFill(Config.buttonTextColorOnAction);
            startGame.setStyle("-fx-background-color: #FFFF8D;" + "-fx-opacity: 0.7;");
            ButtonHovering.play();
        });

        startGame.setOnMouseExited(event1 -> {
            startGame.setStyle("-fx-background-color: black;" + "-fx-opacity: 0.7;");
            startGame.setTextFill(Config.buttonTextColor);
            ButtonHovering.stop();
        });
        startGame.setOnAction(event ->
        {
            primaryStage.setScene(startGameScene);
            setBackgroundVideo(false);
        });



        //Options Button
        highestScore.setOnMouseEntered(event1 -> {
            highestScore.setStyle("-fx-background-color: #FFFF8D;" + "-fx-opacity: 0.7;");
            highestScore.setTextFill(Config.buttonTextColorOnAction);
            ButtonHovering.play();
        });
        highestScore.setOnMouseExited(event1 -> {
            highestScore.setStyle("-fx-background-color: black;" + "-fx-opacity: 0.7;");
            highestScore.setTextFill(Config.buttonTextColor);
            ButtonHovering.stop();
        });
        highestScore.setOnAction(event -> {
            primaryStage.setScene(highestScoresScene);
        });


        //Exit Button
        exit.setOnMouseEntered(event1 -> {
            exit.setStyle("-fx-background-color: #FFFF8D;" + "-fx-opacity: 0.7;");
            exit.setTextFill(Config.buttonTextColorOnAction);
            ButtonHovering.play();
        });
        exit.setOnMouseExited(event1 -> {
            exit.setStyle("-fx-background-color: black;" + "-fx-opacity: 0.7;");
            exit.setTextFill(Config.buttonTextColor);
            ButtonHovering.stop();
        });
        exit.setOnAction(event -> {
            System.exit(0);
        });


        //Menu Box
        VBox menuBox = new VBox();
        menuBox.setSpacing(30);
        menuBox.setTranslateX(Config.menuBoxXtranslation);
        menuBox.setTranslateY(Config.menuBoxYtranslation);
        menuBox.getChildren().addAll(startGame,highestScore,exit);
        getChildren().add(menuBox);

        //Switching
        menuBox.setOnKeyPressed(event ->
        {   if (event.getCode() == KeyCode.DOWN) {
            switch (currentItem) {
                case 0:
                case 1:
                    disableButton(exit);
                    down();
                    enableButton(startGame);
                    break;
                case 2:
                    disableButton(startGame);
                    down();
                    enableButton(highestScore);
                    break;
                case 3:
                    disableButton(highestScore);
                    down();
                    enableButton(exit);
                    break;
            }
        }
        else if (event.getCode() == KeyCode.UP)
            switch (currentItem) {
                case 0:
                case 1:
                    disableButton(startGame);
                    up();
                    enableButton(exit);
                    break;
                case 2:
                    disableButton(highestScore);
                    up();
                    enableButton(startGame);
                    break;
                case 3:
                    disableButton(exit);
                    up();
                    enableButton(highestScore);
                    break;
            }

        else if (event.getCode()== KeyCode.ENTER)
        {
            switch (currentItem)
            {
                case 0:
                case 1:
                    primaryStage.setScene(startGameScene);
                    break;
                case 2:
                    primaryStage.setScene(highestScoresScene);
                    break;
                case 3:
                    System.exit(0);

            }
        }});

    }


    public void up()
    {
        currentItem--;
        if (currentItem== 0 || currentItem == -1 ) { currentItem = 3; }

    }
    public void down()
    {
        currentItem++;
        if (currentItem == 4) { currentItem = 1; }

    }
    public void disableButton (Button button)
    {
        button.setStyle("-fx-background-color: black;" + "-fx-opacity: 0.7;");
        //button.setTextFill(Color.YELLOWGREEN);
        button.setTextFill(Config.buttonTextColor);
        buttonSound().stop();
    }
    public void enableButton (Button button)
    {
        button.setStyle("-fx-background-color: #FFFF8D;" + "-fx-opacity: 0.7;");
        //button.setTextFill(Color.WHITESMOKE);
        button.setTextFill(Config.buttonTextColorOnAction);
        buttonSound().play();
    }
    public MediaPlayer buttonSound()
    {
        String path = "Sounds\\Button sound.wav";
        Media media = new Media(new File(path).toURI().toString());
        MediaPlayer buttonHovering = new MediaPlayer(media);
        return buttonHovering;
    }
    public static void setBackgroundVideo(Boolean check)
    {

        mediaView.setFitHeight(Config.screenHeight);
        mediaView.setFitWidth(Config.screenWidth);

        if (check==true)
        {
            Config.backgroundMedia.setCycleCount(MediaPlayer.INDEFINITE);
            backgroundMedia.play();
        }else
            {
                backgroundMedia.stop();
            }
    }
    public void backgroundMusic()
    {
        String backgroundMusicPath= "Sounds\\Chrimstas Track.wav";
        Media backgroundMedia= new Media(new File(backgroundMusicPath).toURI().toString());
        MediaPlayer backgroundMusic = new MediaPlayer(backgroundMedia);
        backgroundMusic.setCycleCount(MediaPlayer.INDEFINITE);
        backgroundMusic.play();

    }

}
