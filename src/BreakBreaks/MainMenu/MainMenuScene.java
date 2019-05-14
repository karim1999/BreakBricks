package BreakBreaks.MainMenu;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainMenuScene extends Scene {
    MainMenuPane root;
    Stage primaryStage;
    public MainMenuScene(MainMenuPane root, Stage primaryStage)
    {
        super(root);
        this.root= root;
        this.primaryStage= primaryStage;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }
}
