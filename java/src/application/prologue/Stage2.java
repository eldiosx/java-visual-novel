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

public class Stage2 {
	private static final String RESOURCES_PATH = new File("assets").getAbsolutePath();
	private VoiceBox voiceBox = new VoiceBox();
	private BackgroundMusic backgroundMusic = new BackgroundMusic();
	private int currentIndex = 0;
	private String text = "Hey, pensé que ya no llegabas. ¿Qué tal el viaje?";
	private Timeline timeline;

	@FXML
	private Label dialogue;

	@FXML
	private Button Bien;
	@FXML
	private Button Mieh;

	@FXML
	public void initialize() {
		voiceBox.playAudio(RESOURCES_PATH + "/audio/jhon01.ogg");
		backgroundMusic.playAudio(RESOURCES_PATH + "/audio/happyForest.ogg");
		Bien.setOnAction(event -> {
			try {
				// Crear un nuevo Stage
				voiceBox.stopAudio();
				backgroundMusic.stopAudio();
				// Ocultar el Stage principal
				MainPrologue.hideStage(MainPrologue.getCurrentStage());
				Stage stage = MainPrologue.createStage("Prologue_Scene_Builder3.fxml", "SecondStage");

				// Mostrar el nuevo Stage
				MainPrologue.showStage(stage);

			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		Mieh.setOnAction(event -> {
			try {
				// Crear un nuevo Stage
				voiceBox.stopAudio();
				backgroundMusic.stopAudio();
				// Ocultar el Stage principal
				MainPrologue.hideStage(MainPrologue.getCurrentStage());
				Stage stage = MainPrologue.createStage("Prologue_Scene_Builder3.fxml", "SecondStage");

				// Mostrar el nuevo Stage
				MainPrologue.showStage(stage);

			} catch (Exception e) {
				e.printStackTrace();
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