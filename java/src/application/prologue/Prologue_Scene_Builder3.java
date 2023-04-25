package application.prologue;

import java.io.File;

import application.BackgroundMusic;
import application.VoiceBox;
import application.prologue.Main;
import application.ep1.Stage1;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Prologue_Scene_Builder3 {
	//private static final String RESOURCES_PATH = new File("").getAbsolutePath();
	private VoiceBox voiceBox = new VoiceBox();
	private BackgroundMusic backgroundMusic = new BackgroundMusic();
	private int currentIndex = 0;
	private String text = "He hablado con Marleene para hacer una fogata esta noche y contar historias. Nos vemos esta noche";
	private Timeline timeline;

	@FXML
	private Label dialogue;

	@FXML
	private Button Continue;
	@FXML
	public void initialize() {
	//	backgroundMusic.playAudio(RESOURCES_PATH + "");//insertar pista de audio inicio prologo
		//voiceBox.playAudio(RESOURCES_PATH + "");
		Continue.setOnAction(event -> {
			try {
				// Crear un nuevo Stage
				voiceBox.stopAudio();
				backgroundMusic.stopAudio();
				Stage stage = Main.createStage("Stage1.fxml", "SecondStage");

				// Mostrar el nuevo Stage
				Main.showStage(stage);

				// Ocultar el Stage principal
				Main.hideStage(Main.getPrimaryStage());
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
