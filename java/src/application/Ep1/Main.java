package application.Ep1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	private static Stage primaryStage;
	private static Stage currentStage;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Cargar el archivo FXML para el primer Stage
		Parent root1 = FXMLLoader.load(getClass().getResource("Stage1.fxml"));
		Main.primaryStage = primaryStage;
		Main.currentStage = primaryStage;
		primaryStage.setTitle("Primer Stage");
		primaryStage.setScene(new Scene(root1, 400, 300));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public static void hideStage(Stage stage) {
		stage.hide();
	}

	public static void showStage(Stage stage) {
		stage.show();
		Main.currentStage = stage;
	}

	public static Stage createStage(String fxmlFile, String title, int width, int height) throws Exception {
		Stage stage = new Stage();
		Parent root = FXMLLoader.load(Main.class.getResource(fxmlFile));
		stage.setTitle(title);
		stage.setScene(new Scene(root, width, height));
		return stage;
	}

	public static Stage getPrimaryStage() {
		return primaryStage;
	}

	public static Stage getCurrentStage() {
		return currentStage;
	}

}
