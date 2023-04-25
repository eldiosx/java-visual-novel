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
        Text creditsText = new Text("Desarrollado por Nico Cano, Daniel Delgado, Aida Fernández y Adrián Márquez\n\n"
        		+ "ESTE AÑO VOX MAS FUERTE QUE NUNCA\n\n"
        		+ "LINUX > TODO\n"
        		+ "GNUUUU LINUUUUSSSS\n"
        		+ "RICHARD STALLMAAN\n\n"
        		+ "GABEN NEWEELLLL");
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

