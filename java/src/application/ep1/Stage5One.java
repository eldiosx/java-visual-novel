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

public class Stage5One {// Helen
	private static final String RESOURCES_PATH = new File("assets").getAbsolutePath();
	private VoiceBox voiceBox = new VoiceBox();
	private BackgroundMusic backgroundMusic = new BackgroundMusic();
	private int currentIndex = 0;
	private String text = "Yo no creo en estas cosas, la verdad, pero he de decir que nos pasó una cosa bastante extraña volviendo de vacaciones a Connecticut cuando nos encontramos  un hombre vestido de blanco haciendo autostop en medio de la carretera. \r\n"
			+ "Mi madre dijo de parar a recogerlo y mi padre siguió conduciendo diciéndole que cómo íbamos a recoger a un extraño. El caso es que mi madre lo consiguió convencer y, paramos un poco después de rebasarle, y al mirar no había nadie. FIN";
	private Timeline timeline;

	@FXML
	private Label dialogue;

	@FXML
	private Button myButton;

	@FXML
	public void initialize() {
//		backgroundMusic.playAudio(RESOURCES_PATH + "/audio/firecamp.ogg");
//		voiceBox.playAudio(RESOURCES_PATH + "/audio/jhon03.ogg");
		myButton.setOnAction(event -> {
			try {
				// Crear un nuevo Stage
				voiceBox.stopAudio();
				backgroundMusic.stopAudio();
				Stage currentStage = (Stage) myButton.getScene().getWindow();
				Stage stage = MainEp1.createStage("Stage52.fxml", "SecondStage");

//				// Mostrar el nuevo Stage
//				MainEp1.showStage(stage);
//
//				// Ocultar el Stage principal
//				MainEp1.hideStage(MainEp1.getPrimaryStage());
				// Mostrar el nuevo Stage
				MainEp1.showStage(stage);

				// Ocultar el Stage actual
				currentStage.hide(); // Agregar esta línea
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
