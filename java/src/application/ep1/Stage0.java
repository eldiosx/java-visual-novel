package application.ep1;

import java.io.File;

import application.BackgroundMusic;
import application.VoiceBox;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Stage0 {
	private static final String RESOURCES_PATH = new File("assets").getAbsolutePath();
	private VoiceBox voiceBox = new VoiceBox();
	private BackgroundMusic backgroundMusic = new BackgroundMusic();


	@FXML
	private Button John;
	
	@FXML
	private Button Marleene;
	
	@FXML
	private Button Helen;
	
	@FXML
	private Button Chan;
	
	@FXML
	private Button Travis;

	@FXML
	public void initialize() {
		backgroundMusic.playAudio(RESOURCES_PATH + "/audio/horrorHeartbeat.ogg");
		//voiceBox.playAudio(RESOURCES_PATH + "/audio/jhon.ogg");
		John.setOnAction(event -> {
			try {
				// llamada a la escena de John
				voiceBox.stopAudio();
				backgroundMusic.stopAudio();
				Stage stage = MainEp1.createStage("Stage1.fxml", "SecondStage");
				// Mostrar el nuevo Stage, que es el de John
				MainEp1.showStage(stage);

				// Ocultar el Stage principal
				MainEp1.hideStage(MainEp1.getPrimaryStage());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		Marleene.setOnAction(event -> {
			try {
				// llamada a la escena de Marleene

				// Mostrar el nuevo Stage, que es el de Marleene
				//Main.showStage(stage);

				// Ocultar el Stage principal
				MainEp1.hideStage(MainEp1.getPrimaryStage());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		Helen.setOnAction(event -> {
			try {
				// llamada a la escena de Helen

				// Mostrar el nuevo Stage, que es el de Helen
				//Main.showStage(stage);

				// Ocultar el Stage principal
				MainEp1.hideStage(MainEp1.getPrimaryStage());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		Chan.setOnAction(event -> {
			try {
				// llamada a la escena de Chan

				// Mostrar el nuevo Stage, que es el de Chan
				//Main.showStage(stage);

				// Ocultar el Stage principal
				MainEp1.hideStage(MainEp1.getPrimaryStage());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		Travis.setOnAction(event -> {
			try {
				// llamada a la escena de Travis

				// Mostrar el nuevo Stage, que es el de Travis
				//Main.showStage(stage);

				// Ocultar el Stage principal
				MainEp1.hideStage(MainEp1.getPrimaryStage());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		;

	}
}
