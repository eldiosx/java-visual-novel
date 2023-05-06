package application.ep1;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MainEp1 extends Application {

	static double screenHeight = Screen.getPrimary().getVisualBounds().getHeight();
	static double screenWidth = Screen.getPrimary().getVisualBounds().getWidth();
	double responsive = screenWidth * 0.07; // 7% del ancho de la pantalla RESPONSIVE++
	private static Stage stage1;
	private static Stage currentStage;

	@Override
	public void start(Stage stage1) throws Exception {
		// Cargar el archivo FXML para el primer Stage
		Parent root = FXMLLoader.load(getClass().getResource("Stage0.fxml"));
		// MainEp1.stage2 = stage2; Cositas
		MainEp1.currentStage = stage1;
		stage1.setTitle("Tu videojuego favorito de serie B");
		stage1.setScene(new Scene(root, screenWidth, screenHeight));
		stage1.setResizable(false); // Se puede redimensionar
		stage1.setFullScreen(true); // Abre la ventana en pantalla completa
		stage1.setMinWidth(800); // Establece el ancho mínimo de la ventana en 800px
		stage1.setMinHeight(600); // Establece la altura mínima de la ventana en 600px
		stage1.show();
	}

	public static void main(String[] args) {
		launch(args);
		Platform.exit(); // El cierratodo de JavaFX
		System.exit(0); // El cierratodo clasico
	}

	public static void hideStage(Stage stage) {
		stage.hide();
	}

	public static void showStage(Stage stage) {
		stage.setTitle("Tu videojuego favorito de serie B");
		stage.setResizable(false); // Se puede redimensionar
		stage.setFullScreen(true); // Abre la ventana en pantalla completa
		stage.setMinWidth(800); // Establece el ancho mínimo de la ventana en 800px
		stage.setMinHeight(600); // Establece la altura mínima de la ventana en 600px
		stage.show();
		MainEp1.currentStage = stage;
	}

	public static Stage createStage(String fxmlFile, String title) throws Exception {
		Stage stage = new Stage();
		Parent root = FXMLLoader.load(MainEp1.class.getResource(fxmlFile));
		stage.setTitle(title);
		stage.setScene(new Scene(root, screenWidth, screenHeight));
		stage.setResizable(false); // Se puede redimensionar
		stage.setFullScreen(true); // Abre la ventana en pantalla completa
		stage.setMinWidth(800); // Establece el ancho mínimo de la ventana en 800px
		stage.setMinHeight(600); // Establece la altura mínima de la ventana en 600px
		return stage;
	}

	public static Stage getPrimaryStage() {
		return stage1;
	}

	public static Stage getCurrentStage() {
		return currentStage;
	}

}
