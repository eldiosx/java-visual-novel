package application;

//Java
//import java.beans.EventHandler;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
//JavaFX
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Popup;
import javafx.scene.Group;
import javafx.scene.control.ComboBox;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.application.Platform;
//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;s
//import javafx.concurrent.Task;
//import javafx.scene.media.MediaView;
//import javafx.event.ActionEvent;
//import javafx.util.Duration;
//Local .java
//import application.SoundBox;
//import application.OggPlayer;
//MySql
//import com.mysql.cj.protocol.Resultset;

public class MainMenu extends Application {
//assets/audio/lullabyX.ogg
	// Crear instancia de la clase ConexionMySQL
	ConexionMySQL conexion = new ConexionMySQL("root", "", "videojuego serie b");

	ClassLoader classLoader = getClass().getClassLoader();
	double screenWidth = Screen.getPrimary().getVisualBounds().getWidth();
	double fontSize = screenWidth * 0.05; // 5% del ancho de la pantalla
	private static final int BUTTON_SIZE = 100;
	private Font titleFont;
	// CAJITA DE MUSICA ASINCRONA Crear instancia de Media y hacer que la mÚsica sea
	// "asincrona"
	SoundBox soundBox = new SoundBox();
	OggPlayer oggPlayer = new OggPlayer();
	BackgroundMusic backgroundMusic = new BackgroundMusic();
	// Media:
	private static final String RESOURCES_PATH = new File("assets").getAbsolutePath();
	private static final String BACKGROUND_URL = "file:" + RESOURCES_PATH + "/images/darkforest.gif";
	private static final String NEW_GAME_BUTTON_URL = "file:" + RESOURCES_PATH + "/icons/off/NewGameButton.png";
	private static final String LOAD_GAME_BUTTON_URL = "file:" + RESOURCES_PATH + "/icons/off/LoadButton.png";
	private static final String SETTINGS_BUTTON_URL = "file:" + RESOURCES_PATH + "/icons/off/SettingsButton.png";
	private static final String EXIT_BUTTON_URL = "file:" + RESOURCES_PATH + "/icons/off/QuitButton.png";

	@Override
	public void start(Stage primaryStage) {

		// Crear un nuevo hilo para reproducir el audio de fondo
		Thread audioThread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					backgroundMusic.playAudio("assets/audio/lullabyX.ogg");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		audioThread.start();

		// Cargar las imágenes
		Image newGameButtonImage = new Image(NEW_GAME_BUTTON_URL, BUTTON_SIZE, BUTTON_SIZE, true, true);
		Image loadGameButtonImage = new Image(LOAD_GAME_BUTTON_URL, BUTTON_SIZE, BUTTON_SIZE, true, true);
		Image settingsButtonImage = new Image(SETTINGS_BUTTON_URL, BUTTON_SIZE, BUTTON_SIZE, true, true);
		Image exitButtonImage = new Image(EXIT_BUTTON_URL, BUTTON_SIZE, BUTTON_SIZE, true, true);

		// Crear los contenedores de los botones
		HBox topButtonsBox = new HBox();
		topButtonsBox.setAlignment(Pos.CENTER);
		topButtonsBox.setSpacing(20);
		topButtonsBox.setPadding(new Insets(0, 50, 0, 50)); // Agregar un padding

		ImageView newGameButtonImageView = new ImageView(newGameButtonImage);
		newGameButtonImageView.setPreserveRatio(true);
		newGameButtonImageView.setFitHeight(80);
		newGameButtonImageView.setOnMouseClicked(event -> {
			soundBox.playAudio(RESOURCES_PATH + "/audio/click.ogg");
			// Lógica para iniciar una nueva partida
		});
		topButtonsBox.getChildren().add(newGameButtonImageView);

		ImageView loadGameButtonImageView = new ImageView(loadGameButtonImage);
		loadGameButtonImageView.setPreserveRatio(true);
		loadGameButtonImageView.setFitHeight(80);
		loadGameButtonImageView.setOnMouseClicked(event -> {
			soundBox.playAudio(RESOURCES_PATH + "/audio/click.ogg");
			// Bloquear que pueda abrir ventanas infinitas
			loadGameButtonImageView.setDisable(true);
			Popup loadPopup = new Popup();
			// Crear un botón para cerrar la ventana de load
			// closeButton.setOnAction(e -> loadGameButtonImageView.setDisable(false));
			Button closeButton = new Button("X");
			closeButton.setOnAction(closePopup -> {
				soundBox.playAudio(RESOURCES_PATH + "/audio/click.ogg");
				loadPopup.hide();
			});
			// Reactivar el boton de load
			loadPopup.setOnHidden(e -> loadGameButtonImageView.setDisable(false));

			// Crear una nueva escena para la ventana de load
			VBox loadLayout = new VBox();
			loadLayout.setOpacity(0.65); // configurar la opacidad a 0.75
			loadLayout.setStyle("-fx-background-color: #111111;"); // configurar el color de fondo
			loadLayout.setPrefHeight(500);
			loadLayout.setPrefWidth(500);

			Label label = new Label(" Cargar partida ");
			label.setStyle("-fx-font-size: 50px; -fx-text-fill: white;");
			Label slot1Label = new Label("Slot 1: ");
			Button slot1Button = new Button("0/00/0000 - Capitulo 0");
			slot1Label.setStyle("-fx-font-size: 25px; -fx-text-fill: white;");

			// Este código que empieza aquí son pruebas para la conexión a la BD. No borrar.
			slot1Button.setOnAction(event2 -> {
				try {
					conexion.conectar();
					// String insertarLinea = "INSERT INTO episodio (NUM_episodio,nombreEpisodio)
					// VALUES ('3', 'Ep3')";
					// conexion.ejecutarInsertDeleteUpdate(insertarLinea);
					String selectPrueba = "SELECT dialogo from dialogos WHERE COD_dialogo = 2;";
					ResultSet datos = conexion.ejecutarSelect(selectPrueba);

					while (datos.next()) {
						// int numEpisodio = datos.getInt("NUM_episodio");
						String dialogoPrueba = datos.getString("dialogo");
						// System.out.println(numEpisodio);
						System.out.println(dialogoPrueba);

					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				} finally {
					try {
						conexion.desconectar();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			});

			// Hasta aquí el código de pruebas

			Label slot2Label = new Label("Slot 2: ");
			Button slot2Button = new Button("Empty save...");
			slot2Label.setStyle("-fx-font-size: 25px; -fx-text-fill: white;");
			Label slot3Label = new Label("Slot 3: ");
			Button slot3Button = new Button("Empty save...");
			slot3Label.setStyle("-fx-font-size: 25px; -fx-text-fill: white;");
			HBox saveData1 = new HBox(slot1Label, slot1Button);
			saveData1.setStyle("-fx-padding: 20px;");
			HBox saveData2 = new HBox(slot2Label, slot2Button);
			saveData2.setStyle("-fx-padding: 20px;");
			HBox saveData3 = new HBox(slot3Label, slot3Button);
			saveData3.setStyle("-fx-padding: 20px;");
			// Agregar los controles a la escena de load
			HBox header = new HBox(closeButton, label);
			header.setStyle("-fx-background-color: #111111; -fx-padding: 20px;");
			header.setPrefHeight(50);
			header.setSpacing(5);
			loadLayout.getChildren().addAll(header, saveData1, saveData2, saveData3);
			Scene loadScene = new Scene(loadLayout, 400, 400);
			// Group root
			Group root = new Group();
			root.getChildren().add(loadScene.getRoot());
			// decoracion y sombreado a la popup
			DropShadow dropShadow = new DropShadow();
			dropShadow.setColor(Color.BLACK);
			dropShadow.setRadius(55);
			root.setEffect(dropShadow);
			// Agregar el objeto Group a la ventana emergente
			loadPopup.getContent().add(root);

			// Mostrar la ventana emergente en la posición del botón
			loadPopup.show(primaryStage);
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
			soundBox.playAudio(RESOURCES_PATH + "/audio/click.ogg");
			// Bloquear que pueda abrir ventanas infinitas
			settingsButtonImageView.setDisable(true);
			Popup settingsPopup = new Popup();

			// Crear un botón para cerrar la ventana de settings
			Button closeButton = new Button("X");
			closeButton.setOnAction(closePopup -> {
				soundBox.playAudio(RESOURCES_PATH + "/audio/click.ogg");
				settingsPopup.hide();
			});

			// Reactivar el boton de settings
			settingsPopup.setOnHidden(e -> settingsButtonImageView.setDisable(false));

			// Crear una nueva escena para la ventana de settings
			VBox settingsLayout = new VBox();
			settingsLayout.setOpacity(0.65); // configurar la opacidad a 0.75
			settingsLayout.setStyle("-fx-background-color: #111111; -fx-padding: 20px;"); // configurar el color de
																							// fondo
			settingsLayout.setPrefHeight(500);
			settingsLayout.setPrefWidth(500);
			Label label = new Label(" Settings ");
			label.setStyle("-fx-font-size: 50px; -fx-text-fill: white;");
			Label musicLabel = new Label("Música:");
			musicLabel.setStyle("-fx-font-size: 25px; -fx-text-fill: white;");
			Slider musicSlider = new Slider(0, 100, 50);
			Label soundLabel = new Label("Sonido:");
			soundLabel.setStyle("-fx-font-size: 25px; -fx-text-fill: white;");
			Slider soundSlider = new Slider(0, 100, 50);
			Label languageLabel = new Label("Idioma (Textos):");
			// COnfiguraciones del idioma mediante listas:
			languageLabel.setStyle("-fx-font-size: 25px; -fx-text-fill: white;");
			ObservableList<String> listLanguage = FXCollections.observableArrayList("Español", "Inglés", "Francés");
			ComboBox<String> languageBox = new ComboBox<>(listLanguage);
			Label voiceLabel = new Label("Idioma (Voces):");
			voiceLabel.setStyle("-fx-font-size: 25px; -fx-text-fill: white;");
			ObservableList<String> listVoice = FXCollections.observableArrayList("Español");
			ComboBox<String> languageVoiceBox = new ComboBox<>(listVoice);

			// Agregar los controles a la escena de settings
			HBox header = new HBox(closeButton, label);
			header.setStyle("-fx-background-color: #111111; -fx-padding: 20px;");
			header.setPrefHeight(50);
			header.setSpacing(5);
			settingsLayout.getChildren().addAll(header, musicLabel, musicSlider, soundLabel, soundSlider, languageLabel,
					languageBox, voiceLabel, languageVoiceBox);
			Scene settingsScene = new Scene(settingsLayout, 400, 400);
			// Root group con toditoo
			Group root = new Group();
			root.getChildren().add(settingsScene.getRoot());
			// decoracion y sombreado a la popup
			DropShadow dropShadow = new DropShadow();
			dropShadow.setColor(Color.BLACK);
			dropShadow.setRadius(55);
			root.setEffect(dropShadow);
			// Agregar el objeto Group a la ventana emergente
			settingsPopup.getContent().add(root);
			// Mostrar la ventana emergente en la posición del botón
			settingsPopup.show(primaryStage);
		});
		bottomButtonsBox.getChildren().add(settingsButtonImageView);

		ImageView exitButtonImageView = new ImageView(exitButtonImage);
		exitButtonImageView.setPreserveRatio(true);
		exitButtonImageView.setFitHeight(80);
		exitButtonImageView.setOnMouseClicked(event -> {
			soundBox.playAudio(RESOURCES_PATH + "/audio/click.ogg");
			// Lógica para cerrar la aplicación
			backgroundMusic.stopAudio();
			primaryStage.close();
		});
		bottomButtonsBox.getChildren().add(exitButtonImageView);

		VBox buttonsBox = new VBox();
		buttonsBox.setAlignment(Pos.BOTTOM_CENTER);
		buttonsBox.setSpacing(20);
		buttonsBox.getChildren().addAll(topButtonsBox, bottomButtonsBox);
		buttonsBox.setPadding(new Insets(0, 0, 30, 0)); // Agregar un padding

		// Crear el título con sombra (utilizo el DropShadow) + fuente personalizada y
		// try catch x si peta
		try {
			titleFont = Font.loadFont(new FileInputStream(new File(RESOURCES_PATH + "/fonts/BloodyTerror.ttf")), 12);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Label titleLabel = new Label("Tu videojuego favorito de serie B");
		titleLabel.setStyle("-fx-font-size: " + fontSize + "px; -fx-text-fill: #030304; -fx-font-family: '"
				+ titleFont.getName() + "';");
		DropShadow dropShadow = new DropShadow();
		dropShadow.setColor(Color.WHITE);
		dropShadow.setRadius(10);
		dropShadow.setOffsetX(4);
		dropShadow.setOffsetY(4);
		titleLabel.setEffect(dropShadow);
		titleLabel.setPadding(new Insets(30, 50, 0, 50)); // Agregar un padding en la parte inferior

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

		// Agregar los botones al contenedor principal
		root.setCenter(buttonsBox);

		// Crear la escena
		Scene scene = new Scene(root, screenWidth, screenHeight);
		// scene.getStylesheets().add("LoadingScreen.css"); // Un extras para añadir un
		// css de manera externa

		// Configurar la ventana
		primaryStage.setScene(scene);
		primaryStage.setTitle("Tu videojuego favorito de serie B"); // Título de la ventana
		primaryStage.setResizable(true); // Se puede redimensionar
		primaryStage.setFullScreen(true); // Abre la ventana en pantalla completa
		primaryStage.setMinWidth(800); // Establece el ancho mínimo de la ventana en 800px
		primaryStage.setMinHeight(600); // Establece la altura mínima de la ventana en 600px
		primaryStage.show();

		// Evento para cuando el ratón entra en el ImageView & Evento para cuando el
		// ratón sale del ImageView
		newGameButtonImageView.setOnMouseEntered(event -> {
			Image newImage = new Image(new File(RESOURCES_PATH + "/icons/on/NewGameButton.png").toURI().toString(),
					BUTTON_SIZE, BUTTON_SIZE, true, true);
			newGameButtonImageView.setImage(newImage);
			soundBox.playAudio(RESOURCES_PATH + "/audio/select.ogg");
		});
		newGameButtonImageView.setOnMouseExited(event -> {
			newGameButtonImageView.setImage(newGameButtonImage);
		});
		loadGameButtonImageView.setOnMouseEntered(event -> {
			Image newImage = new Image(new File(RESOURCES_PATH + "/icons/on/LoadButton.png").toURI().toString(),
					BUTTON_SIZE, BUTTON_SIZE, true, true);
			loadGameButtonImageView.setImage(newImage);
			soundBox.playAudio(RESOURCES_PATH + "/audio/select.ogg");
		});
		loadGameButtonImageView.setOnMouseExited(event -> {
			loadGameButtonImageView.setImage(loadGameButtonImage);
		});
		settingsButtonImageView.setOnMouseEntered(event -> {
			Image newImage = new Image(new File(RESOURCES_PATH + "/icons/on/SettingsButton.png").toURI().toString(),
					BUTTON_SIZE, BUTTON_SIZE, true, true);
			settingsButtonImageView.setImage(newImage);
			soundBox.playAudio(RESOURCES_PATH + "/audio/select.ogg");
		});
		settingsButtonImageView.setOnMouseExited(event -> {
			settingsButtonImageView.setImage(settingsButtonImage);
		});
		exitButtonImageView.setOnMouseEntered(event -> {
			Image newImage = new Image(new File(RESOURCES_PATH + "/icons/on/QuitButton.png").toURI().toString(),
					BUTTON_SIZE, BUTTON_SIZE, true, true);
			exitButtonImageView.setImage(newImage);
			soundBox.playAudio(RESOURCES_PATH + "/audio/select.ogg");
		});
		exitButtonImageView.setOnMouseExited(event -> {
			exitButtonImageView.setImage(exitButtonImage);
		});

	}

	public static void main(String[] args) throws SQLException {
		launch(args);
		Platform.exit(); // El cierratodo de JavaFX
		System.exit(0); // El cierratodo clasico
	}

}