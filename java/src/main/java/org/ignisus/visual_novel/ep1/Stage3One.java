package org.ignisus.visual_novel.ep1;

import java.io.File;

import org.ignisus.visual_novel.BackgroundMusic;
import org.ignisus.visual_novel.VoiceBox;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Stage3One {// Marlene comienzo
	private static final String RESOURCES_PATH = new File("src/main/resources/assets").getAbsolutePath();
	private VoiceBox voiceBox = new VoiceBox();
	private BackgroundMusic backgroundMusic = new BackgroundMusic();
	private int currentIndex = 0;
	private String text = "La historia que voy a contar le pasó a mi padre cuando era joven, o eso me ha contado. Tenía 19 años y vivía en Francia, en una casa bastante grande que estaba a las afueras.\r\n"
			+ "Mi padre tiene dos hermanas más pequeñas y la más pequeña de los tres tenía 6 años y solía subir a jugar a la buhardilla con las muñecas.\r\n"
			+ "Un día empezó a decirle a mi padre que cuando subía a jugar siempre oía ruidos como si tirasen como una pelota y rodase por el suelo, pero que luego nunca veía nada. Mi padre le quitaba importancia puesto que pensaba que eran las típicas imaginaciones de una niña, pero mi tía insistía en que se oían ruidos sin verse nada.\r\n"
			+ "Mi padre se lo contó a mi abuelo y viendo que mi tía dejó de subir allí a jugar decidieron comprobar un día si era cierto que se oían esos ruidos extraños. Subieron arriba, se colocaron uno a cada lado de la buhardilla con una linterna cada uno y todo apagado y si oían algo encender las linternas para ver si verdaderamente había algo allí que provocase los ruidos.\r\n"
			+ "Permanecieron un buen rato allí parados esperando, y de repente, verdaderamente se empezaron a oír ruidos como los que había mencionado mi tía. Un sonido como si tirasen una nuez desde arriba del todo y cayera rodando por el suelo, y en ese momento encendieron las linternas pero no consiguieron ver nada, de manera que las apagaron y esperaron otra vez pensando que habían llegado tarde a encenderlas y que sería alguna rata o algun animal que se habría colado.\r\n"
			+ ".";
	private Timeline timeline;

	@FXML
	private Label dialogue;

	@FXML
	private Button myButton;

	@FXML
	public void initialize() {
		backgroundMusic.playAudio(RESOURCES_PATH + "/audio/firecamp.ogg");
		voiceBox.playAudio(RESOURCES_PATH + "/audio/marlene05.ogg");
		myButton.setOnAction(event -> {
			try {
				// Crear un nuevo Stage
				voiceBox.stopAudio();
				backgroundMusic.stopAudio();
				Stage currentStage = (Stage) myButton.getScene().getWindow();
				Stage stage = MainEp1.createStage("Stage32.fxml", "SecondStage");

//				// Mostrar el nuevo Stage
//				MainEp1.showStage(stage);
//
//				
//				MainEp1.hideStage(MainEp1.getPrimaryStage());
				// Mostrar el nuevo Stage
				MainEp1.showStage(stage);

				// Ocultar el Stage actual
				currentStage.hide(); // Agregar esta línea
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
