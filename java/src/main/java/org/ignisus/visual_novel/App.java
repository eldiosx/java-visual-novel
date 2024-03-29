package org.ignisus.visual_novel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;



//Java
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

//JavaFX
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
//import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
//import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Popup;
import javafx.stage.Screen;
import javafx.stage.Stage;

//MySql
import java.sql.SQLException;

//Local
import org.ignisus.visual_novel.prologue.MainPrologue;
import org.ignisus.visual_novel.ep1.MainEp1;

public class App extends Application {

	ClassLoader classLoader = getClass().getClassLoader();
	// Responsive
	double screenWidth = Screen.getPrimary().getVisualBounds().getWidth();
	double screenHeight = Screen.getPrimary().getVisualBounds().getHeight();
	MainPrologue mainPrologue = new MainPrologue();
	MainEp1 mainEp1 = new MainEp1();
	Stage stage = new Stage();
	double responsive = screenWidth * 0.07;
	private Font titleFont;

	// Music ASINCRONA
	private SoundBox soundBox = new SoundBox();
	private VoiceBox voiceBox = new VoiceBox();
	private BackgroundMusic backgroundMusic = new BackgroundMusic();
	private Loader loader;
	// Media
	private static final String RESOURCES_PATH = new File("src/main/resources/assets").getAbsolutePath();
	private static final String ICON_URL = "file:" + RESOURCES_PATH + "/icons/icon.png";
	private static final String BACKGROUND_URL = "file:" + RESOURCES_PATH + "/images/darkforest.gif";
	private static final String NEW_GAME_BUTTON_URL = "file:" + RESOURCES_PATH + "/icons/off/NewGameButton.png";
	private static final String LOAD_GAME_BUTTON_URL = "file:" + RESOURCES_PATH + "/icons/off/LoadButton.png";
	private static final String SETTINGS_BUTTON_URL = "file:" + RESOURCES_PATH + "/icons/off/SettingsButton.png";
	private static final String EXIT_BUTTON_URL = "file:" + RESOURCES_PATH + "/icons/off/QuitButton.png";
	private static final String CLOSE_BUTTON_URL = "file:" + RESOURCES_PATH + "/icons/off/X.png";
	Image icon = new Image(ICON_URL);

	@Override
	public void start(Stage primaryStage) {
		// Loader
		loader = new Loader();
		loader.setTitle("Loading...");
		loader.getIcons().add(icon);
		loader.show();

		Task<Void> task = new Task<Void>() {
			@Override
			protected Void call() throws Exception {
				// Load all

				for (int i = 0; i < 100; i++) {
					updateProgress(i, 99);
					Thread.sleep(50);
				}
				return null;
			}
		};

		task.setOnSucceeded(event -> {
			loader.hide();
			backgroundMusic.playAudio(RESOURCES_PATH + "/audio/lullabyX.ogg");
			primaryStage.show();

		});

		loader.getProgressIndicator().progressProperty().bind(task.progressProperty());
		new Thread(task).start();

		// Load img (1true suavize 2true responsive)
		Image newGameButtonImage = new Image(NEW_GAME_BUTTON_URL, responsive, responsive / 3, true, true);
		Image loadGameButtonImage = new Image(LOAD_GAME_BUTTON_URL, responsive, responsive / 3, true, true);
		Image settingsButtonImage = new Image(SETTINGS_BUTTON_URL, responsive, responsive / 3, true, true);
		Image exitButtonImage = new Image(EXIT_BUTTON_URL, responsive, responsive / 3, true, true);
		Image closeButtonImage = new Image(CLOSE_BUTTON_URL, responsive / 3, responsive / 3, true, true);

		// Button container
		HBox topButtonsBox = new HBox();
		topButtonsBox.setAlignment(Pos.CENTER);
		topButtonsBox.setSpacing(20);
		topButtonsBox.setPadding(new Insets(0, 50, 0, 50)); // Agregar un padding

		// Crear un closeButtonImageView con la imagen cargada
		ImageView closeButtonImageView = new ImageView(closeButtonImage);

		// Establecer el tamaño deseado para la closeButtonImageView
		closeButtonImageView.setFitWidth(60);
		closeButtonImageView.setFitHeight(60);

		ImageView newGameButtonImageView = new ImageView(newGameButtonImage);
		newGameButtonImageView.setPreserveRatio(true);// Mentiene la relacion de aspecto
		newGameButtonImageView.setSmooth(true); // Suvizar el escalado
		newGameButtonImageView.setFitHeight(responsive / 1.5); // Escalado responsive
		newGameButtonImageView.setOnMouseClicked(event -> {
			soundBox.playAudio(RESOURCES_PATH + "/audio/click.ogg");
			backgroundMusic.stopAudio();
			try {
				// New Stage
				mainPrologue.start(stage);

				primaryStage.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// // Abrir otra escena .XFML
			// FXMLLoader loader = new
			// FXMLLoader(getClass().getResource("Prologue/Prologue1.fxml"));
			// Parent root = null;
			// try {
			// root = loader.load();
			// } catch (IOException e) {
			// e.printStackTrace();
			// }
			// Scene scene = new Scene(root);
			// Stage newStage = new Stage();
			// newStage.setScene(scene);
			// newStage.show();
		});
		topButtonsBox.getChildren().add(newGameButtonImageView);

		ImageView loadGameButtonImageView = new ImageView(loadGameButtonImage);
		loadGameButtonImageView.setPreserveRatio(true);// Mentiene la relacion de aspecto
		loadGameButtonImageView.setSmooth(true); // Suvizar el escalado
		loadGameButtonImageView.setFitHeight(responsive / 1.5); // Escalado responsive
		loadGameButtonImageView.setOnMouseClicked(event -> {
			soundBox.playAudio(RESOURCES_PATH + "/audio/click.ogg");
			// Bloquear que pueda abrir ventanas infinitas
			loadGameButtonImageView.setDisable(true);
			Popup loadPopup = new Popup();

			// Establecer la acción del botón cerrar
			closeButtonImageView.setOnMouseClicked(e -> {
				soundBox.playAudio(RESOURCES_PATH + "/audio/click.ogg");
				loadPopup.hide();
			});

			// Reactivar el boton de load
			loadPopup.setOnHidden(e -> loadGameButtonImageView.setDisable(false));

			// Crear una nueva escena para la ventana de load
			VBox loadLayout = new VBox();
			loadLayout.setOpacity(0.65);
			loadLayout.setStyle("-fx-background-color: #111111;");
			loadLayout.setPrefHeight(500);
			loadLayout.setPrefWidth(500);

			Label label = new Label(" Load Game ");
			label.setStyle("-fx-font-size: 50px; -fx-text-fill: white;");
			Label slot1Label = new Label("Slot 1: ");
			Button slot1Button = new Button("0/00/0000 - Chapter 1");
			slot1Label.setStyle("-fx-font-size: 25px; -fx-text-fill: white;");

			// Load

			slot1Button.setOnAction(event2 -> {
				soundBox.playAudio(RESOURCES_PATH + "/audio/click.ogg");
				backgroundMusic.stopAudio();
				try {
					mainEp1.start(stage);
					primaryStage.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			});

			Label slot2Label = new Label("Slot 2: ");
			Button slot2Button = new Button("Empty save...");
			slot2Label.setStyle("-fx-font-size: 25px; -fx-text-fill: white;");

			slot2Button.setOnAction(event2 -> {
			});

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
			HBox header = new HBox(closeButtonImageView, label);
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
		settingsButtonImageView.setPreserveRatio(true);// Mentiene la relacion de aspecto
		settingsButtonImageView.setSmooth(true); // Suvizar el escalado
		settingsButtonImageView.setFitHeight(responsive / 1.5); // Escalado responsive
		settingsButtonImageView.setOnMouseClicked(event -> {
			soundBox.playAudio(RESOURCES_PATH + "/audio/click.ogg");
			// Bloquear que pueda abrir ventanas infinitas
			settingsButtonImageView.setDisable(true);
			Popup settingsPopup = new Popup();

			// Establecer la acción del botón cerrar
			closeButtonImageView.setOnMouseClicked(e -> {
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
			Slider musicSlider = new Slider(0, 100, 50); // creación del Slider
			musicSlider.valueProperty().addListener(new ChangeListener<Number>() {
				public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
					// Modificar volumen del archivo de audio
					backgroundMusic.setVolume((float) musicSlider.getValue() / 100);
				}
			});
			Label soundLabel = new Label("SFX:");
			soundLabel.setStyle("-fx-font-size: 25px; -fx-text-fill: white;");
			Slider soundSlider = new Slider(0, 100, 50);
			soundSlider.valueProperty().addListener(new ChangeListener<Number>() {
				public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
					// Modificar volumen del archivo de audio
					soundBox.setVolume((float) soundSlider.getValue() / 100);
				}
			});
			Label voiceVLabel = new Label("Voces:");
			voiceVLabel.setStyle("-fx-font-size: 25px; -fx-text-fill: white;");
			Slider voiceVSlider = new Slider(0, 100, 50);
			voiceVSlider.valueProperty().addListener(new ChangeListener<Number>() {
				public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
					// Modificar volumen del archivo de audio
					voiceBox.setVolume((float) voiceVSlider.getValue() / 100);
				}
			});
			Label languageLabel = new Label("Text language:");
			// COnfiguraciones del idioma mediante listas:
			languageLabel.setStyle("-fx-font-size: 25px; -fx-text-fill: white;");
			ObservableList<String> listLanguage = FXCollections.observableArrayList("Español", "English", "Francaise");
			ComboBox<String> languageBox = new ComboBox<>(listLanguage);
			Label voiceLabel = new Label("Voice language:");
			voiceLabel.setStyle("-fx-font-size: 25px; -fx-text-fill: white;");
			ObservableList<String> listVoice = FXCollections.observableArrayList("Español");
			ComboBox<String> languageVoiceBox = new ComboBox<>(listVoice);

			// Agregar los controles a la escena de settings
			HBox header = new HBox(closeButtonImageView, label);
			header.setStyle("-fx-background-color: #111111; -fx-padding: 20px;");
			header.setPrefHeight(50);
			header.setSpacing(5);
			settingsLayout.getChildren().addAll(header, musicLabel, musicSlider, soundLabel, soundSlider, voiceVLabel,
					voiceVSlider, languageLabel, languageBox, voiceLabel, languageVoiceBox);
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
		exitButtonImageView.setPreserveRatio(true);// Mentiene la relacion de aspecto
		exitButtonImageView.setSmooth(true); // Suvizar el escalado
		exitButtonImageView.setFitHeight(responsive / 1.5); // Escalado responsive
		exitButtonImageView.setOnMouseClicked(event -> {
			soundBox.playAudio(RESOURCES_PATH + "/audio/click.ogg");
			// Lógica para cerrar la aplicación
			primaryStage.close();
			Platform.exit(); // El cierratodo de JavaFX
			System.exit(0); // El cierratodo clasico
		});
		bottomButtonsBox.getChildren().add(exitButtonImageView);

		VBox buttonsBox = new VBox();
		buttonsBox.setAlignment(Pos.BOTTOM_CENTER);
		buttonsBox.setSpacing(20);
		buttonsBox.getChildren().addAll(topButtonsBox, bottomButtonsBox);
		buttonsBox.setPadding(new Insets(0, 0, responsive / 2, 0)); // Agregar un padding

		// Title
		try {
			titleFont = Font.loadFont(new FileInputStream(new File(RESOURCES_PATH + "/fonts/PaintDropsRegular.ttf")),
					12);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Label titleLabel = new Label("Your Favorite B-Movie");
		Label subtitleLabel = new Label("Video Game");
		titleLabel.setStyle("-fx-font-size: " + responsive + "px; -fx-text-fill: #030304; -fx-font-family: '"
				+ titleFont.getName() + "';");
		subtitleLabel.setStyle("-fx-font-size: " + responsive + "px; -fx-text-fill: #030304; -fx-font-family: '"
				+ titleFont.getName() + "';");
		DropShadow dropShadow = new DropShadow();
		dropShadow.setColor(Color.WHITE);
		dropShadow.setRadius(10);
		dropShadow.setOffsetX(4);
		dropShadow.setOffsetY(4);
		titleLabel.setEffect(dropShadow);
		subtitleLabel.setEffect(dropShadow);
		titleLabel.setPadding(new Insets(30, 50, 0, 50)); // Agregar un padding en la parte inferior
		VBox title = new VBox();
		title.getChildren().addAll(titleLabel, subtitleLabel);
		title.setStyle("-fx-alignment: center; -fx-padding: " + responsive * 1.2 + "px;");

		// Crear el contenedor principal
		BorderPane root = new BorderPane();
		// Crear el fondo con tamaño de pantalla
		root.setBackground(new Background(new BackgroundImage(new Image(BACKGROUND_URL), BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
				new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, true, true))));
		// Titulo
		root.setTop(title);
		BorderPane.setAlignment(title, Pos.CENTER);

		// Agregar los botones al contenedor principal
		root.setCenter(buttonsBox);

		// Crear la escena
		Scene scene = new Scene(root, screenWidth, screenHeight);
		// scene.getStylesheets().add("archivocss.css"); // Un extra para añadir un
		// css de manera externa

		// Configurar la ventana
		primaryStage.setScene(scene);
		primaryStage.setTitle("Your Favorite B-Movie Video Game"); // Título de la ventana
		primaryStage.setResizable(true); // Se puede redimensionar
		primaryStage.setFullScreen(true); // Abre la ventana en pantalla completa
		primaryStage.setMinWidth(800); // Establece el ancho mínimo de la ventana en 800px
		primaryStage.setMinHeight(600); // Establece la altura mínima de la ventana en 600px
		primaryStage.getIcons().add(icon); // Er iconoh

		// ButtonOn
		setButtonBehavior(newGameButtonImageView, "NewGameButton.png");
		setButtonBehavior(loadGameButtonImageView, "LoadButton.png");
		setButtonBehavior(settingsButtonImageView, "SettingsButton.png");
		setButtonBehavior(exitButtonImageView, "QuitButton.png");
		setButtonBehavior(closeButtonImageView, "X.png");

	}
	
	private void setButtonBehavior(ImageView buttonImageView, String imagePath) {
	    buttonImageView.setOnMouseEntered(event -> {
	        Image newImage = new Image(new File(RESOURCES_PATH + "/icons/on/" + imagePath).toURI().toString(),
	                responsive, responsive / 3, true, true);
	        buttonImageView.setImage(newImage);
	        soundBox.playAudio(RESOURCES_PATH + "/audio/select.ogg");
	    });

	    buttonImageView.setOnMouseExited(event -> {
	        buttonImageView.setImage(new Image(new File(RESOURCES_PATH + "/icons/off/" + imagePath).toURI().toString(),
	                responsive, responsive / 3, true, true));
	    });
	}

	public static void main(String[] args) throws SQLException {
		launch(args);
		Platform.exit();
		System.exit(0);
	}

}