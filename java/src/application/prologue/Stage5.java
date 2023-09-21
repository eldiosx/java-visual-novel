package application.prologue;

import java.io.File;

import application.BackgroundMusic;
import application.VoiceBox;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Stage5 {
	private static final String RESOURCES_PATH = new File("assets").getAbsolutePath();
	private VoiceBox voiceBox = new VoiceBox();
	private BackgroundMusic backgroundMusic = new BackgroundMusic();
	private Timeline timeline = new Timeline(); // initialize the timeline variable

	@FXML
	private Button Ir;

	@FXML
	public void initialize() {
		backgroundMusic.playAudio(RESOURCES_PATH + "/audio/happyForest.ogg");
		// voiceBox.playAudio(RESOURCES_PATH + "");
		Ir.setOnAction(event -> {
			try {
				voiceBox.stopAudio();
				backgroundMusic.stopAudio();
				Stage currentStage = MainPrologue.getCurrentStage();
				Stage stage = MainPrologue.createStage("Prologue2.fxml", "SecondStage");
				MainPrologue.showStage(stage);
				currentStage.hide();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();

	}
}
