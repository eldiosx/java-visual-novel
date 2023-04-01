package application;

import java.io.File;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import application.EjemploEscena;
import javafx.scene.media.MediaView;
import javafx.util.Duration;


public class MainMenu extends Application {
    private static final String BACKGROUND_URL = new File("assets/images/horror.gif").toURI().toString();//"file:///home/deck/Documents/GitHub/novelaGraficaJava/assets/images/horror.gif";
    private static final String NEW_GAME_BUTTON_URL = new File("assets/icons/startx.png").toURI().toString();//"file:///home/deck/Documents/GitHub/novelaGraficaJava/assets/icons/startx.png";
    private static final String LOAD_GAME_BUTTON_URL = new File("assets/icons/startx.png").toURI().toString();//"file:///home/deck/Documents/GitHub/novelaGraficaJava/assets/icons/startx.png";
    private static final String SETTINGS_BUTTON_URL = new File("assets/icons/startx.png").toURI().toString();//"file:///home/deck/Documents/GitHub/novelaGraficaJava/assets/icons/startx.png";
    private static final String EXIT_BUTTON_URL = new File("assets/icons/startx.png").toURI().toString();//"file:///home/deck/Documents/GitHub/novelaGraficaJava/assets/icons/startx.png";

    private static final int BUTTON_SIZE = 100;

    @Override
    public void start(Stage primaryStage) {
    	
        // Crear instancia de Media
    	Media media = new Media(new File("assets/audio/GiratinaRemix.wav").toURI().toString());
    	MediaPlayer mediaPlayer = new MediaPlayer(media);
    	mediaPlayer.play();
        
        // Cargar las imágenes
        Image newGameButtonImage = new Image(NEW_GAME_BUTTON_URL, BUTTON_SIZE, BUTTON_SIZE, true, true);
        Image loadGameButtonImage = new Image(LOAD_GAME_BUTTON_URL, BUTTON_SIZE, BUTTON_SIZE, true, true);
        Image settingsButtonImage = new Image(SETTINGS_BUTTON_URL, BUTTON_SIZE, BUTTON_SIZE, true, true);
        Image exitButtonImage = new Image(EXIT_BUTTON_URL, BUTTON_SIZE, BUTTON_SIZE, true, true);

        // Crear los botones
        Button newGameButton = new Button();
        newGameButton.setGraphic(new ImageView(newGameButtonImage));
        newGameButton.setOnAction(event -> {
//            EjemploEscena escenaEjemplo = new EjemploEscena();
//            Scene scene = new Scene(escenaEjemplo, Screen.getPrimary().getVisualBounds().getWidth(), Screen.getPrimary().getVisualBounds().getHeight());
//            primaryStage.setScene(scene);
        });


        Button loadGameButton = new Button();
        loadGameButton.setGraphic(new ImageView(loadGameButtonImage));
        loadGameButton.setOnAction(event -> {
            // Lógica para cargar una partida guardada
        });

        Button settingsButton = new Button();
        settingsButton.setGraphic(new ImageView(settingsButtonImage));
        settingsButton.setOnAction(event -> {
            // Lógica para abrir la pantalla de ajustes
        });

        Button exitButton = new Button();
        exitButton.setGraphic(new ImageView(exitButtonImage));
        exitButton.setOnAction(event -> {
            // Lógica para cerrar la aplicación
            primaryStage.close();
        });


     // Crear los contenedores de los botones
        HBox topButtonsBox = new HBox();
        topButtonsBox.setAlignment(Pos.CENTER);
        topButtonsBox.setSpacing(20);
        topButtonsBox.setPadding(new Insets(0, 50, 0, 50)); // Agregar un padding 

        ImageView newGameButtonImageView = new ImageView(newGameButtonImage);
        newGameButtonImageView.setPreserveRatio(true);
        newGameButtonImageView.setFitHeight(80);
        newGameButtonImageView.setOnMouseClicked(event -> {
            // Lógica para iniciar una nueva partida
        });
        topButtonsBox.getChildren().add(newGameButtonImageView);

        ImageView loadGameButtonImageView = new ImageView(loadGameButtonImage);
        loadGameButtonImageView.setPreserveRatio(true);
        loadGameButtonImageView.setFitHeight(80);
        loadGameButtonImageView.setOnMouseClicked(event -> {
            // Lógica para cargar una partida guardada
        });
        topButtonsBox.getChildren().add(loadGameButtonImageView);

        VBox bottomButtonsBox = new VBox();
        bottomButtonsBox.setAlignment(Pos.CENTER);
        bottomButtonsBox.setSpacing(20);
        bottomButtonsBox.setPadding(new Insets(0, 50, 0, 50)); // Agregar un padding 

        ImageView settingsButtonImageView = new ImageView(settingsButtonImage);
        settingsButtonImageView.setPreserveRatio(true);
        settingsButtonImageView.setFitHeight(80);
        settingsButtonImageView.setOnMouseClicked(event -> {
            // Lógica para abrir la pantalla de ajustes
        });
        bottomButtonsBox.getChildren().add(settingsButtonImageView);

        ImageView exitButtonImageView = new ImageView(exitButtonImage);
        exitButtonImageView.setPreserveRatio(true);
        exitButtonImageView.setFitHeight(80);
        exitButtonImageView.setOnMouseClicked(event -> {
            // Lógica para cerrar la aplicación
            primaryStage.close();
        });
        bottomButtonsBox.getChildren().add(exitButtonImageView);

        VBox buttonsBox = new VBox();
        buttonsBox.setAlignment(Pos.BOTTOM_CENTER);
        buttonsBox.setSpacing(20);
        buttonsBox.getChildren().addAll(topButtonsBox, bottomButtonsBox);
        buttonsBox.setPadding(new Insets(0, 0, 30, 0)); // Agregar un padding

        // Esconder los botones
        newGameButton.setVisible(false);
        loadGameButton.setVisible(false);
        settingsButton.setVisible(false);
        exitButton.setVisible(false);

		// Crear el título con sombra

		Label titleLabel = new Label("Tu videojuego favorito de serie B");
		titleLabel.setStyle("-fx-font-size: 80px; -fx-text-fill: gray;");
		DropShadow dropShadow = new DropShadow();
		dropShadow.colorProperty();
		dropShadow.setRadius(10);
		dropShadow.setOffsetX(4);
		dropShadow.setOffsetY(4);
		titleLabel.setPadding(new Insets(30, 50, 0, 50)); // Agregar un padding en la parte inferior
		titleLabel.setEffect(dropShadow);

		// Crear el contenedor principal
		BorderPane root = new BorderPane();
		// Obtener el tamaño de la pantalla
		double screenWidth = Screen.getPrimary().getVisualBounds().getWidth();
		double screenHeight = Screen.getPrimary().getVisualBounds().getHeight();

		// Crear el fondo con tamaño de pantalla
		root.setBackground(new Background(new BackgroundImage(new Image(BACKGROUND_URL), BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
				new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, true, true))));
		// Titulo
		root.setTop(titleLabel);
		BorderPane.setAlignment(titleLabel, Pos.CENTER);
		// Escalar los botones
		//double buttonWidth = screenWidth / 1; //6
		//double buttonHeight = screenHeight / 8;

//		newGameButton.setPrefSize(buttonWidth, buttonHeight);
//		loadGameButton.setPrefSize(buttonWidth, buttonHeight);
//		settingsButton.setPrefSize(buttonWidth, buttonHeight);
//		exitButton.setPrefSize(buttonWidth, buttonHeight);

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
//cositas
		// Evento para cuando el ratón entra en el ImageView
		newGameButtonImageView.setOnMouseEntered(event -> {
		    Image newImage = new Image(new File("assets/icons/starti.png").toURI().toString(), BUTTON_SIZE, BUTTON_SIZE, true, true);
		    newGameButtonImageView.setImage(newImage);
		});

		// Evento para cuando el ratón sale del ImageView
		newGameButtonImageView.setOnMouseExited(event -> {
		    newGameButtonImageView.setImage(newGameButtonImage);
		});
	}

	public static void main(String[] args) {
		launch(args);
	}
}