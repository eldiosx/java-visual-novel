package application.Ep1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {

	double screenHeight = Screen.getPrimary().getVisualBounds().getHeight();
	double screenWidth = Screen.getPrimary().getVisualBounds().getWidth();
	double responsive = screenWidth * 0.07; // 7% del ancho de la pantalla RESPONSIVE++
	private static Stage primaryStage;
	private static Stage currentStage;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Cargar el archivo FXML para el primer Stage
		Parent root1 = FXMLLoader.load(getClass().getResource("Stage1.fxml"));
		Main.primaryStage = primaryStage;
		Main.currentStage = primaryStage;
		primaryStage.setTitle("Primer Stage");
		primaryStage.setScene(new Scene(root1, screenWidth, screenHeight));
		primaryStage.setResizable(false); // Se puede redimensionar
		primaryStage.setFullScreen(true); // Abre la ventana en pantalla completa
		primaryStage.setMinWidth(800); // Establece el ancho mínimo de la ventana en 800px
		primaryStage.setMinHeight(600); // Establece la altura mínima de la ventana en 600px
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public static void hideStage(Stage stage) {
		stage.hide();
	}

	public static void showStage(Stage stage) {
		stage.setResizable(false); // Se puede redimensionar
		stage.setFullScreen(true); // Abre la ventana en pantalla completa
		stage.setMinWidth(800); // Establece el ancho mínimo de la ventana en 800px
		stage.setMinHeight(600); // Establece la altura mínima de la ventana en 600px
		stage.show();
		Main.currentStage = stage;
	}

	public static Stage createStage(String fxmlFile, String title, int width, int height) throws Exception {
		Stage stage = new Stage();
		Parent root = FXMLLoader.load(Main.class.getResource(fxmlFile));
		stage.setTitle(title);
		stage.setScene(new Scene(root, width, height));
		stage.setResizable(false); // Se puede redimensionar
		stage.setFullScreen(true); // Abre la ventana en pantalla completa
		stage.setMinWidth(800); // Establece el ancho mínimo de la ventana en 800px
		stage.setMinHeight(600); // Establece la altura mínima de la ventana en 600px
		return stage;
	}

	public static Stage getPrimaryStage() {
		return primaryStage;
	}

	public static Stage getCurrentStage() {
		return currentStage;
	}

}
