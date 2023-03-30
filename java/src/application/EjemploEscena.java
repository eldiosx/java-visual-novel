package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class EjemploEscena extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Creamos un botón
        Button btn = new Button();
        btn.setText("Abrir otra escena");

        // Le añadimos un evento al botón para que abra otra escena
        btn.setOnAction(e -> {
            // Creamos una nueva escena
            Scene scene2 = new Scene(new StackPane(), 400, 400);

            // Mostramos la nueva escena en la misma ventana
            primaryStage.setScene(scene2);
            primaryStage.show();
        });

        // Creamos la escena principal
        Scene scene1 = new Scene(new StackPane(btn), 400, 400);

        // Mostramos la escena principal en la ventana
        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

