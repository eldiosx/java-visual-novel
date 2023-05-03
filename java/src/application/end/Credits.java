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
        Text creditsText = new Text(
        		"Hace muchos tiempo, en un MEDAC casi en Córdoba, un equipo de desarrolladores"
        		+ "empezaron un ambicioso proyecto. "
        		+ "Los disturbios rodean el MEDAC"
        		+ "Se esta planteando el cobro de impuestos al temario desactualizado"
        		+ "por parte de los miembros descontentos de la comunidad"
        		+ "y emigrar a sistemas solares con mejores prestaciones."
        		+ "\n\n"
        		+ "Esperando resolver el problema con un bloqueo"
        		+ "táctico a La Yessi, la codiciosa,"
        		+ "la alianza rebelde se enfrenta a nuevos retos."
        		+ "\n\n"
        		+ "\n\n"
        		+ "\n\n"
        		+ "\n\n"
        		+ "Desarrollado por Kawaii Developers \n\n"
        		+ "Nico Cano, Daniel Delgado, Aida Fernández y Adrián Márquez\n\n"
        		+ "\n\n"
        		+ "\n\n"
        		+ "Proyecto realizado usando: "
        		+ "Java "
        		+ "Java FX"
        		+ "Scene Builder "
        		+ "SQL "
        		+ "\n\n"
        		+ "\n\n"
        		+ "Desarrollo: "
        		+ "Database Manager: Nico Cano "
        		+ "Diseño: Aida Fernández"
        		+ "Frontend Manager: Adrián Marquez"
        		+ "Backend Manager: Daniel Delgado"
        		+ "\n\n"
        		+ "\n\n"
        		+ "Actores de voz: "
        		+ "John: Nico Cano "
        		+ "Marleene: Esther Argüelles"
        		+ "Travis: Javier Naranjo"
        		+ "Helen: Aida Fernández"
        		+ "Chan: Adrián Marquez"
        		+ "Monitor: Daniel Delgado"
        		+ "\n\n"
        		+ "\n\n"
        		+ "Agradecimientos especiales"
        		+ "Javier naranjo y Esther Argüelles por trabajar a cambio de un vinito"
        		+ "Juan García y Antonio Ruiz por sus consejos y paciencia");
        creditsText.setFont(new Font("Arial", responsive/4));
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

