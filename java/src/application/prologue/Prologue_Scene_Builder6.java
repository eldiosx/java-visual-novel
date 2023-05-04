package application.prologue;

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

//public class Prologue_Scene_Builder6 {
//	//private static final String RESOURCES_PATH = new File("").getAbsolutePath();
//	private VoiceBox voiceBox = new VoiceBox();
//	private BackgroundMusic backgroundMusic = new BackgroundMusic();
//	private int currentIndex = 0;
//	private String text = "Bienvenido al campamento The Otter. Espero que estés preparado para dos semanas de diversión.Tus compañeros ya están ubicados en sus cabañas. ";
//	private Timeline timeline;
//
//	@FXML
//	private Label dialogue;
//
//	@FXML
//	private Button Bien;
//	@FXML
//	private Button Cansado;
//
//	@FXML
//	public void initialize() {
//	//	backgroundMusic.playAudio(RESOURCES_PATH + "");//insertar pista de audio inicio prologo
//		//voiceBox.playAudio(RESOURCES_PATH + "");
//		Bien.setOnAction(event -> {
//			try {
//				// Crear un nuevo Stage
//				voiceBox.stopAudio();
//				backgroundMusic.stopAudio();
//				Stage stage = MainPrologue.createStage("Prologue_Scene_Builder7.fxml", "SecondStage");
//
//				// Mostrar el nuevo Stage
//				MainPrologue.showStage(stage);
//
//				// Ocultar el Stage principal
//				MainPrologue.hideStage(MainPrologue.getPrimaryStage());
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		});
//		Cansado.setOnAction(event -> {
//			try {
//				// Crear un nuevo Stage
//				voiceBox.stopAudio();
//				backgroundMusic.stopAudio();
//				Stage stage = MainPrologue.createStage("Prologue_Scene_Builder7.fxml", "SecondStage");
//				// Ocultar el Stage principal
//				MainPrologue.hideStage(MainPrologue.getPrimaryStage());
//				
//				// Mostrar el nuevo Stage
//				MainPrologue.showStage(stage);
//				
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		});
//		// Dialogo que se escribe a tiempo real, se puede modificar la duracion para que
//		// vaya al ritmo de las voces y ajustar dependiendo el idioma
//		dialogue.setFont(Font.font("Arial", 24));
//		timeline = new Timeline(new KeyFrame(Duration.seconds(0.05), event -> {
//			if (currentIndex > text.length()) {
//				timeline.stop();
//			} else {
//				String currentText = text.substring(0, currentIndex);
//				dialogue.setText(currentText);
//				currentIndex++;
//			}
//		}));
//		timeline.setCycleCount(Timeline.INDEFINITE);
//		timeline.play();
//
//	}
//}
public class Prologue_Scene_Builder6 {
	//private static final String RESOURCES_PATH = new File("").getAbsolutePath();
	private VoiceBox voiceBox = new VoiceBox();
	private BackgroundMusic backgroundMusic = new BackgroundMusic();
	private Timeline timeline = new Timeline(); // initialize the timeline variable

	@FXML
	private Label dialogue;

	@FXML
	private Button Bien;
	@FXML
	private Button Cansado;

	@FXML
	public void initialize() {
	//	backgroundMusic.playAudio(RESOURCES_PATH + "");//insertar pista de audio inicio prologo
		//voiceBox.playAudio(RESOURCES_PATH + "");
		Bien.setOnAction(event -> {
			try {
				// Crear un nuevo Stage
				voiceBox.stopAudio();
				backgroundMusic.stopAudio();
				Stage stage = MainPrologue.createStage("Prologue_Scene_Builder7.fxml", "SecondStage");

				// Mostrar el nuevo Stage
				MainPrologue.showStage(stage);

				// Ocultar el Stage principal
				MainPrologue.hideStage(MainPrologue.getPrimaryStage());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		Cansado.setOnAction(event -> {
			try {
				// Crear un nuevo Stage
				voiceBox.stopAudio();
				backgroundMusic.stopAudio();
				Stage stage = MainPrologue.createStage("Prologue_Scene_Builder7.fxml", "SecondStage");
				// Ocultar el Stage principal
				MainPrologue.hideStage(MainPrologue.getPrimaryStage());
				
				// Mostrar el nuevo Stage
				MainPrologue.showStage(stage);
				
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

