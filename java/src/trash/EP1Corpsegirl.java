package trash;

import java.io.IOException;
import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage; 

public class EP1Corpsegirl extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws IOException {
    	
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DeadGirlSceneBuilder.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            primaryStage.setScene(scene);
            primaryStage.setTitle("DeadGirl");
            primaryStage.show();


        // Obtener el tamaño de la pantalla
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();

        // Crear el contenedor principal
        BorderPane root1 = new BorderPane();

        // Crear la escena
        Scene scene1 = new Scene(root1, screenBounds.getWidth(), screenBounds.getHeight());

        // Configurar la ventana
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Tu videojuego favorito de serie B"); // Título de la ventana
        primaryStage.setResizable(true); // Se puede redimensionar
        primaryStage.setFullScreen(true); // Abre la ventana en pantalla completa
        primaryStage.setMinWidth(800); // Establece el ancho mínimo de la ventana en 800px
        primaryStage.setMinHeight(600); // Establece la altura mínima de la ventana en 600px

        // Crear los botones
        Button cuerpoButton = new Button("Inspeccionar Cuerpo");
        Button sangreButton = new Button("Inspeccionar Sangre");
        Button sueloButton = new Button("Inspeccionar Suelo");
        Button salaButton = new Button("Inspeccionar Sala");
        Button cuchilloButton = new Button("Inspeccionar Cuchillo");
        Button manoButton = new Button("Inspeccionar Mano");

        // Configurar los botones
        cuerpoButton.setOnAction(e ->corpsegirl(1));
        sangreButton.setOnAction(e -> corpsegirl(2));
        sueloButton.setOnAction(e -> corpsegirl(3));
        salaButton.setOnAction(e -> corpsegirl(4));
        cuchilloButton.setOnAction(e -> corpsegirl(5));
        manoButton.setOnAction(e -> corpsegirl(6));

        // Agregar los botones al contenedor principal
        root1.setTop(cuerpoButton);
        root1.setLeft(sangreButton);
        root1.setBottom(sueloButton);
        root1.setRight(salaButton);
        root1.setCenter(cuchilloButton);
        root1.setRight(manoButton);

        // Mostrar la ventana
	        primaryStage.show();
	    }

		public static int corpsegirl(int cadaver) {
		
		    int intentos = 0;
		
		    while (intentos <= 4) {
		
		        switch (cadaver) {
		            case 1: // Inspeccionar Cuerpo
		            	Button cuerpoButton = new Button("Se trata de Nancy. Es compañera de clase de Helen y Marleene. Se ha mudado desde Colorado este septiembre y ha causado un gran revuelo entre los chicos del instituto.");
		                intentos++;
		                break;
		            case 2: // Inspeccionar Sangre
		            	Button sangreButton = new Button("Hay mucha sangre, y el vestido está completamente manchado debido a las múltiples puñaladas que ha recibido la chica.");
		                intentos++;
		                break;
		            case 3: // Inspeccionar Suelo
		                Button sueloButton = new Button("No se ven pisadas, y está completamente manchado de sangre, quien lo hizo ha sido bastante cuidadoso con no dejar rastro.");
		                cadaver = 0;
		                intentos++;
		                break;
		            case 4: // Inspeccionar Sala
		            	Button salaButton = new Button("Es la cabaña de las chicas. En ella duermen también Helen y Marleene... El director va a tener que reubicarlas después de esto.");
		                cadaver = 0;
		                intentos++;
		                break;
		            case 5: // Inspeccionar Cuchillo
		                Button cuchilloButton = new Button("Parece el arma homicida. Es uno de los cuchillos de la cocina del campamento, de eso no hay duda.");
		                cadaver = 0;
		                intentos++;
		                break;
		            case 6: // Inspeccionar Mano
		                Button manoButton = new Button("Hay muestras de forcejeo, tiene una de las uñas rotas, probablemente haya conseguido arañar a su agresor.");
		                cadaver = 0;
		                intentos++;
		                break;
		            default:
		            	Button defaultButton = new Button("Investiga la habitación para ver qué ha pasado.");
		                break;
		        }
		    }
		
		    return intentos;
		}
		
}
