import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.Screen;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;



public class MainMenu extends Application {

	//private static final int FONT_SIZE = 20; // Cositas de fuente y responsive
    private static final String BACKGROUND_URL = "https://giffiles.alphacoders.com/168/168273.gif";
    private static final String NEW_GAME_BUTTON_URL = "http://pixelartmaker.com/art/9085477ab67ae3b.png";
    private static final String LOAD_GAME_BUTTON_URL = "http://pixelartmaker.com/art/9085477ab67ae3b.png";
    private static final String SETTINGS_BUTTON_URL = "http://pixelartmaker.com/art/9085477ab67ae3b.png";
    private static final String EXIT_BUTTON_URL = "http://pixelartmaker.com/art/9085477ab67ae3b.png";


    @Override
    public void start(Stage primaryStage) {

        // Cargar las imágenes
        Image newGameButtonImage = new Image(NEW_GAME_BUTTON_URL);
        Image loadGameButtonImage = new Image(LOAD_GAME_BUTTON_URL);
        Image settingsButtonImage = new Image(SETTINGS_BUTTON_URL);
        Image exitButtonImage = new Image(EXIT_BUTTON_URL);

        // Crear los botones
        Button newGameButton = new Button();
        newGameButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        newGameButton.setGraphic(new ImageView(newGameButtonImage));
        newGameButton.setOnAction(event -> {
            // Lógica para iniciar una nueva partida
        });

        Button loadGameButton = new Button();
        loadGameButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        loadGameButton.setGraphic(new ImageView(loadGameButtonImage));
        loadGameButton.setOnAction(event -> {
            // Lógica para cargar una partida guardada
        });

        Button settingsButton = new Button();
        settingsButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        settingsButton.setGraphic(new ImageView(settingsButtonImage));
        settingsButton.setOnAction(event -> {
            // Lógica para abrir la pantalla de ajustes
        });

        Button exitButton = new Button();
        exitButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        exitButton.setGraphic(new ImageView(exitButtonImage));
        exitButton.setOnAction(event -> {
            // Lógica para cerrar la aplicación
            primaryStage.close();
        });

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
        buttonsBox.setPadding(new Insets(200, 100, 30, 200)); // Agregar un padding en la parte inferior

     // Crear el título con sombra
        
        Label titleLabel = new Label("Tu videojuego favorito de serie B");
        //titleLabel.setStyle("-fx-font-size: 80; -fx-font-weight: bold; -fx-text-fill: gray; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.6), 10, 0, 0, 0);");
 
        titleLabel.setStyle("-fx-font-size: 80px; -fx-text-fill: gray;");
        DropShadow dropShadow = new DropShadow();
        dropShadow.colorProperty();
        dropShadow.setRadius(10);
        dropShadow.setOffsetX(4);
        dropShadow.setOffsetY(4);
        titleLabel.setEffect(dropShadow);
        
        // Crear el contenedor principal
        BorderPane root = new BorderPane();

        // Obtener el tamaño de la pantalla
        double screenWidth = Screen.getPrimary().getVisualBounds().getWidth();
        double screenHeight = Screen.getPrimary().getVisualBounds().getHeight();

        // Crear el fondo con tamaño de pantalla
        root.setBackground(new Background(new BackgroundImage(new Image(BACKGROUND_URL), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false))));
        //Titulo
        root.setTop(titleLabel);
        BorderPane.setAlignment(titleLabel, Pos.CENTER);
        // Escalar los botones
        double buttonWidth = screenWidth / 6;
        double buttonHeight = screenHeight / 8;

        newGameButton.setPrefSize(buttonWidth, buttonHeight);
        loadGameButton.setPrefSize(buttonWidth, buttonHeight);
        settingsButton.setPrefSize(buttonWidth, buttonHeight);
        exitButton.setPrefSize(buttonWidth, buttonHeight);

        // Agregar los botones al contenedor principal
        root.setCenter(buttonsBox);

        // Crear la escena
        Scene scene = new Scene(root, screenWidth, screenHeight);

        // Configurar la ventana
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tu videojuego favorito de serie B"); // Título de la ventana
        primaryStage.setResizable(true); // Se puede redimensionar
        primaryStage.setFullScreen(true); // Abre la ventana en pantalla completa
        primaryStage.setMinWidth(800); // Establece el ancho mínimo de la ventana en 800px
        primaryStage.setMinHeight(600); // Establece la altura mínima de la ventana en 600px
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}