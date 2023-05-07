package application.prologue;

import java.io.File;

import application.BackgroundMusic;
import application.VoiceBox;
import application.ep1.MainEp1;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Stage3 {
	private static final String RESOURCES_PATH = new File("assets").getAbsolutePath();
	private VoiceBox voiceBox = new VoiceBox();
	private BackgroundMusic backgroundMusic = new BackgroundMusic();
	private int currentIndex = 0;
	MainEp1 mainEp1 = new MainEp1(); // Crea una instancia de la clase Main
	Stage stage = new Stage();
	private String text = "He hablado con Marleene para hacer una fogata esta noche y contar historias. Nos vemos esta noche";
	private Timeline timeline;

	@FXML
	private Label dialogue;

	@FXML
	private Button Continue;

	@FXML
	public void initialize() {
		backgroundMusic.playAudio(RESOURCES_PATH + "/audio/happyForest.ogg");
		// voiceBox.playAudio(RESOURCES_PATH + "");

		Continue.setOnAction(event -> {
			try {
				// Crear un nuevo Stage
				voiceBox.stopAudio();
				backgroundMusic.stopAudio();
				mainEp1.start(stage);// tiene que llevar al episodio 1

				// Ocultar el Stage principal
				MainPrologue.hideStage(MainPrologue.getCurrentStage());
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
