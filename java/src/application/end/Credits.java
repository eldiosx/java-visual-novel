package application.end;

import java.io.File;

import application.BackgroundMusic;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Credits extends Application {

	private BackgroundMusic backgroundMusic = new BackgroundMusic();
	static double screenHeight = Screen.getPrimary().getVisualBounds().getHeight();
	static double screenWidth = Screen.getPrimary().getVisualBounds().getWidth();
	double responsive = screenWidth * 0.07; // 7% del ancho de la pantalla RESPONSIVE++
	private static final String RESOURCES_PATH = new File("assets").getAbsolutePath();

	@Override
	public void start(Stage stage) {
		backgroundMusic.playAudio(RESOURCES_PATH + "/audio/horrorBellaciao.ogg");
		// Crear el texto que se mostrará en los créditos
		Text creditsText = new Text("Hace muchos tiempo, en un MEDAC casi en Córdoba, un equipo de desarrolladores \n\n"
				+ "empezaron un ambicioso proyecto. \n\n " + "Los disturbios rodean el MEDAC \n\n"
				+ "Se esta planteando el cobro de impuestos al temario desactualizado \n\n"
				+ "por parte de los miembros descontentos de la comunidad \n\n"
				+ "y emigrar a sistemas solares con mejores prestaciones. \n\n" + "\n\n"
				+ "Esperando resolver el problema con un bloqueo \n\n" + "táctico a Yessi, la codiciosa, \n\n"
				+ "la alianza rebelde se enfrenta a nuevos retos. \n\n" + "\n\n" + "\n\n" + "\n\n" + "\n\n"
				+ "Desarrollado por Kawaii Developers \n\n"
				+ "Nico Cano, Daniel Delgado, Aida Fernández y Adri Márquez\n\n" + "\n\n" + "\n\n"
				+ "Proyecto realizado usando:\n\n" + "Java \n\n" + "Java FX \n\n" + "Scene Builder \n\n" + "SQL \n\n"
				+ "Audacity \n\n" + "\n\n" + "\n\n" + "Desarrollo: \n\n" + "Database Manager: Nico Cano\n\n "
				+ "Diseño: Aida Fernández\n\n" + "Frontend Manager: Adrián Marquez\n\n"
				+ "Backend Manager: Daniel Delgado\n\n" + "\n\n" + "\n\n" + "Actores de voz: \n\n"
				+ "John: Nico Cano \n\n" + "Marleene: Esther Argüelles\n\n" + "Travis: Javier Naranjo\n\n"
				+ "Helen: Aida Fernández\n\n" + "Chan: Adri Marquez \n\n" + "Sr Watson: Daniel Delgado \n\n" + "\n\n"
				+ "\n\n" + "Agradecimientos especiales \n\n"
				+ "Javier naranjo y Esther Argüelles por trabajar a cambio de un vinito \n\n"
				+ "Juan García y Antonio Ruiz por sus consejos y paciencia \n\n");
		creditsText.setFont(new Font("Arial", responsive / 4));
		creditsText.setFill(Color.WHITE);
		creditsText.setX(500);
		creditsText.setY(1000);

		// Crear el grupo de nodos que contendrá el texto
		Group creditsGroup = new Group(creditsText);

		// Crear la animación de movimiento para los créditos
		TranslateTransition creditsAnimation = new TranslateTransition();
		creditsAnimation.setDuration(Duration.seconds(30));
		creditsAnimation.setNode(creditsGroup);
		creditsAnimation.setToY(-10000);

		// Crear la escena
		Scene scene = new Scene(creditsGroup, 1000, 1000, Color.BLACK);
		scene.setOnMouseClicked(event -> {
			creditsAnimation.stop();
			creditsAnimation.setToY(-10000);
			creditsAnimation.play();
		});

		// Mostrar la escena
		stage.setScene(scene);
		stage.setTitle("Tu videojuego favorito de serie B");
		stage.setResizable(true); // Se puede redimensionar
		stage.setFullScreen(true); // Abre la ventana en pantalla completa
		stage.setMinWidth(800); // Establece el ancho mínimo de la ventana en 800px
		stage.setMinHeight(600); // Establece la altura mínima de la ventana en 600px
		stage.show();

		// Iniciar la animación
		creditsAnimation.play();
	}

	public static void main(String[] args) {
		launch();
		Platform.exit(); // El cierratodo de JavaFX
		System.exit(0); // El cierratodo clasico
	}

}
