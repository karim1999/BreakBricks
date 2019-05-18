package BreakBreaks;

import BreakBreaks.Game.GamePane;
import BreakBreaks.Game.GameScene;
import BreakBreaks.Interface.CreditsPane;
import BreakBreaks.Interface.CreditsScene;
import BreakBreaks.Interface.MainMenuPane;
import BreakBreaks.Interface.MainMenuScene;
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
        GameScene gameScene= new GameScene(gamePane, primaryStage);

        CreditsPane creditsPane = new CreditsPane(primaryStage);
        CreditsScene creditsScene = new CreditsScene(creditsPane);

        MainMenuPane mainMenuPane= new MainMenuPane(primaryStage,gameScene);
        MainMenuScene mainMenuScene= new MainMenuScene(mainMenuPane);

        //mainMenuPane.gameInMusic();

        //Set Stage
        creditsScene.setStage(primaryStage);
        mainMenuScene.setStage(primaryStage);
        gameScene.setStage(primaryStage);

        //SetScene
        creditsScene.setMainMenuScene(mainMenuScene);
        mainMenuScene.setHighScoresScene(creditsScene);
        gameScene.setMainMenuScene(mainMenuScene);
        mainMenuScene.setGameScene(gameScene);

        primaryStage.setScene(mainMenuScene);
        gamePane.requestFocus();
        primaryStage.show();
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
    }
}
