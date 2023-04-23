package trash;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class CadaverEP1Principal extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Obtener el tamaño de la pantalla
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();

        // Crear el contenedor principal
        BorderPane root = new BorderPane();

        // Crear la escena
        Scene scene = new Scene(root, screenBounds.getWidth(), screenBounds.getHeight());

        // Configurar la ventana
        primaryStage.setScene(scene);
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
        cuerpoButton.setOnAction(e -> CadaverEP1.corpsegirl(1));
        sangreButton.setOnAction(e -> CadaverEP1.corpsegirl(2));
        sueloButton.setOnAction(e -> CadaverEP1.corpsegirl(3));
        salaButton.setOnAction(e -> CadaverEP1.corpsegirl(4));
        cuchilloButton.setOnAction(e -> CadaverEP1.corpsegirl(5));
        manoButton.setOnAction(e -> CadaverEP1.corpsegirl(6));

        // Agregar los botones al contenedor principal
        root.setTop(cuerpoButton);
        root.setLeft(sangreButton);
        root.setBottom(sueloButton);
        root.setRight(salaButton);
        root.setCenter(cuchilloButton);
        root.setRight(manoButton);

        // Mostrar la ventana
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}