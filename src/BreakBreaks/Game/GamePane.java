package BreakBreaks.Game;

import BreakBreaks.Config;
import BreakBreaks.Interface.MainMenuScene;
import javafx.animation.AnimationTimer;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import static BreakBreaks.Config.guide;

public class GamePane extends Pane {
    private Player[] players;
    private boolean start;
    Stage primaryStage;
    MainMenuScene mainMenuScene;

    AnimationTimer gameLoop;
    Label playerOne;
    Label playerTwo;
    public GamePane() {

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

        initializeGame();
        gameLoop();

    }

    public void initializeGame(){
        players= new Player[2];
        players[0]= new Player(new Frame(0, 0, Config.screenWidth/2, Config.screenHeight), KeyCode.A, KeyCode.D, KeyCode.SPACE,Config.leftStickColor);
        players[1]= new Player(new Frame(Config.screenWidth/2, 0, Config.screenWidth, Config.screenHeight), KeyCode.LEFT, KeyCode.RIGHT, KeyCode.ENTER,Config.rightStickColor);

        //Player One Score Label
        Label playerOneScore = new Label("Score: " + players[0].score);
        playerOneScore.setFont(Config.scoreFont);
        playerOneScore.setTextFill(Color.valueOf("#E3F2FD"));
        getChildren().add(playerOneScore);

        //Player One Score Label
        Label playerTwoScore = new Label("Score: " + players[1].score);
        playerTwoScore.setFont(Config.scoreFont);
        playerTwoScore.setTextFill(Color.valueOf("#E3F2FD"));
        playerTwoScore.setTranslateX(Config.screenWidth/2);
        getChildren().add(playerTwoScore);

        guide.setFitHeight(Config.screenHeight);
        guide.setFitWidth(Config.screenWidth);
        getChildren().add(guide);

        setOnKeyPressed(e->{

            if (e.getCode() == KeyCode.ENTER)
                    {
                        getChildren().remove(guide);
                    }

            KeyManager.setkeystate(e.getCode(), true);
        }
        );
        setOnKeyReleased(e->{
            KeyManager.setkeystate(e.getCode(), false);
        });

        for (int i=0; i < players.length; i++){
            getChildren().add(players[i]);
        }

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
            }

        }
        if (players[0].hasWon)
        {
            getChildren().add(Config.playerOneWins);
            gameLoop.stop();
        }
        if (players[1].hasWon)
        {
            getChildren().add(Config.playerTwoWins);
            gameLoop.stop();
        }

    }
    public void guideScreenShow()
    {
        guide.setFitHeight(Config.screenHeight);
        guide.setFitWidth(Config.screenWidth);
        getChildren().add(guide);
        setOnKeyPressed(event ->
        {
            if (event.getCode() == KeyCode.ENTER)
            {
                getChildren().remove(guide);

            }
        });
    }
    public void addingLabel(Label playerScore,Player player[],int index,double x, double y)
    {
        playerScore = new Label("Score: " + player[index].score);
        playerScore.setFont(Config.scoreFont);
        playerScore.setTextFill(Color.valueOf("#E3F2FD"));
        getChildren().add(playerScore);
    }

}
