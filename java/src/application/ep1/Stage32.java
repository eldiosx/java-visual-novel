package application.ep1;

import java.io.File;

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

public class Stage32 {//marlene fin
	private static final String RESOURCES_PATH = new File("assets").getAbsolutePath();
	private VoiceBox voiceBox = new VoiceBox();
	private BackgroundMusic backgroundMusic = new BackgroundMusic();
	private int currentIndex = 0;
	private String text = "Estuvieron así un buen rato sin conseguir ver nada, pero oyendo los ruidos que cada vez eran más frecuentes, y al final desistieron y bajaron. La historia quedó ahí y pasaron varios días, uno de ellos le dijo mi abuelo a mi padre que tenía que bajar al pozo a por agua porque no había.\r\n"
			+ "Estaba bastante oscuro y mi padre un poco asustado me dijo que bajó de todos modos. Así que bajó, y empezó a subirle cubos de agua a mi abuelo, hasta que sintió cómo una presencia detrás de él le respiraba cerca. Mi padre se giró rápidamente para ver si veía algo y oyó cómo unas voces suplicaban que se fueran de allí, que no pretendían hacerles daño, pero que ésa era su casa y habían muerto allí y no se iban a ir. Mi padre empezó a gritarle a mi abuelo que por favor le subiese mientras comenzó a ver dos personas que se aparecían mientras le suplicaban que se alejaran de allí.\r\n"
			+ "En cuanto ahorraron un poco se marcharon y la dejaron vacía como ellos pidieron. Mi padre me contó esta historia hace ya muchos años, yo al principio no creía que estas cosas pudieran ser ciertas, pero creo que mi padre no me mentiría en algo así… la verdad…\r\n"
			+ ".";
	private Timeline timeline;

	@FXML
	private Label dialogue;

	@FXML
	private Button myButton;

	@FXML
	public void initialize() {
//		backgroundMusic.playAudio(RESOURCES_PATH + "/audio/firecamp.ogg");
//		voiceBox.playAudio(RESOURCES_PATH + "/audio/jhon03.ogg");
		myButton.setOnAction(event -> {
			try {
				// Crear un nuevo Stage
				voiceBox.stopAudio();
				backgroundMusic.stopAudio();
				Stage currentStage = (Stage) myButton.getScene().getWindow();
				Stage stage = MainEp1.createStage("Stage0.fxml", "SecondStage");

//				// Mostrar el nuevo Stage
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
