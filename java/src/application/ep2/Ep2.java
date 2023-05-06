package application.ep2;

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

public class Ep2 extends Application {

	private BackgroundMusic backgroundMusic = new BackgroundMusic();
	static double screenHeight = Screen.getPrimary().getVisualBounds().getHeight();
	static double screenWidth = Screen.getPrimary().getVisualBounds().getWidth();
	double responsive = screenWidth * 0.07; // 7% del ancho de la pantalla RESPONSIVE++
	private static final String RESOURCES_PATH = new File("assets").getAbsolutePath();

	private static Stage stageep2;
	private static Stage currentStage;

	@Override
	public void start(Stage stage) {
		backgroundMusic.playAudio(RESOURCES_PATH + "/audio/horrorBellaciao.ogg");
		// Crear el texto que se mostrará en los créditos
		Text creditsText = new Text("A la mañana siguiente gritos y voces exhaltadas perturban tu sueño.  \n\n"
				+ "Te vistes tan rápido como puedes y te dirijes a la cabaña principal. \n\n "
				+ "En ésta, casi todos los miembros del campamento se agolpan ante la puerta, \n\n"
				+ "unos llamando a voces al Sr Watson y pidiendo explicaciones, mientras, \n\n"
				+ "por otra parte, algunas de las chicas lloran desconsoladas.  \n\n" + "\n\n"
				+ "Entre las voces, aciertas a escuchar algo acerca del revuelo: \n\n"
				+ "Parece que ha aparecido el cadáver de una de las compañeras de campamento. \n\n" + "\n\n"
				+ "Mientras tratas de digerir lo que acabas de escuchar y rezas por que sea un error,\n\n"
				+ "el Sr Watson sale junto a el equipo de monitores del campamento.\n\n" + "\n\n"
				+ " SR. WATSON: Compañeros, necesito un poco de vuestro silencio. \n\n"
				+ "Esta noche ha aparecido muerta una de las compañeras. Esta fatal noticia aún no tiene explicación. \n\n"
				+ "Se la ha trasladado al hospital tan rápido como se nos ha notificado, pero no hemos podido salvar su vida. \n\n"
				+ "Entiendo vuestro malestar, y quien desee irse puede abandonar el campamento, se avisará a vuestros padres.\n\n"
				+ "Por parte del equipo directivo del campamento, vamos a seguir adelante lo mejor posible,\n\n"
				+ "ella hubiera querido que pasáramos una buenas vacaciones. Esta noche habrá un minuto de siolencio\n\n"
				+ "y homenajes en su nombre. \n\n" + "\n\n"
				+ "El silencio se rompe por los cuchicheos de los miembros del campamento.\n\n"
				+ "El ambiente es tenso, el aire parece más denso incluso de lo normal\n\n"
				+ "No sabes si irte o quedarte, saber qué ha pasado exactamente, te puede la curiosidad\n\n" + ".\n\n"
				+ ".\n\n" + ".\n\n" + ". \n\n"
				+ "Miras a tu lado y John te hace un gesto cómplice para que te acerques. \n\n"
				+ "Te reunes con todos los que estaban anoche en la fogata en una esquina del campamento.\n\n "
				+ "Aquí está pasando algo muy extraño y ninguno de vosotros va a dejar que quede impune\n\n" + "\n\n");
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

	public static Stage getPrimaryStage() {
		return stageep2;
	}

	public static Stage getCurrentStage() {
		return currentStage;
	}

	public static void hideStage(Stage stage) {
		stage.hide();
	}

	public static void main(String[] args) {
		launch();
		Platform.exit(); // El cierratodo de JavaFX
		System.exit(0); // El cierratodo clasico
	}

}
