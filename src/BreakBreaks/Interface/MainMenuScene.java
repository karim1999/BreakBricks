package BreakBreaks.Interface;
import BreakBreaks.Game.GameScene;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainMenuScene extends Scene {
    MainMenuPane root;
    public MainMenuScene(MainMenuPane root)
    {
        super(root);
        this.root= root;
    }
    public void setStage(Stage primaryStage){
        root.primaryStage= primaryStage;
    }
    public void setHighScoresScene(HighestScoresScene highestScoresScene){
        root.highestScoresScene = highestScoresScene;
    }
    public void setGameScene(GameScene gameScene){
        root.gameScene= gameScene;
    }
}
