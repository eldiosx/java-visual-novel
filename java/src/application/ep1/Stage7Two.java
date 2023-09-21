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

public class Stage7Two {// Chang habla antes de ver el cuerpo
	private static final String RESOURCES_PATH = new File("assets").getAbsolutePath();
	private VoiceBox voiceBox = new VoiceBox();
	private BackgroundMusic backgroundMusic = new BackgroundMusic();
	private int currentIndex = 0;
	private String text = "Esta puerta no deberia estar abierta...";
	private Timeline timeline;

	@FXML
	private Label dialogue;

	@FXML
	private Button Continue;

	@FXML
	public void initialize() {
		backgroundMusic.playAudio(RESOURCES_PATH + "/audio/firecamp.ogg");
		voiceBox.playAudio(RESOURCES_PATH + "/audio/chan03.ogg");
		Continue.setOnAction(event -> {
			try {
				voiceBox.stopAudio();
				backgroundMusic.stopAudio();
				Stage currentStage = (Stage) Continue.getScene().getWindow();
				Stage stage = MainEp1.createStage("Stage2.fxml", "SecondStage");
				MainEp1.showStage(stage);
				currentStage.hide();
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
