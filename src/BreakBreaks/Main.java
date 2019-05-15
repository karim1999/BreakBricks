package BreakBreaks;

import BreakBreaks.Game.GamePane;
import BreakBreaks.Game.GameScene;
import BreakBreaks.MainMenu.MainMenuPane;
import BreakBreaks.MainMenu.MainMenuScene;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle(Config.gameTitle);

        GamePane gamePane= new GamePane();
        GameScene gameScene= new GameScene(gamePane, primaryStage, Config.screenWidth, Config.screenHeight);

        MainMenuPane mainMenuPane= new MainMenuPane();
        MainMenuScene mainMenuScene= new MainMenuScene(mainMenuPane, primaryStage);

        primaryStage.setScene(gameScene);
        gamePane.requestFocus();
        primaryStage.show();
    }
}
