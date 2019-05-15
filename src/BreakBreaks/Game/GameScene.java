package BreakBreaks.Game;

import BreakBreaks.Interface.MainMenuPane;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameScene extends Scene {
    GamePane root;
    Stage primaryStage;
    public GameScene(GamePane root, Stage primaryStage, double width, double height)
    {
        super(root, width, height);
        this.root= root;
        this.primaryStage= primaryStage;
    }
    public Stage getPrimaryStage() {
        return primaryStage;
    }

}
