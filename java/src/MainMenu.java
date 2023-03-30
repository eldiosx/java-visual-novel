import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.Screen;

public class MainMenu extends Application {

    private static final String BACKGROUND_URL = "https://thumbs.gfycat.com/SphericalNegligibleFreshwatereel-size_restricted.gif";
    private static final String NEW_GAME_BUTTON_URL = "http://pixelartmaker.com/art/9085477ab67ae3b.png";
    private static final String LOAD_GAME_BUTTON_URL = "http://pixelartmaker.com/art/9085477ab67ae3b.png";
    private static final String SETTINGS_BUTTON_URL = "http://pixelartmaker.com/art/9085477ab67ae3b.png";
    private static final String EXIT_BUTTON_URL = "http://pixelartmaker.com/art/9085477ab67ae3b.png";

    private static final int BUTTON_WIDTH = 200;
    private static final int BUTTON_HEIGHT = 50;

    @Override
    public void start(Stage primaryStage) {

        // Cargar las imágenes
        Image backgroundImage = new Image(BACKGROUND_URL);
        Image newGameButtonImage = new Image(NEW_GAME_BUTTON_URL);
        Image loadGameButtonImage = new Image(LOAD_GAME_BUTTON_URL);
        Image settingsButtonImage = new Image(SETTINGS_BUTTON_URL);
        Image exitButtonImage = new Image(EXIT_BUTTON_URL);

        // Crear los botones
        Button newGameButton = new Button();
        newGameButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        newGameButton.setGraphic(new ImageView(newGameButtonImage));
        newGameButton.setOnAction(event -> {
        // Lógica para iniciar una nueva partida
        });

        Button loadGameButton = new Button();
        loadGameButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        loadGameButton.setGraphic(new ImageView(loadGameButtonImage));
        loadGameButton.setOnAction(event -> {
            // Lógica para cargar una partida guardada
        });

        Button settingsButton = new Button();
        settingsButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        settingsButton.setGraphic(new ImageView(settingsButtonImage));
        settingsButton.setOnAction(event -> {
            // Lógica para abrir la pantalla de ajustes
        });

        Button exitButton = new Button();
        exitButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        exitButton.setGraphic(new ImageView(exitButtonImage));
        exitButton.setOnAction(event -> {
            // Lógica para cerrar la aplicación
            primaryStage.close();
        });

        // Crear el contenedor de los botones
        HBox buttonsBox = new HBox();
        buttonsBox.setAlignment(Pos.CENTER);
        buttonsBox.setSpacing(20);
        buttonsBox.getChildren().addAll(newGameButton, loadGameButton, settingsButton, exitButton);

        // Crear el contenedor principal
        BorderPane root = new BorderPane();
        
        // Obtener el tamaño de la pantalla
        double screenWidth = Screen.getPrimary().getVisualBounds().getWidth();
        double screenHeight = Screen.getPrimary().getVisualBounds().getHeight();
        
        // Crear el fondo con tamaño de pantalla
        BackgroundSize backgroundSize = new BackgroundSize(screenWidth, screenHeight, false, false, false, false);
        root.setBackground(new Background(new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false))));
        root.setCenter(buttonsBox);

        // Crear la escena
        Scene scene = new Scene(root);

        // Configurar la ventana
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tu videojuego favorito de serie B"); // Título de la ventanah
        primaryStage.setResizable(true); // Se puedee resizar
        primaryStage.setFullScreen(true); // abre la ventana en pantalla completa
        primaryStage.setMinWidth(800); // establece el ancho mínimo de la ventana en 800px
        primaryStage.setMinHeight(600); // establece la altura mínima de la ventana en 600px
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
