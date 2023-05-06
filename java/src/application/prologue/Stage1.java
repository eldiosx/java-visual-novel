package application.prologue;

import java.io.File;
import application.BackgroundMusic;
import application.VoiceBox;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Stage1 {
	private static final String RESOURCES_PATH = new File("assets").getAbsolutePath();
	private VoiceBox voiceBox = new VoiceBox();
	private BackgroundMusic backgroundMusic = new BackgroundMusic();
	private int currentIndex = 0;
	private String text = "Hola soy Javier. Bienvenido al campamento, The Otter. Espero que estés preparado para dos semanas de diversión. Tus compañeros ya están ubicados en sus cabañas, la tuya es la número 7 puedes ir acomodandote si quieres...";
	private Timeline timeline;

	@FXML
	private Label dialogue;

	@FXML
	private Button myButton;
	@FXML
	private Button myButton2;

	@FXML
	public void initialize() {
		backgroundMusic.playAudio(RESOURCES_PATH + "/audio/happyForest.ogg");
		voiceBox.playAudio(RESOURCES_PATH + "/audio/staff.ogg");
		myButton.setOnAction(event -> {
			try {
				voiceBox.stopAudio();
				backgroundMusic.stopAudio();
				// Crear un nuevo Stage

				Stage stage = MainPrologue.createStage("Prologue_Scene_Builder2.fxml", "SecondStage");

				// Mostrar el nuevo Stage
				MainPrologue.showStage(stage);

				// Ocultar el Stage principal
				MainPrologue.hideStage(MainPrologue.getPrimaryStage());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		myButton2.setOnAction(event -> {
			try {
				voiceBox.stopAudio();
				backgroundMusic.stopAudio();
//				// Crear un nuevo Stage
				Stage stage = MainPrologue.createStage("Prologue_Scene_Builder4.fxml", "SecondStage");

				// Mostrar el nuevo Stage
				MainPrologue.showStage(stage);

//				// Ocultar el Stage principal
				MainPrologue.hideStage(MainPrologue.getPrimaryStage());
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("aqui no entra");
			}
		});
		// Dialogo que se escribe a tiempo real, se puede modificar la duracion para que
		// vaya al ritmo de las voces y ajustar dependiendo el idioma
		dialogue.setFont(Font.font("Arial", 24));
		timeline = new Timeline(new KeyFrame(Duration.seconds(0.05), event -> {
			if (currentIndex > text.length()) {
				timeline.stop();
			} else {
				String currentText = text.substring(0, currentIndex);
				dialogue.setText(currentText);
				currentIndex++;
			}
		}));
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();

	}
}
