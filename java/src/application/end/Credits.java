package application.end;

//Java
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

//Local
import application.BackgroundMusic;
//JavaFX
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Credits extends Application {
	// Responsive (le queda algo)
	private BackgroundMusic backgroundMusic = new BackgroundMusic();
	static double screenHeight = Screen.getPrimary().getVisualBounds().getHeight();
	static double screenWidth = Screen.getPrimary().getVisualBounds().getWidth();
	double responsive = screenWidth * 0.07; // 7% del ancho de la pantalla RESPONSIVE++
	int wait = 60000;
	private static final String RESOURCES_PATH = new File("assets").getAbsolutePath();

	@Override
	public void start(Stage stage) {
		// Icon
		Image icon = new Image(new File(RESOURCES_PATH + "/icons/icon.png").toURI().toString());
		// Audio de fondo
		backgroundMusic.playAudio(RESOURCES_PATH + "/audio/horrorBellaciao.ogg");

		// Programar una tarea que se ejecute después de 30 segundos
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				Platform.runLater(() -> {
					// Cerrar la aplicación
					//backgroundMusic.stopAudio();
					Platform.exit(); // El cierratodo de JavaFX
					System.exit(0); // El cierratodo clasico
				});
			}
		}, wait); // 60 segundos en milisegundos (1min) + lo que surja

		// Crear el texto que se mostrará en los créditos y su estilo
		Text creditsText = new Text("Hace muchos tiempo, en un MEDAC casi en Córdoba, un equipo de desarrolladores\n\n"
				+ "empezaron un ambicioso proyecto.\n\n\n\n\n" + "Los disturbios rodean el planeta\n\n"
				+ "Se esta planteando el cobro de impuestos al consumo de oxigeno\n\n"
				+ "y emigrar a sistemas solares con mejores prestaciones.\n\n" + "\n\n"
				+ "Esperando resolver el problema con un bloqueo \n\n" + "táctico a Sanchez, el codicioso, \n\n"
				+ "la alianza rebelde se enfrenta a nuevos retos. \n\n\n\n\n\n"
				+ "Desarrollado por Kawaii Developers \n\n"
				+ "Nico Cano, Daniel Delgado, Aida Fernández y Adri Márquez\n\n\n\n\n\n"
				+ "Proyecto realizado usando:\n\n" + "Java 17 + FX, jdx, jorbis (ogg), Sql y sql connector\n\n"
				+ "Bellsoft Linux JDK\n\n" + "GLUON Scene Builder\n\n" + "DB Browser\n\n" + "Audacity\n\n" + "Gimp\n\n"
				+ "Linux 6.1 (Workstation & Server)\n\n" + "XAMPP\n\n" + "Oracle Database & Workbench\n\n" + "\n\n"
				+ "\n\n" + "Desarrollo: \n\n" + "Database Manager: Nico Cano\n\n" + "Diseño: Aida Fernández\n\n"
				+ "Frontend Manager: Adrián Marquez\n\n" + "Backend & Sound Manager: Daniel Delgado\n\n" + "\n\n"
				+ "\n\n" + "Actores de voz: \n\n" + "John: Nico Cano \n\n" + "Marleene: Esther Argüelles\n\n"
				+ "Travis: Javier Naranjo\n\n" + "Helen: Aida Fernández\n\n" + "Chan: Adri Marquez \n\n"
				+ "Sr Watson: Daniel Delgado \n\n" + "\n\n" + "\n\n" + "Agradecimientos especiales \n\n"
				+ "Javier naranjo y Esther Argüelles por trabajar a cambio de un vinito \n\n"
				+ "Juan García y Antonio Ruiz por sus consejos y paciencia <3\n\n" + "\n\n" + "\n\n" + "\n\n "
				+ "Repositorio de Github: \n\n" + "https://github.com/eldiosx/java-visual-novel \n\n\n\n\n\n"
				+ "FIN :D\n\n\n\n");
		creditsText.setFont(new Font("Arial", responsive / 3));
		creditsText.setFill(Color.WHITE);
		creditsText.setStyle("-fx-text-alignment: center;"); // Centrar
		creditsText.setY(1000);
		// Obtener el ancho del texto
		double textWidth = creditsText.getLayoutBounds().getWidth();

		// Calcular la posición x del texto en función del ancho del texto y del ancho
		// de la escena
		double textX = (screenWidth - textWidth) / 2;

		// Establecer la posición x del texto
		creditsText.setX(textX);

		// Crear el grupo de nodos que contendrá el texto
		Group creditsGroup = new Group(creditsText);

		// Crear la animación de movimiento para los créditos
		TranslateTransition creditsAnimation = new TranslateTransition();
		creditsAnimation.setDuration(Duration.seconds(55));
		creditsAnimation.setNode(creditsGroup);
		creditsAnimation.setToY(-10000);

		// Crear la escena
		Scene scene = new Scene(creditsGroup, 1000, 1000, Color.BLACK);
		// Esto hará que se pause un poco bastante al clickar con el ratón
		scene.setOnMouseClicked(event -> {
			wait = wait + 5000; // esto añadira un ratilloh más cada vez que se pause
			creditsAnimation.stop();
			creditsAnimation.setToY(-10000);
			creditsAnimation.play();
		});
		// Mostrar la escena
		stage.setScene(scene);
		stage.setTitle("Tu videojuego favorito de serie B");
		stage.setResizable(false); // Se puede redimensionar
		stage.setFullScreen(true); // Abre la ventana en pantalla completa
		stage.setMinWidth(800); // Establece el ancho mínimo de la ventana en 800px
		stage.setMinHeight(600); // Establece la altura mínima de la ventana en 600px
		stage.getIcons().add(icon);
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
