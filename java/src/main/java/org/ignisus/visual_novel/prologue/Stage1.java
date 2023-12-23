package org.ignisus.visual_novel.prologue;

import java.io.File;
import org.ignisus.visual_novel.BackgroundMusic;
import org.ignisus.visual_novel.VoiceBox;
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
import javafx.scene.layout.AnchorPane;

public class Stage1 {
	private static final String RESOURCES_PATH = new File("src/main/resources/assets").getAbsolutePath();
	private VoiceBox voiceBox = new VoiceBox();
	private BackgroundMusic backgroundMusic = new BackgroundMusic();
	private int currentIndex = 0;
	private String text = "Hola soy Javier. Bienvenido al campamento, The Otter. Espero que estés preparado para dos semanas de diversión. Tus compañeros ya están ubicados en sus cabañas, la tuya es la número 7 puedes ir acomodandote si quieres...";
	private Timeline timeline;

	@FXML
	private AnchorPane background;
	@FXML
	private Label dialogue;
	@FXML
	private Button cabin;
	@FXML
	private Button explore;
	@FXML
	private Button mirarDerecha;
	@FXML
	private Button mirarIzquierda;

	@FXML
	public void initialize() {
		mirarDerecha.setVisible(false);
		mirarIzquierda.setVisible(false);
		backgroundMusic.playAudio(RESOURCES_PATH + "/audio/happyForest.ogg");
		voiceBox.playAudio(RESOURCES_PATH + "/audio/staff.ogg");

		EventHandler<ActionEvent> buttonHandler1 = event -> {
			try {
				voiceBox.stopAudio();
				backgroundMusic.stopAudio();
				Stage stage = MainPrologue.createStage("Prologue2.fxml", "SecondStage");
				MainPrologue.showStage(stage);
				MainPrologue.hideStage(MainPrologue.getPrimaryStage());
			} catch (Exception e) {
				e.printStackTrace();
			}
		};
		EventHandler<ActionEvent> buttonHandler2 = event -> {
			voiceBox.stopAudio();
			timeline.stop();
			background.getStyleClass().removeAll("background");
			background.getStyleClass().add("background2");
			cabin.setVisible(false);
			explore.setVisible(false);
			mirarDerecha.setVisible(true);
			mirarIzquierda.setVisible(true);
			currentIndex = 0;
			dialogue.setText("");
			mirarDerecha.setOnAction(event1 -> {
				try {
					// Crear un nuevo Stage
					voiceBox.stopAudio();
					backgroundMusic.stopAudio();
					Stage currentStage = MainPrologue.getCurrentStage();
					Stage stage = MainPrologue.createStage("Prologue5.fxml", "Stage5");

					// Mostrar el nuevo Stage
					MainPrologue.showStage(stage);
					
					currentStage.hide();

				} catch (Exception e) {
					e.printStackTrace();
				}
			});
			mirarIzquierda.setOnAction(event2 -> {
				try {
					// Crear un nuevo Stage
					voiceBox.stopAudio();
					backgroundMusic.stopAudio();
					Stage currentStage = MainPrologue.getCurrentStage();
					Stage stage = MainPrologue.createStage("Prologue6.fxml", "Stage6");

					
					currentStage.hide();
					// Mostrar el nuevo Stage
					MainPrologue.showStage(stage);

				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		};

		cabin.setOnAction(buttonHandler1);
		explore.setOnAction(buttonHandler2);
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