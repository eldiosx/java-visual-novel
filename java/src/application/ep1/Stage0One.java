package application.ep1;

import java.io.File;

import application.BackgroundMusic;
import application.VoiceBox;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Stage0One {
	private static final String RESOURCES_PATH = new File("assets").getAbsolutePath();
	private VoiceBox voiceBox = new VoiceBox();
	private BackgroundMusic backgroundMusic = new BackgroundMusic();

	@FXML
	private Button John;

	@FXML
	private Button Abandonar;

	@FXML
	private Button Marleene;

	@FXML
	private Button Helen;

	@FXML
	private Button Chan;

	@FXML
	private Button Travis;

	int count = 0;

	@FXML
	public void initialize() {
		backgroundMusic.playAudio(RESOURCES_PATH + "/audio/horrorHeartbeat.ogg");
		// voiceBox.playAudio(RESOURCES_PATH + "/audio/jhon.ogg");
		John.setOnAction(event -> {
			try {
				// llamada a la escena de John
				voiceBox.stopAudio();
				backgroundMusic.stopAudio();
				Stage currentStage = (Stage) John.getScene().getWindow();
				Stage stage = MainEp1.createStage("Stage1.fxml", "SecondStage");
//				// Mostrar el nuevo Stage, que es el de John
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
			count++; // incrementamos el contador
			if (count >= 3) { // si ya se pulsaron 4 botones
				disableRemainingButtons(); // desactivamos los botones restantes
			}
		});

		Marleene.setOnAction(event -> {
			try {
				// llamada a la escena de Marleene
				voiceBox.stopAudio();
				backgroundMusic.stopAudio();
				Stage currentStage = (Stage) Marleene.getScene().getWindow();
				Stage stage = MainEp1.createStage("Stage31.fxml", "SecondStage");
//				// Mostrar el nuevo Stage, que es el de Marleene
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
			count++; // incrementamos el contador
			if (count >= 3) { // si ya se pulsaron 4 botones
				disableRemainingButtons(); // desactivamos los botones restantes
			}
		});

		Helen.setOnAction(event -> {
			try {
				// llamada a la escena de Helen
				voiceBox.stopAudio();
				backgroundMusic.stopAudio();
				Stage currentStage = (Stage) Helen.getScene().getWindow();
				Stage stage = MainEp1.createStage("Stage51.fxml", "SecondStage");
//				// Mostrar el nuevo Stage, que es el de Helen
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
			count++; // incrementamos el contador
			if (count >= 3) { // si ya se pulsaron 4 botones
				disableRemainingButtons(); // desactivamos los botones restantes
			}
		});

		Chan.setOnAction(event -> {
			try {
				// llamada a la escena de Chan
				voiceBox.stopAudio();
				backgroundMusic.stopAudio();
				Stage currentStage = (Stage) Chan.getScene().getWindow();
				Stage stage = MainEp1.createStage("Stage61.fxml", "SecondStage");
//				// Mostrar el nuevo Stage, que es el de Chan
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
			count++; // incrementamos el contador
			if (count >= 3) { // si ya se pulsaron 4 botones
				disableRemainingButtons(); // desactivamos los botones restantes
			}
		});

		Travis.setOnAction(event -> {
			try {
				// llamada a la escena de Travis
				voiceBox.stopAudio();
				backgroundMusic.stopAudio();
				Stage currentStage = (Stage) Travis.getScene().getWindow();
				Stage stage = MainEp1.createStage("Stage41.fxml", "SecondStage");
//				// Mostrar el nuevo Stage, que es el de Travis
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
			count++; // incrementamos el contador
			if (count >= 3) { // si ya se pulsaron 4 botones
				disableRemainingButtons(); // desactivamos los botones restantes
			}
		});
		Abandonar.setOnAction(event -> {
			try {
				// llamada a la escena de Helen
				voiceBox.stopAudio();
				backgroundMusic.stopAudio();
				Stage currentStage = (Stage) Helen.getScene().getWindow();
				Stage stage = MainEp1.createStage("Stage51.fxml", "SecondStage");
//				// Mostrar el nuevo Stage, que es el de Helen
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
		;

	}

	private void disableRemainingButtons() {
		for (Node node : Travis.getParent().getChildrenUnmodifiable()) {
			if (node instanceof Button && !node.isDisabled()) { // si es un botón habilitado
				((Button) node).setDisable(true); // lo desactivamos
			}
		}
	}
}
