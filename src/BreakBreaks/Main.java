package BreakBreaks;

import BreakBreaks.Game.GamePane;
import BreakBreaks.Game.GameScene;
import BreakBreaks.Interface.HighestScores;
import BreakBreaks.Interface.HighestScoresScene;
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

        HighestScores highestScores = new HighestScores(primaryStage);
        HighestScoresScene highestScoresScene = new HighestScoresScene(highestScores);

        MainMenuPane mainMenuPane= new MainMenuPane(primaryStage,gameScene);
        MainMenuScene mainMenuScene= new MainMenuScene(mainMenuPane);

        //mainMenuPane.backgroundMusic();

        //Set Stage
        highestScoresScene.setStage(primaryStage);
        mainMenuScene.setStage(primaryStage);
        gameScene.setStage(primaryStage);

        //SetScene
        highestScoresScene.setMainMenuScene(mainMenuScene);
        mainMenuScene.setHighScoresScene(highestScoresScene);
        gameScene.setMainMenuScene(mainMenuScene);
        mainMenuScene.setGameScene(gameScene);

        primaryStage.setScene(mainMenuScene);
        gamePane.requestFocus();
        primaryStage.show();
    }
}
