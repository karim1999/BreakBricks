package BreakBreaks.Game;

import BreakBreaks.Interface.HighestScoresScene;
import BreakBreaks.Interface.MainMenuPane;
import BreakBreaks.Interface.MainMenuScene;
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

    public void setStage(Stage primaryStage){
        root.primaryStage= primaryStage;
    }
    public void setMainMenuScene(MainMenuScene mainMenuScene){
        root.mainMenuScene = mainMenuScene;
    }
}
