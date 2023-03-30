import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MainMenu extends Application {

    private static final double SCREEN_WIDTH = Screen.getPrimary().getVisualBounds().getWidth();
    private static final double SCREEN_HEIGHT = Screen.getPrimary().getVisualBounds().getHeight();
    private static final double FONT_SIZE = SCREEN_WIDTH * 0.025;

    private static final String BACKGROUND_URL = "https://giffiles.alphacoders.com/168/168273.gif";
    private static final String NEW_GAME_BUTTON_URL = "http://pixelartmaker.com/art/9085477ab67ae3b.png";
    private static final String LOAD_GAME_BUTTON_URL = "http://pixelartmaker.com/art/9085477ab67ae3b.png";
    private static final String SETTINGS_BUTTON_URL = "http://pixelartmaker.com/art/9085477ab67ae3b.png";
    private static final String EXIT_BUTTON_URL = "http://pixelartmaker.com/art/9085477ab67ae3b.png";

    private static final double BUTTON_WIDTH = SCREEN_WIDTH * 0.2;
    private static final double BUTTON_HEIGHT = SCREEN_HEIGHT * 0.1;

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
        newGameButton.setFont(Font.font(FONT_SIZE));

        Button loadGameButton = new Button();
        loadGameButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        loadGameButton.setGraphic(new ImageView(loadGameButtonImage));
        loadGameButton.setOnAction(event -> {
            // Lógica para cargar una partida guardada
        });
        loadGameButton.setFont(Font.font(FONT_SIZE));

        Button settingsButton = new Button();
        settingsButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        settingsButton.setGraphic(new ImageView(settingsButtonImage));
        settingsButton.setOnAction(event -> {
            // Lógica para abrir la pantalla de ajustes
        });
        settingsButton.setFont(Font.font(FONT_SIZE));

        Button exitButton = new Button();
        exitButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        exitButton.setGraphic(new ImageView(exitButtonImage));
        exitButton.setOnAction(event -> {
            // Lógica para cerrar la aplicación
            primaryStage.close();
        });
        exitButton.setFont(Font.font(FONT_SIZE));

     // Crear los contenedores de los botones
        HBox topButtonsBox = new HBox();
        topButtonsBox.setAlignment(Pos.CENTER);
        topButtonsBox.setSpacing(20);
        topButtonsBox.getChildren().addAll(newGameButton, loadGameButton);

        VBox bottomButtonsBox = new VBox();
        bottomButtonsBox.setAlignment(Pos.CENTER);
        bottomButtonsBox.setSpacing(20);
        bottomButtonsBox.getChildren().addAll(settingsButton, exitButton);

        VBox buttonsBox = new VBox();
        buttonsBox.setAlignment(Pos.BOTTOM_CENTER);
        buttonsBox.setSpacing(20);
        buttonsBox.getChildren().addAll(topButtonsBox, bottomButtonsBox);
        buttonsBox.setPadding(new Insets(0, 0, 20, 0)); // Agregar un padding en la parte inferior

        // Escalar el tamaño de fuente de los botones según el tamaño de pantalla
        double screenWidth = Screen.getPrimary().getVisualBounds().getWidth();
        double screenHeight = Screen.getPrimary().getVisualBounds().getHeight();
        double fontSize = FONT_SIZE * (screenWidth / 1920.0);
        newGameButton.setStyle("-fx-font-size: " + fontSize + "px;");
        loadGameButton.setStyle("-fx-font-size: " + fontSize + "px;");
        settingsButton.setStyle("-fx-font-size: " + fontSize + "px;");
        exitButton.setStyle("-fx-font-size: " + fontSize + "px;");

        // Crear el contenedor principal
        BorderPane root = new BorderPane();

        // Crear el fondo con tamaño de pantalla
        BackgroundSize backgroundSize = new BackgroundSize(screenWidth, screenHeight, false, false, false, false);
        root.setBackground(new Background(new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false))));
        root.setCenter(buttonsBox);

        // Crear la escena
        Scene scene = new Scene(root);

        // Configurar la ventana
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tu videojuego favorito de serie B"); // Título de la ventana
        primaryStage.setResizable(true); // Se puede resizar
        primaryStage.setFullScreen(true); // Abre la ventana en pantalla completa
        primaryStage.setMinWidth(800); // Establece el ancho mínimo de la ventana en 800px
        primaryStage.setMinHeight(600); // Establece la altura mínima de la ventana en 600px
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
