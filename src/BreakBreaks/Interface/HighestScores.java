package BreakBreaks.Interface;

import BreakBreaks.Config;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class HighestScores extends Pane {

    Stage primaryStage;
    MainMenuScene mainMenuScene;

    private double buttonWidth = 250;
    private double buttonHeight = 30;

    private double MenuItemWidth = 250;
    private double MenuItemHeight = 50;


    public HighestScores(Stage primaryStage) {
        this.setPrefSize(Config.screenWidth, Config.screenHeight);

        double screenWidth= Config.screenWidth;
        double screenHeight= Config.screenHeight;

        //1. Highest Scores Background
        this.getChildren().add(Config.mediaView);

        //2. Label Screen Resolution
        Label screenResolution = new Label("Highest Scores");
        screenResolution.setFont(Config.HighestScoresTitleFont);
        screenResolution.setTextFill(Config.highestScoresTitle);
        screenResolution.setTranslateX(Config.highestScoresTitleXtranslate);
        screenResolution.setTranslateY(Config.highestScoresTitleYtranslate);
        getChildren().add(screenResolution);


        Button backButton= new Button("Back");
        backButton.setStyle("-fx-background-color: black;" + "-fx-opacity: 0.7;");
        backButton.setPrefSize(Config.mainMenuButtonWidth,Config.mainMenuButtonHeight);
        backButton.setTextFill(Config.buttonTextColor);
        backButton.setFont(Config.HemiHeadButtons);
        backButton.setTranslateX(Config.backButtonXtranslate);
        backButton.setTranslateY(Config.backButtonYtranslate);
        getChildren().add(backButton);

        //Back Action
        backButton.setOnMouseEntered(event1 -> {
            backButton.setStyle("-fx-background-color: #FFFF8D;" + "-fx-opacity: 0.7;");
            backButton.setTextFill(Config.buttonTextColorOnAction);
        });
        backButton.setOnMouseExited(event1 -> {
            backButton.setStyle("-fx-background-color: black;" + "-fx-opacity: 0.7;");
            backButton.setTextFill(Config.buttonTextColor);
        });
        backButton.setOnAction(event ->
        {
            primaryStage.setScene(mainMenuScene);
        });

    }

}
