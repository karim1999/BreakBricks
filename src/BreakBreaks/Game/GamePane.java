package BreakBreaks.Game;

import BreakBreaks.Config;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

public class GamePane extends Pane {
    private Player[] players;
    private boolean start;

    public GamePane() {

        //Background Picture


        initializeGame();
        gameLoop();
    }

    private void initializeGame(){
        players= new Player[2];
        players[0]= new Player(new Frame(0, 0, Config.screenWidth/2, Config.screenHeight), KeyCode.LEFT, KeyCode.RIGHT, KeyCode.ENTER);
        players[1]= new Player(new Frame(Config.screenWidth/2, 0, Config.screenWidth, Config.screenHeight), KeyCode.A, KeyCode.D, KeyCode.SPACE);

        setOnKeyPressed(e->{
            KeyManager.setkeystate(e.getCode(), true);
        });
        setOnKeyReleased(e->{
            KeyManager.setkeystate(e.getCode(), false);
        });

        for (int i=0; i < players.length; i++){
            getChildren().add(players[i]);
        }
    }
    public void gameLoop(){
        new AnimationTimer(){
            @Override
            public void handle(long now) {
                updateGame();
            }
        }.start();
    }

    private void updateGame() {

        //Move Stick with controllers
        for (int i=0; i < players.length; i++){
            players[i].play();
        }
    }
}
