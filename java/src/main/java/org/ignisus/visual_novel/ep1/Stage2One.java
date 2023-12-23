package org.ignisus.visual_novel.ep1;

import java.io.File;

import org.ignisus.visual_novel.BackgroundMusic;
import org.ignisus.visual_novel.SoundBox;
//import org.ignisus.visual_novel.VoiceBox;
import org.ignisus.visual_novel.end.Credits;
import org.ignisus.visual_novel.ep2.Ep2;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Stage2One {

	// Instanciamos la pantalla de creditos
	private static final String RESOURCES_PATH = new File("src/main/resources/assets").getAbsolutePath();
	// private VoiceBox voiceBox = new VoiceBox();
	private SoundBox soundBox = new SoundBox();
	private BackgroundMusic backgroundMusic = new BackgroundMusic();
	Credits credits = new Credits(); // Crea una instancia de la clase Credits
	Ep2 ep2 = new Ep2(); // Crea una instancia de la clase Ep2

	Stage stage = new Stage();

	@FXML
	private Button body;

	@FXML
	private Button hand; 

	@FXML
	private Button continueEnd; 

	@FXML
	private Button knife; 

	@FXML
	private Label knifeText; 

	@FXML
	private Button room; 

	@FXML
	private Button blood; 

	@FXML
	private Button floor; 
	@FXML
	private Label bodytext; 

	@FXML
	private Label handtext; 

	@FXML
	private Label roomtext; 

	@FXML
	private Label bloodtext; 

	@FXML
	private Label floortext; 

	int count = 0;
	boolean isRunning = true;

	@FXML
	public void initialize() {
		continueEnd.setDisable(true);

		backgroundMusic.playAudio(RESOURCES_PATH + "/audio/horrorHeartbeat.ogg");
		continueEnd.setOnAction(event -> {
			try {
				soundBox.playAudio(RESOURCES_PATH + "/audio/click.ogg");
				backgroundMusic.stopAudio();
				MainEp1.hideStage(MainEp1.getCurrentStage());
				credits.start(stage);

			} catch (Exception e) {
				e.printStackTrace();
			}

		});

		// Evento boton de suelo
		floor.setOnAction(event -> {
			try {
				soundBox.playAudio(RESOURCES_PATH + "/audio/rope.ogg");
				floortext.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
			count++; // incrementamos el contador
			if (count >= 3) { // si ya se pulsaron 4 botones
				disableRemainingButtons(); // desactivamos los botones restantes
			}
		});

		// Evento boton de sala
		room.setOnAction(event -> {
			try {
				soundBox.playAudio(RESOURCES_PATH + "/audio/rope.ogg");
				roomtext.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
			count++; // incrementamos el contador
			if (count >= 4) { // si ya se pulsaron 4 botones
				disableRemainingButtons(); // desactivamos los botones restantes
			}
		});

		// Evento boton de mano
		hand.setOnAction(event -> {
			try {
				soundBox.playAudio(RESOURCES_PATH + "/audio/rope.ogg");
				handtext.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
			count++; // incrementamos el contador
			if (count >= 3) { // si ya se pulsaron 4 botones
				disableRemainingButtons(); // desactivamos los botones restantes
			}
		});

		// Evento boton de cuchillo
		knife.setOnAction(event -> {
			try {
				soundBox.playAudio(RESOURCES_PATH + "/audio/knife.ogg");
				knifeText.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
			count++; // incrementamos el contador
			if (count >= 3) { // si ya se pulsaron 4 botones
				disableRemainingButtons(); // desactivamos los botones restantes
			}
		});

		// Evento boton de sangre
		blood.setOnAction(event -> {
			try {
				soundBox.playAudio(RESOURCES_PATH + "/audio/rope.ogg");
				bloodtext.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
			count++; // incrementamos el contador
			if (count >= 3) { // si ya se pulsaron 4 botones
				disableRemainingButtons(); // desactivamos los botones restantes
			}
		});

		// Evento boton de cadaver
		body.setOnAction(event -> {
			try {
				soundBox.playAudio(RESOURCES_PATH + "/audio/rope.ogg");
				bodytext.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
			count++; // incrementamos el contador
			if (count >= 3) { // si ya se pulsaron 4 botones
				disableRemainingButtons(); // desactivamos los botones restantes
			}
		});

	}

	private void disableRemainingButtons() {
		for (Node node : body.getParent().getChildrenUnmodifiable()) {
			if (node instanceof Button && !node.isDisabled()) { // si es un botón habilitado
				((Button) node).setDisable(true); // lo desactivamos
				continueEnd.setDisable(false); // Activamos el continueeee

			}
		}
	}
}
