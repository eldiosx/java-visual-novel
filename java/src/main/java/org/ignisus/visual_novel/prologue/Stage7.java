package org.ignisus.visual_novel.prologue;

import java.io.File;

import org.ignisus.visual_novel.BackgroundMusic;
import org.ignisus.visual_novel.VoiceBox;
import org.ignisus.visual_novel.ep1.MainEp1;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Stage7 {
	private static final String RESOURCES_PATH = new File("src/main/resources/assets").getAbsolutePath();
	private VoiceBox voiceBox = new VoiceBox();
	MainEp1 mainEp1 = new MainEp1(); 
	Stage stage = new Stage();
	private BackgroundMusic backgroundMusic = new BackgroundMusic();
	private int currentIndex = 0;
	private String text = "¿Descansar? Eso es para los viejos, esta noche hay hoguera y vamos a contar historias, hasta Helen se ha animado a venir	"
			+ "Te veo esta noche entonces";
	private Timeline timeline = new Timeline();

	@FXML
	private Label dialogue;

	@FXML
	private Button porSupuesto;
	@FXML
	private Button noMeGustan;
	@FXML
	private Button uffPereza;

	@FXML
	public void initialize() {
		backgroundMusic.playAudio(RESOURCES_PATH + "/audio/nightForest.ogg");
		voiceBox.playAudio(RESOURCES_PATH + "/audio/marlene02.ogg");
		porSupuesto.setOnAction(event -> {
			try {
				// Crear un nuevo Stage
				voiceBox.stopAudio();
				backgroundMusic.stopAudio();
				Stage currentStage = MainPrologue.getCurrentStage();
				mainEp1.start(stage);// tiene que llevar al episodio 1
				
				currentStage.hide();

			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		noMeGustan.setOnAction(event -> {
			try {
				// Crear un nuevo Stage
				voiceBox.stopAudio();
				backgroundMusic.stopAudio();
				Stage currentStage = MainPrologue.getCurrentStage();
				mainEp1.start(stage);// tiene que llevar al episodio 1
				
				currentStage.hide();

			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		uffPereza.setOnAction(event -> {
			try {
				// Crear un nuevo Stage
				voiceBox.stopAudio();
				backgroundMusic.stopAudio();
				mainEp1.start(stage);// tiene que llevar al episodio 1
				
				MainPrologue.hideStage(MainPrologue.getCurrentStage());

			} catch (Exception e) {
				e.printStackTrace();
			}
		});
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
