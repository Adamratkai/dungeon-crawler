package com.codecool.dungeoncrawl.ui;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.items.Item;
import com.codecool.dungeoncrawl.logic.GameLogic;
import com.codecool.dungeoncrawl.ui.elements.MainStage;
import com.codecool.dungeoncrawl.ui.keyeventhandler.KeyHandler;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

public class UI {
    private Canvas canvas;
    private GraphicsContext context;

    private MainStage mainStage;
    private GameLogic logic;
    private Set<KeyHandler> keyHandlers;


    public UI(GameLogic logic, Set<KeyHandler> keyHandlers) {
        this.canvas = new Canvas(
                logic.getMapWidth() * Tiles.TILE_WIDTH,
                logic.getMapHeight() * Tiles.TILE_WIDTH);
        this.logic = logic;
        this.context = canvas.getGraphicsContext2D();
        this.mainStage = new MainStage(canvas);
        this.keyHandlers = keyHandlers;
    }

    public void setUpPain(Stage primaryStage) {
        Scene scene = mainStage.getScene();
        primaryStage.setScene(scene);
        logic.setup();
        refresh();
        scene.setOnKeyPressed(this::onKeyPressed);
        moveMonsters();
    }

    private void moveMonsters() {
        class KeyFrameHandler implements EventHandler<ActionEvent>{
            private Timeline timeline;
            public void handle(ActionEvent event) {
                if (logic.getMap().getPlayer().getHealth() <= 0) {
                    timeline.stop();
                    mainStage.showGameOver();
                }else {
                    logic.getMap().moveMonsters();
                    refresh();
                }
            }
            public void setTimeline(Timeline timeline){
                this.timeline = timeline;
            }
        }
        KeyFrameHandler keyFrameHandler = new KeyFrameHandler();
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.5), keyFrameHandler));

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        keyFrameHandler.setTimeline(timeline);


    }


    private void onKeyPressed(KeyEvent keyEvent) {
        if (logic.getMap().getPlayer().getHealth() <= 0) {
            System.out.println("Game over");
            mainStage.showGameOver();
            return;
        };

        for (KeyHandler keyHandler : keyHandlers) {
            keyHandler.perform(keyEvent, logic.getMap());
        }

        refresh();
    }

    public void refresh() {
        context.setFill(Color.BLACK);
        int[] playerCoordinates = logic.getPlayerCoordinates();
        int playerX = playerCoordinates[0];
        int playerY = playerCoordinates[1];
        double mapHeight = logic.getMapHeight();
        double mapWidth = logic.getMapWidth();

        int canvasCenterX = (int) canvas.getWidth() / 2 / Tiles.TILE_WIDTH;
        int canvasCenterY = (int) canvas.getHeight() / 2 / Tiles.TILE_WIDTH;


        context.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (int x = 0; x < mapWidth; x++) {
            for (int y = 0; y < mapHeight; y++) {
                Cell cell = logic.getCell(x, y);
                if (cell.getActor() != null) {
                    if (cell.getType() == CellType.CLOSEDDOOR || cell.getType() == CellType.OPENDOOR) {
                        Tiles.drawTile(context, cell, x - playerX + canvasCenterX, y - playerY + canvasCenterY);
                    } else {
                        Tiles.drawTile(context, cell.getActor(), x - playerX + canvasCenterX, y - playerY + canvasCenterY);
                    }
                } else if (cell.getItem() != null) {
                    Tiles.drawTile(context, cell.getItem(), x - playerX + canvasCenterX, y - playerY + canvasCenterY);
                } else {
                    Tiles.drawTile(context, cell, x - playerX + canvasCenterX, y - playerY + canvasCenterY);

                }
                mainStage.setHealthLabelText(logic.getPlayerHealth());
                mainStage.setInventoryLabelText(logic.getPlayerInventory());
            }

        }
    }
}



