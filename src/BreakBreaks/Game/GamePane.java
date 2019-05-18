package BreakBreaks.Game;

import BreakBreaks.Config;
import BreakBreaks.Interface.MainMenuScene;
import javafx.animation.AnimationTimer;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import static BreakBreaks.Config.guide;
import static BreakBreaks.Interface.MainMenuPane.setBackgroundVideo;

public class GamePane extends Pane {
    private Player[] players;
    private boolean start;
    Stage primaryStage;
    MainMenuScene mainMenuScene;

    AnimationTimer gameLoop;

    public GamePane() {

        initializeGame();
        gameLoop();

    }

    public void initializeGame(){
        //Background Picture
        Image gameBackgroundLoading = new Image("file:Assets\\Cartoon Planet.jpeg");
        ImageView gameBackground = new ImageView(gameBackgroundLoading);
        gameBackground.setOpacity(0.9);
        gameBackground.setFitWidth(Config.screenWidth);
        gameBackground.setFitHeight(Config.screenHeight);

        Rectangle barrier = new Rectangle(Config.screenWidth/2 - 8,25,5,Config.screenHeight - 43);
        barrier.setFill(Color.WHITESMOKE);
        barrier.setArcHeight(5);
        barrier.setArcHeight(5);

        getChildren().add(gameBackground);
        getChildren().add(barrier);

        players= new Player[2];
        players[0]= new Player(new Frame(0, 0, Config.screenWidth/2, Config.screenHeight), KeyCode.A, KeyCode.D, KeyCode.SPACE,Config.leftStickColor);
        players[1]= new Player(new Frame(Config.screenWidth/2, 0, Config.screenWidth, Config.screenHeight), KeyCode.LEFT, KeyCode.RIGHT, KeyCode.ENTER,Config.rightStickColor);


        for (int i=0; i < players.length; i++){
            getChildren().add(players[i]);
        }

        guide.setFitHeight(Config.screenHeight);
        guide.setFitWidth(Config.screenWidth);
        getChildren().add(guide);

        setOnKeyPressed(e->{
            if (!(getChildren().remove(guide))){
                KeyManager.setkeystate(e.getCode(), true);
            }
        });
        setOnKeyReleased(e->{
            KeyManager.setkeystate(e.getCode(), false);
        });

    }
    public void gameLoop(){
        gameLoop= new AnimationTimer(){
            @Override
            public void handle(long now) {
                updateGame();
            }
        };
        gameLoop.start();
    }

    private void updateGame() {

        //Move Stick with controllers
        for (int i=0; i < players.length; i++){
            //Play function returns the score of each player
            //You can get the status of each player as well by using hasWon, hasLost data members
            if(!players[i].hasWon && !players[i].hasLost ){
                players[i].play();
            }else{
                if (players[i].hasWon)
                {
                    getChildren().add(i == 0 ? Config.playerOneWins : Config.playerTwoWins);
                    Config.winningSound.play();
                    backButton();
                }
                if (players[i].hasLost)
                {
                    getChildren().add(i == 0 ? Config.playerTwoWins : Config.playerOneWins);
                    Config.winningSound.play();
                    backButton();
                }
                gameLoop.stop();
                break;
            }

        }

    }
    public void backButton()
    {
        Button back= new Button("Main Menu");
        back.setStyle("-fx-background-color: black;" + "-fx-opacity: 0.7;");
        back.setPrefSize(Config.mainMenuButtonWidth,Config.mainMenuButtonHeight);
        back.setTextFill(Config.buttonTextColor);
        back.setFont(Config.buttonFont);
        back.setTranslateX(Config.backButtonXtranslate);
        back.setTranslateY(Config.backButtonYtranslate + 110);
        getChildren().add(back);

        //Actions
        back.setOnMouseEntered(event1 -> {
            back.setStyle("-fx-background-color: #FFFF8D;" + "-fx-opacity: 0.7;");
            back.setTextFill(Config.buttonTextColorOnAction);
        });
        back.setOnMouseExited(event1 -> {
            back.setStyle("-fx-background-color: black;" + "-fx-opacity: 0.7;");
            back.setTextFill(Config.buttonTextColor);
        });
        back.setOnAction(event ->
        {
            getChildren().clear();
            initializeGame();
            gameLoop();
            requestFocus();
            primaryStage.setScene(mainMenuScene);
            setBackgroundVideo(true);
            Config.gameInMusic().stop();
        } );


    }
}
