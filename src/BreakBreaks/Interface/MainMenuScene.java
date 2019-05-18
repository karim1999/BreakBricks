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
    public void setHighScoresScene(CreditsScene creditsScene){
        root.creditsScene = creditsScene;
    }
    public void setGameScene(GameScene gameScene){
        root.gameScene= gameScene;
    }
}
