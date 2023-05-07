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

public class Stage4Four {// travis continua su historia
	private static final String RESOURCES_PATH = new File("assets").getAbsolutePath();
	private VoiceBox voiceBox = new VoiceBox();
	private BackgroundMusic backgroundMusic = new BackgroundMusic();
	private int currentIndex = 0;
	private String text = "Bueno, sigo con la historia:  Nadie oyó los gritos de la mujer mientras era asesinada. En sus manos había heridas producidas por la hoja de un cuchillo y todo aparentaba como si hubiera sido ella misma la que se lo hubiera clavado. Los forenses determinaron un suicidio y algo más: la prostituta estaba embarazada. \r\n"
			+ "Dos años después todo parecía haberse olvidado, pero la habitación donde murió la joven no volvió a ser utilizada por ninguna de las otras prostitutas. El dueño del local, mandó cerrar con llave la habitación y nadie entró allí durante varios meses. En verano de 1953, una mujer de unos 30 años llegó al prostíbulo. Como aquella noche, todo estaba lleno y claro, el dueño no tuvo más remedio que abrirle la habitación de la otra prostituta muerta dos años antes…\r\n"
			+ "…Cuando abrieron la puerta… en las paredes alguien había dibujado caras con llorando desfiguradas, también había cruces y animales como lechuzas, gatos y ratones muertos colgando del techo con cuerdas…. El dueño del local, viendo aquello, le dijo a la nueva mujer que durmiera con una compañera y a la mañana siguiente mandó limpiar y  pintar el cuarto. Sin embargo, las caras de lamento volvían a aparecer una, y otra y otra y otra vez en la pared. La voz se empezó a correr por la ciudad y un mal día Carlos tuvo que cerrar su negocio y se marchó de la ciudad.\r\n"
			+ "Desde entonces la casa permaneció en ruinas hasta que fue derribada.\r\n" + "";
	private Timeline timeline;

	@FXML
	private Label dialogue;

	@FXML
	private Button myButton;

	@FXML
	public void initialize() {
		backgroundMusic.playAudio(RESOURCES_PATH + "/audio/firecamp.ogg");
		voiceBox.playAudio(RESOURCES_PATH + "/audio/travis03.ogg");
		myButton.setOnAction(event -> {
			try {
				// Crear un nuevo Stage
				voiceBox.stopAudio();
				backgroundMusic.stopAudio();
				Stage currentStage = (Stage) myButton.getScene().getWindow();
				Stage stage = MainEp1.createStage("Stage0.fxml", "SecondStage");

				// Mostrar el nuevo Stage
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
