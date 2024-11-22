package com.codecool.dungeoncrawl.ui.elements;

import javafx.animation.PauseTransition;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;


public class MainStage {
    private Canvas canvas;
    private Scene scene;
    private StatusPane statusPane;
    private StackPane mainContainer;
    private VBox gameOverDisplay = new VBox(10);
    private Label gameOverText = new Label("GAME OVER");

    public MainStage(Canvas canvas) {
        this.canvas = canvas;
        statusPane = new StatusPane();
        scene = setUpScene();
    }

    private Scene setUpScene() {
        BorderPane borderPane = statusPane.build();
        borderPane.setCenter(canvas);

        createGameOverDisplay();
        mainContainer = new StackPane(borderPane, gameOverDisplay);
        Scene scene = new Scene(mainContainer);
        return scene;
    }

    private void createGameOverDisplay() {
        gameOverDisplay.setStyle(("-fx-background-color: rgba(0, 0, 0, 0.8); -fx-padding: 90;"));
        gameOverDisplay.setMaxWidth(400);
        gameOverDisplay.setMaxHeight(200);

        gameOverText.setFont(Font.font(36));
        gameOverText.setTextFill(Color.RED);
        gameOverText.setTextAlignment(TextAlignment.JUSTIFY);

        gameOverDisplay.getChildren().add(gameOverText);
        gameOverDisplay.setVisible(false);

    }

    public void showGameOver() {
        gameOverDisplay.setVisible(true);
        PauseTransition delay = new PauseTransition(Duration.seconds(2));
        delay.setOnFinished(e -> {
            // Perform cleanup if necessary
            Platform.exit(); // Graceful exit for JavaFX applications
        });
        delay.play();
    }

    public void hideGameOver() {
        gameOverDisplay.setVisible(false);
    }

    public Scene getScene() {
        return scene;
    }

    public void setHealthLabelText(String text) {
        this.statusPane.setHealthValue(text);
    }

    public void setInventoryLabelText(String text) {
        this.statusPane.setInventoryValue(text);
    }

}