package application;

import java.io.File;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.beans.binding.DoubleBinding;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Transition extends Application {
    private Font titleFont;
    private static final String RESOURCES_PATH = new File("assets").getAbsolutePath();
    private static final String BACKGROUND_URL = "file:" + RESOURCES_PATH + "/images/horror.gif";
    private static final double MARGIN_LEFT = 50.0;
    private static final double MARGIN_BOTTOM = 50.0;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Episodio 1");
        // Configurar la ventana
        primaryStage.setTitle("Tu videojuego favorito de serie B"); // Título de la ventana
        primaryStage.setResizable(true); // Se puede redimensionar
        primaryStage.setFullScreen(true); // Abre la ventana en pantalla completa
        primaryStage.setMinWidth(800); // Establece el ancho mínimo de la ventana en 800px
        primaryStage.setMinHeight(600); // Establece la altura mínima de la ventana en 600px
        primaryStage.show();
        
        BorderPane borderPane = new BorderPane();
        //imagen de fondo a la escena
        String ImagenFondo = (RESOURCES_PATH + "/images/fondo1.jpg");
        addBackgroundImageToScene(borderPane, ImagenFondo);
        //imagen de la persona
        String ImagenPersona = (RESOURCES_PATH + "");//para la imagen de la persona
        
        
        
        //caja de texto
        VBox vBox = new VBox(); // Crea un VBox para organizar los nodos verticalmente
        vBox.setAlignment(Pos.BOTTOM_LEFT); // Alinea los nodos al centro del VBox
        vBox.setSpacing(10); // Establece un espacio de 10 píxeles entre los nodos en el VBox
        //label de texto
        Label labelBienvenida = new Label(
                "Bienvenido al campamento \"The Otter\". Espero que estés preparado para dos semanas de diversión. Tus compañeros ya están ubicados en sus cabañas. La tuya es la cabaña número 7, puedes ir a acomodarte si quieres .");
        labelBienvenida.setWrapText(true);
        labelBienvenida.setFont(new Font(12));
        BackgroundFill backgroundFill = new BackgroundFill(Color.rgb(0, 0, 139, 0.5), new CornerRadii(10), null);
        labelBienvenida.setBackground(new Background(backgroundFill));
        labelBienvenida.setTextFill(Color.YELLOW);
        labelBienvenida.setStyle("-fx-padding: 20px;");
        //label de opciones
        Button buttonOpcion1 = new Button ("Ir a la cabaña");
        buttonOpcion1.setWrapText(true);
        buttonOpcion1.setFont(new Font(12));
        BackgroundFill FillOpcion1 = new BackgroundFill(Color.rgb(0, 0, 139, 0.5), new CornerRadii(10), null);
        buttonOpcion1.setBackground(new Background(FillOpcion1));
        buttonOpcion1.setTextFill(Color.YELLOW);
        buttonOpcion1.setStyle("-fx-padding: 20px;");
        buttonOpcion1.setOnMouseClicked(event -> {
            SoundBox.playSound(RESOURCES_PATH + "/audio/click.wav");
            // Agrega aquí el código que deseas ejecutar cuando se haga clic en el botón "Opción1"
        });
        
     // Agrega la Label al VBox
        vBox.getChildren().add(labelBienvenida); 
        vBox.getChildren().add(buttonOpcion1); 

        Label otroLabel = new Label(""); // Crea otro Label
        otroLabel.setFont(new Font(14));
        vBox.getChildren().add(otroLabel); // Agrega el otro Label al VBox

        borderPane.setCenter(vBox); // Agrega el VBox al centro del BorderPane

        Image backgroundImage = new Image(BACKGROUND_URL);
        ImageView backgroundImageView = new ImageView(backgroundImage);
        borderPane.getChildren().add(0, backgroundImageView);
        borderPane.setMargin(vBox, new javafx.geometry.Insets(MARGIN_BOTTOM, 0, 0, MARGIN_LEFT));

        DoubleBinding labelWidthBinding = new DoubleBinding() {
            {
                super.bind(primaryStage.widthProperty());
            }

            @Override
            protected double computeValue() {
                return primaryStage.getWidth() * 0.2;
            }
        };
        labelBienvenida.maxWidthProperty().bind(labelWidthBinding);
        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.show(); // Asegúrate de llamar a show() para mostrar la ventana en pantalla
    }

    public static void main(String[] args) {
        launch(args);
    }
    private void addBackgroundImageToScene(BorderPane pane, String imageUrl) {
        Image backgroundImage = new Image(imageUrl);
        ImageView backgroundImageView = new ImageView(backgroundImage);
        pane.getChildren().add(0, backgroundImageView);
    }
    
}
