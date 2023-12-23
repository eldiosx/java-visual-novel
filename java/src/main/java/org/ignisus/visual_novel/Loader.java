package org.ignisus.visual_novel;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Loader extends Stage {
    private ProgressIndicator progressIndicator;

    public Loader() {
        progressIndicator = new ProgressIndicator();
        double responsiveSize = 0.4 * Math.min(Screen.getPrimary().getVisualBounds().getWidth(),
                                                Screen.getPrimary().getVisualBounds().getHeight());
        progressIndicator.setPrefSize(responsiveSize, responsiveSize);

        StackPane root = new StackPane();
        root.setAlignment(Pos.CENTER);
        root.getChildren().add(progressIndicator);

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());

        // Set the stage to full-screen mode
        setFullScreen(true);

        // Set the scene and ensure it covers the entire screen
        setScene(scene);
        setX(Screen.getPrimary().getVisualBounds().getMinX());
        setY(Screen.getPrimary().getVisualBounds().getMinY());
        setWidth(Screen.getPrimary().getVisualBounds().getWidth());
        setHeight(Screen.getPrimary().getVisualBounds().getHeight());
    }

    public ProgressIndicator getProgressIndicator() {
        return progressIndicator;
    }
}
