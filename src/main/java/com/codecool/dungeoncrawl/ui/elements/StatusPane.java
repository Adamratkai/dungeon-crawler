package com.codecool.dungeoncrawl.ui.elements;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.geometry.VPos;

public class StatusPane {
    public static final int RIGHT_PANEL_WIDTH = 200;
    public static final int RIGHT_PANEL_PADDING = 10;
    private GridPane ui;
    private Label healthTextLabel;
    private Label healthValueLabel;
    private Label inventoryTextLabel;
    private Label inventoryValueLabel;

    public StatusPane() {
        ui = new GridPane();
        healthTextLabel = new Label("Health: ");
        inventoryTextLabel = new Label("Inventory: ");
        healthValueLabel = new Label();
        inventoryValueLabel = new Label();
        inventoryValueLabel.setWrapText(true);
    }

    public BorderPane build() {

        ui.setPrefWidth(RIGHT_PANEL_WIDTH);
        ui.setPadding(new Insets(RIGHT_PANEL_PADDING));

        ui.add(healthTextLabel, 0, 0);
        ui.add(healthValueLabel, 1, 0);
        ui.add(inventoryTextLabel, 0, 1);
        GridPane.setValignment(inventoryTextLabel, VPos.TOP);
        ui.add(inventoryValueLabel, 1, 1);
        GridPane.setValignment(inventoryValueLabel, VPos.TOP);

        BorderPane borderPane = new BorderPane();
        borderPane.setRight(ui);
        return borderPane;
    }

    public void setHealthValue(String text) {
        healthValueLabel.setText(text);
    }

    public void setInventoryValue(String text) {
        inventoryValueLabel.setText(text);
    }

}
