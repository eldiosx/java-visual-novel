package application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LoadingScreen extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/src/application/LoadingScreen.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/src/application/Loading-screen.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();

		Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), ae -> primaryStage.close()));
		timeline.play();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
