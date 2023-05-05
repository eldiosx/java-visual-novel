package application.ep1;

import java.io.File;

import application.BackgroundMusic;
import application.VoiceBox;
import application.end.Credits;
import application.ep2.Ep2;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Stage71 {//Chang habla antes de ver el cuerpo
	//private static final String RESOURCES_PATH = new File("assets").getAbsolutePath();
	//private VoiceBox voiceBox = new VoiceBox();
	Credits credits = new Credits(); // Crea una instancia de la clase Credits
	Ep2 ep2= new Ep2(); // Crea una instancia de la clase Ep2
	Stage stage = new Stage();
	//private BackgroundMusic backgroundMusic = new BackgroundMusic();
	private int currentIndex = 0;
	private String text = "Esta puerta no deberia estar abierta";
	private Timeline timeline;

	@FXML
	private Label dialogue;
	
	@FXML
	private Button Continue;

	@FXML
	public void initialize() {
//		backgroundMusic.playAudio(RESOURCES_PATH + "/audio/firecamp.ogg");
//		voiceBox.playAudio(RESOURCES_PATH + "/audio/jhon03.ogg");
		Continue.setOnAction(event -> {
			try {
				// Crear un nuevo Stage del episodio 2
				ep2.start (stage);
				
				// Ocultar el Stage principal (EP1)
				MainEp1.hideStage(MainEp1.getPrimaryStage());
				
				// Ocultar el Stage del EP2
				ep2.hideStage(ep2.getPrimaryStage());
				
				//Inicia los Créditos
				credits.start(stage);
				
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
