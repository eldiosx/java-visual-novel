package application.prologue;

import application.BackgroundMusic;
import application.VoiceBox;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Stage5 {
	// private static final String RESOURCES_PATH = new File("").getAbsolutePath();
	private VoiceBox voiceBox = new VoiceBox();
	private BackgroundMusic backgroundMusic = new BackgroundMusic();
	private Timeline timeline = new Timeline(); // initialize the timeline variable

	@FXML
	private Button Ir;

	@FXML
	public void initialize() {
		// backgroundMusic.playAudio(RESOURCES_PATH + "");//insertar pista de audio
		// inicio prologo
		// voiceBox.playAudio(RESOURCES_PATH + "");
		Ir.setOnAction(event -> {
			try {
				// Crear un nuevo Stage
				voiceBox.stopAudio();
				backgroundMusic.stopAudio();
				Stage stage = MainPrologue.createStage("Prologue_Scene_Builder2.fxml", "SecondStage");

				// Mostrar el nuevo Stage
				MainPrologue.showStage(stage);

				// Ocultar el Stage principal
				MainPrologue.hideStage(MainPrologue.getCurrentStage());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		// Dialogo que se escribe a tiempo real, se puede modificar la duracion para que
		// vaya al ritmo de las voces y ajustar dependiendo el idioma

		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();

	}
}
