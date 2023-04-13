package Trash;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class CadaverEP1 extends Application {

    Button cuerpoButton = new Button("Se trata de Nancy. Es compañera de clase de Helen y Marleene. Se ha mudado desde Colorado este septiembre y ha causado un gran revuelo entre los chicos del instituto.");
    Button sangreButton = new Button("Hay mucha sangre, y el vestido está completamente manchado debido a las múltiples puñaladas que ha recibido la chica.");
    Button sueloButton = new Button("No se ven pisadas, y está completamente manchado de sangre, quien lo hizo ha sido bastante cuidadoso con no dejar rastro.");
    Button salaButton = new Button("Es la cabaña de las chicas. En ella duermen también Helen y Marleene... El director va a tener que reubicarlas después de esto.");
    Button cuchilloButton = new Button("Parece el arma homicida. Es uno de los cuchillos de la cocina del campamento, de eso no hay duda.");
    Button manoButton = new Button("Hay muestras de forcejeo, tiene una de las uñas rotas, probablemente haya conseguido arañar a su agresor.");
    Button defaultButton = new Button("Investiga la habitación para ver qué ha pasado.");

    public static int corpsegirl(int cadaver) {
        int intentos = 0;

        while (intentos <= 4) {
            switch (cadaver) {
                case 1: // Inspeccionar Cuerpo
                    intentos++;
                    break;
                case 2: // Inspeccionar Sangre
                    intentos++;
                    break;
                case 3: // Inspeccionar Suelo
                    cadaver = 0;
                    intentos++;
                    break;
                case 4: // Inspeccionar Sala
                    cadaver = 0;
                    intentos++;
                    break;
                case 5: // Inspeccionar Cuchillo
                    cadaver = 0;
                    intentos++;
                    break;
                case 6: // Inspeccionar Mano
                    cadaver = 0;
                    intentos++;
                    break;
                default:
                    break;
            }
        }

        return intentos;
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        root.setTop(cuerpoButton);
        root.setLeft(sangreButton);
        root.setCenter(sueloButton);
        root.setRight(salaButton);
        root.setBottom(cuchilloButton);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}