package application.prologue;

import java.io.File;

import application.BackgroundMusic;
import application.VoiceBox;
import application.ep1.MainEp1;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
	MainEp1 mainEp1 = new MainEp1(); 
	Stage stage = new Stage();
	private String text = "Hey, pensé que ya no llegabas. ¿Qué tal el viaje?";
	private String text2 = "He hablado con Marleene para hacer una fogata esta noche y contar historias. Nos vemos esta noche";
	private Timeline timeline;

	@FXML
	private Label dialogue;
	@FXML
	private Button continueButton;

	@FXML
	private Button Bien;
	@FXML
	private Button Mieh;

	@FXML
	public void initialize() {
		continueButton.setVisible(false);
		voiceBox.playAudio(RESOURCES_PATH + "/audio/jhon01.ogg");
		backgroundMusic.playAudio(RESOURCES_PATH + "/audio/happyForest.ogg");
//Envento que se iniciara cuando se cumpla una condicion y asi queda menos simio (aplicar en el futuro)
		EventHandler<ActionEvent> buttonHandler = event -> {
			try {
				// Crear un nuevo Stage
				voiceBox.stopAudio();
				timeline.stop();
				Mieh.setVisible(false);
				Bien.setVisible(false);
				continueButton.setVisible(true);
				currentIndex = 0;
				dialogue.setText("");
				voiceBox.playAudio(RESOURCES_PATH + "/audio/jhon02.ogg");

				dialogue.setFont(Font.font("Arial", 24));
				timeline = new Timeline(new KeyFrame(Duration.seconds(0.05), event2 -> {
					if (currentIndex > text2.length()) {
						timeline.stop();
					} else {
						String currentText = text2.substring(0, currentIndex);
						dialogue.setText(currentText);
						currentIndex++;
					}
				}));
				timeline.setCycleCount(Timeline.INDEFINITE);
				timeline.play();

				continueButton.setOnAction(event3 -> {
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

			} catch (Exception e) {
				e.printStackTrace();
			}
		};

		Bien.setOnAction(buttonHandler);
		Mieh.setOnAction(buttonHandler);

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
