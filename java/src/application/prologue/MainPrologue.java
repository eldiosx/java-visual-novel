package application.prologue;

import java.io.File;

import application.prologue.MainPrologue;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MainPrologue extends Application {

	private static final String RESOURCES_PATH = new File("assets").getAbsolutePath();
	static double screenHeight = Screen.getPrimary().getVisualBounds().getHeight();
	static double screenWidth = Screen.getPrimary().getVisualBounds().getWidth();
	double responsive = screenWidth * 0.07; // 7% del ancho de la pantalla RESPONSIVE++
	private static Stage stage1;
	private static Stage currentStage;
	static Image icon = new Image(new File(RESOURCES_PATH + "/icons/icon.png").toURI().toString());

	@Override
	public void start(Stage stage1) throws Exception {
		// Cargar el archivo FXML para el primer Stage
		Parent root = FXMLLoader.load(getClass().getResource("Prologue1.fxml"));
		MainPrologue.stage1 = stage1;
		MainPrologue.currentStage = stage1;
		stage1.setTitle("Tu videojuego favorito de serie B");
		stage1.setScene(new Scene(root, screenWidth, screenHeight));
		stage1.setResizable(false); // Se puede redimensionar
		stage1.setFullScreen(true); // Abre la ventana en pantalla completa
		stage1.setMinWidth(800); // Establece el ancho mínimo de la ventana en 800px
		stage1.setMinHeight(600); // Establece la altura mínima de la ventana en 600px
		stage1.getIcons().add(icon);
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
		MainPrologue.currentStage = stage;
		stage.setTitle("Tu videojuego favorito de serie B");
		stage.show();
	}

	public static Stage createStage(String fxmlFile, String title) throws Exception {
		Stage stage = new Stage();
		Parent root = FXMLLoader.load(MainPrologue.class.getResource(fxmlFile));
		stage.setTitle(title);
		stage.setScene(new Scene(root, screenWidth, screenHeight));
		stage.setResizable(false); // Se puede redimensionar
		stage.setFullScreen(true); // Abre la ventana en pantalla completa
		stage.setMinWidth(800); // Establece el ancho mínimo de la ventana en 800px
		stage.setMinHeight(600); // Establece la altura mínima de la ventana en 600px
		stage.getIcons().add(icon);
		MainPrologue.currentStage = stage;
		return stage;
	}

	public static Stage getPrimaryStage() {
		return stage1;
	}

	public static Stage getCurrentStage() {
		return currentStage;
	}

}
