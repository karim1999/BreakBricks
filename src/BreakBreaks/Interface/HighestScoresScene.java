package BreakBreaks.Interface;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HighestScoresScene extends Scene {
    HighestScores root;
    public HighestScoresScene(HighestScores root) {
        super(root);
        this.root= root;
    }
    public void setStage(Stage primaryStage){
        root.primaryStage= primaryStage;
    }
    public void setMainMenuScene(MainMenuScene mainMenuScene){
        root.mainMenuScene= mainMenuScene;
    }

}

