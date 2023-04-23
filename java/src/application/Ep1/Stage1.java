package application.Ep1;

import java.io.File;

import application.VoiceBox;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Stage1 {
	private static final String RESOURCES_PATH = new File("assets").getAbsolutePath();
	private VoiceBox voiceBox = new VoiceBox();
    private int currentIndex = 0;
    private String text = "Vale, pues os voy a contar mi historia: Había un anciano señor en una vieja casa no muy lejos de aquí. El reloj de cucú de aquel hombre marcó las 10:00 de la noche, mientras este apagaba las lámparas de aceite alrededor de su casa para ir a dormir, había sido un día muy pesado. Poco después de que el reloj diera las 10:00 de la noche, cuando ya había ido a dormir, se escuchó tocar la puerta.- TOC, TOC, TOC - Algo extrañado, encendió la lámpara de la mesa de noche, y fue destinado a abrir la puerta. Y al abrirla, alcanzó a ver por el brillo que emanaba su lámpara, a una niña de no más de 7 años, totalmente quemada.";
    private Timeline timeline;

	@FXML
	private Label dialogue;

	@FXML
	private Button myButton;

	@FXML
	public void initialize() {
		voiceBox.playAudio(RESOURCES_PATH + "/audio/jhon.ogg");
		myButton.setOnAction(event -> {
			try {
				// Crear un nuevo Stage
				Stage stage = Main.createStage("Stage2.fxml", "SecondStage");

				// Mostrar el nuevo Stage
				Main.showStage(stage);

				// Ocultar el Stage principal
				Main.hideStage(Main.getPrimaryStage());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	//Dialogo que se escribe a tiempo real, se puede modificar la duracion para que vaya al ritmo de las voces y ajustar dependiendo el idioma
        dialogue.setFont(Font.font("Arial", 24));
        timeline = new Timeline(
                new KeyFrame(Duration.seconds(0.05), event -> {
                    if (currentIndex > text.length()) {
                        timeline.stop();
                    } else {
                        String currentText = text.substring(0, currentIndex);
                        dialogue.setText(currentText);
                        currentIndex++;
                    }
                })
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        
	}
}
