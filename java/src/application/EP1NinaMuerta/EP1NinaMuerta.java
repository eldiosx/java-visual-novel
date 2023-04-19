package application.EP1NinaMuerta;


import com.badlogic.gdx.scenes.scene2d.ui.Button;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class EP1NinaMuerta extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
    	
		primaryStage.setResizable(true); // Se puede redimensionar
		primaryStage.setFullScreen(true); // Abre la ventana en pantalla completa
		primaryStage.setMinWidth(800); // Establece el ancho mínimo de la ventana en 800px
		primaryStage.setMinHeight(600); // Establece la altura mínima de la ventana en 600px
		primaryStage.show();
		
		ClassLoader classLoader = getClass().getClassLoader();
		double screenWidth = Screen.getPrimary().getVisualBounds().getWidth();
		double responsive = screenWidth * 0.07; // 7% del ancho de la pantalla RESPONSIVE++
        Parent root = FXMLLoader.load(getClass().getResource("EP1NinaMuerta"));
        
        primaryStage.setTitle("Episodio 1");
        primaryStage.setScene(new Scene(root, 1920, 1080));
        primaryStage.show();
        
        //Vamos añadiendo los botones y las acciones de los mismos
        
        //Boton de investigar suelo
        
        
        //Boton de investigar sala
        
        
    }

    public static void main(String[] args) {
        launch(args);
    }
}
