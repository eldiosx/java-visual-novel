package application.ep1;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

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


public class Stage2 {
	
	private static final String RESOURCES_PATH = new File("assets").getAbsolutePath();
	private VoiceBox voiceBox = new VoiceBox();
	private BackgroundMusic backgroundMusic = new BackgroundMusic();
	private int currentIndex = 0;
	private String text = "Vale, pues os voy a contar mi historia: Había un anciano señor en una vieja casa no muy lejos de aquí. El reloj de cucú de aquel hombre marcó las 10:00 de la noche, mientras este apagaba las lámparas de aceite alrededor de su casa para ir a dormir, había sido un día muy pesado. Poco después de que el reloj diera las 10:00 de la noche, cuando ya había ido a dormir, se escuchó tocar la puerta.- TOC, TOC, TOC - Algo extrañado, encendió la lámpara de la mesa de noche, y fue destinado a abrir la puerta. Y al abrirla, alcanzó a ver por el brillo que emanaba su lámpara, a una niña de no más de 7 años, totalmente quemada.";
	private Timeline timeline;

	    @FXML // ResourceBundle that was given to the FXMLLoader
	    private ResourceBundle resources;

	    @FXML // URL location of the FXML file that was given to the FXMLLoader
	    private URL location;

	    @FXML // fx:id="General"
	    private Button General; // Value injected by FXMLLoader

	    @FXML // fx:id="investigarcuchillo"
	    private Button investigarcuchillo; // Value injected by FXMLLoader

	    @FXML // fx:id="investigarcuerpo"
	    private Button investigarcuerpo; // Value injected by FXMLLoader

	    @FXML // fx:id="investigarmano"
	    private Button investigarmano; // Value injected by FXMLLoader

	    @FXML // fx:id="investigarsala"
	    private Button investigarsala; // Value injected by FXMLLoader

	    @FXML // fx:id="investigarsangre"
	    private Button investigarsangre; // Value injected by FXMLLoader

	    @FXML // fx:id="investigarsuelo"
	    private Button investigarsuelo; // Value injected by FXMLLoader

	    @FXML // fx:id="labelSuelo"
	    private Label labelSuelo; // Value injected by FXMLLoader


		@FXML
		public void initialize1() {
			backgroundMusic.playAudio(RESOURCES_PATH + "/audio/firecamp.ogg");
			voiceBox.playAudio(RESOURCES_PATH + "/audio/jhon.ogg");
			investigarsuelo.setOnAction(event -> {
				try {
					// Volver a mostrar el Stage principal
					Main.hideStage(Main.getCurrentStage());
					// Volver a mostrar el Stage principal
					Main.showStage(Main.getPrimaryStage());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		}
	}



