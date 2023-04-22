package Trash;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TextAnimation extends Application {

    private int currentIndex = 0;
    private String text = "Este es un texto de ejemplo.";
    private Timeline timeline;

    @Override
    public void start(Stage primaryStage) {
        Text textNode = new Text("");
        textNode.setFont(Font.font("Arial", 24));
        StackPane root = new StackPane(textNode);
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

        timeline = new Timeline(
                new KeyFrame(Duration.seconds(0.1), event -> {
                    if (currentIndex > text.length()) {
                        timeline.stop();
                    } else {
                        String currentText = text.substring(0, currentIndex);
                        textNode.setText(currentText);
                        currentIndex++;
                    }
                })
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
