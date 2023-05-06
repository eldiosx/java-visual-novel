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

public class Stage6One {// Chang
	private static final String RESOURCES_PATH = new File("assets").getAbsolutePath();
	private VoiceBox voiceBox = new VoiceBox();
	private BackgroundMusic backgroundMusic = new BackgroundMusic();
	private int currentIndex = 0;
	private String text = "Todo empezó una tarde de agosto, hace un par de años, yo acababa de cumplir catorce años y estaba de picnic con los amigos de mi pueblo de la sierra. Éramos cinco o así, y a eso de las ocho y media de la tarde, cuando empieza a oscurecer, a uno de mis compañeros se le ocurrió la idea de hacer una ouija.\r\n"
			+ "Yo me quería largar de allí cuanto antes y me fui con otro de los colegas un poco más lejos de dónde estaban ellos con la ouija. Al volver los dos hacia el lugar donde se produjo la supuesta invocación, el resto de mis compañeros nos advirtieron que habían contactado con un espíritu de una mujer, que les había dicho que tendríamos problemas para volver de vuelta a casa.\r\n"
			+ "Dos de mis amigos bajaron en la moto y avisaron a mi primo para que viniera a recogernos al resto. Cuando vino mi primo con su coche nos montamos y prácticamente nada más arrancar, el motor se paró. Los que íbamos con él, nos miramos, mi primo volvió a arrancar el coche… y se para de nuevo… y así hasta cuatro veces. Conseguimos arrancar y salir de allí con muy mal cuerpo, y cuando íbamos camino al pueblo notamos que ganábamos velocidad con demasiada facilidad y de repente el coche se frenó de nuevo en seco y quedó atravesado en la carretera.\r\n";
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
				Stage stage = MainEp1.createStage("Stage62.fxml", "SecondStage");

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
