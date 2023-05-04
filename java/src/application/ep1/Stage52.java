package application.ep1;

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

public class Stage52 {//interacctua john
	private static final String RESOURCES_PATH = new File("assets").getAbsolutePath();
	private VoiceBox voiceBox = new VoiceBox();
	private BackgroundMusic backgroundMusic = new BackgroundMusic();
	private int currentIndex = 0;
	private String text = "Pues yo creo que era una aparición de alguien que se habría muerto en la carretera y nunca pudo llegar a casa… En fin… Deberíamos ir yéndonos a dormir, que se está haciendo tarde.";
	private Timeline timeline;

	@FXML
	private Label dialogue;

	@FXML
	private Button go;
	
	@FXML
	private Button stay;
	

	@FXML
	public void initialize() {
//		backgroundMusic.playAudio(RESOURCES_PATH + "/audio/firecamp.ogg");
//		voiceBox.playAudio(RESOURCES_PATH + "/audio/jhon03.ogg");
		go.setOnAction(event -> {
			try {
				// Crear un nuevo Stage
				voiceBox.stopAudio();
				backgroundMusic.stopAudio();
				Stage stage = MainEp1.createStage("Stage72.fxml", "SecondStage");

				// Mostrar el nuevo Stage
				MainEp1.showStage(stage);

				// Ocultar el Stage principal
				MainEp1.hideStage(MainEp1.getPrimaryStage());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		stay.setOnAction(event -> {
			try {
				// Crear un nuevo Stage
				voiceBox.stopAudio();
				backgroundMusic.stopAudio();
				Stage stage = MainEp1.createStage("Stage0.fxml", "SecondStage");

				// Mostrar el nuevo Stage
				MainEp1.showStage(stage);

				// Ocultar el Stage principal
				MainEp1.hideStage(MainEp1.getPrimaryStage());
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