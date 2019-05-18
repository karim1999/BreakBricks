package BreakBreaks.Interface;

import BreakBreaks.Config;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class CreditsPane extends Pane {

    Stage primaryStage;
    MainMenuScene mainMenuScene;

    private double buttonWidth = 250;
    private double buttonHeight = 30;

    private double MenuItemWidth = 250;
    private double MenuItemHeight = 50;


    public CreditsPane(Stage primaryStage) {
        this.setPrefSize(Config.screenWidth, Config.screenHeight);

        double screenWidth= Config.screenWidth;
        double screenHeight= Config.screenHeight;


        //1. Highest Scores Background
        this.setStyle("-fx-background-color: transparent;");
        Config.creditsBackground.setFitWidth(Config.screenWidth);
        Config.creditsBackground.setFitHeight(Config.screenHeight);
        this.getChildren().add(Config.creditsBackground);

        //2. Label Screen Resolution
        Label screenResolution = new Label("Credits");
        screenResolution.setFont(Config.HighestScoresTitleFont);
        screenResolution.setTextFill(Config.highestScoresTitle);
        screenResolution.setTranslateX(Config.highestScoresTitleXtranslate);
        screenResolution.setTranslateY(Config.highestScoresTitleYtranslate);
        getChildren().add(screenResolution);

        //Texts
        Text text = new Text("The game is made by:");
        Text text1 = new Text("Mostafa Saad");
        Text text2 = new Text("Karim Mahamoud");
        Text text3 = new Text("Nour El Din");
        Text text4 = new Text("Ahmad Abd Elaziz");

        text.setFont(Config.creditsFont);
        text1.setFont(Config.creditsFont);
        text2.setFont(Config.creditsFont);
        text3.setFont(Config.creditsFont);
        text4.setFont(Config.creditsFont);

        text.setFill(Color.WHITE);
        text1.setFill(Color.WHITE);
        text2.setFill(Color.WHITE);
        text3.setFill(Color.WHITE);
        text4.setFill(Color.WHITE);

        VBox vBox = new VBox();
        vBox.setSpacing(20);
        vBox.getChildren().addAll(text,text1,text2,text3,text4);

        vBox.setTranslateX(80);
        vBox.setTranslateY(150);

        getChildren().add(vBox);

        Button backButton= new Button("Back");
        backButton.setStyle("-fx-background-color: black;" + "-fx-opacity: 0.7;");
        backButton.setPrefSize(Config.mainMenuButtonWidth,Config.mainMenuButtonHeight);
        backButton.setTextFill(Config.buttonTextColor);
        backButton.setFont(Config.buttonFont);
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
