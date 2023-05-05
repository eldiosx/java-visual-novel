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

public class Stage13 {
	private static final String RESOURCES_PATH = new File("assets").getAbsolutePath();
	private VoiceBox voiceBox = new VoiceBox();
	private BackgroundMusic backgroundMusic = new BackgroundMusic();
	private int currentIndex = 0;
	private String text = "Voy a seguir: El viejo señor cerró la puerta de un golpe, cerró las ventanas y se acostó a dormir. Al día siguiente, exactamente a la misma hora sucedió lo mismo cuando ya se estaba acomodando para dormir.\r\n"
			+ "Fue por eso que al día siguiente se lo comentó, a un amigo que vivía cerca de su casa, y este le recomendó ir a una señora espiritista que vivía a las afueras del pueblo. \r\n"
			+ "Salió tempranito, cuando a lo lejos divisó el tarantín rojo donde hacía su trabajo aquella vieja bruja. Al entrar, a la señora le dió una fuerte corazonada cuando vio entrar a Demetrio, pero no le hizo caso. -Bienvenido, que desea?- Preguntó Madame lalou a Demetrio. Éste contó lo que le sucedía, y ésta comenzó a llorar. Le dijo que esa niña era su sobrina, que había muerto en un incendio a las 10:08 de la noche, ella estaba dormida, y tenía sed.\r\n"
			+ "Toda su familia murió en ese incendio, pero es el alma de mi sobrina María la que vaga, pidiendo un poco de agua. Demetrio aún con los pelos erizados, preguntó:\r\n"
			+ "– Y no hay forma alguna de hacer que se vaya?, que no me moleste mas?\r\n"
			+ "– Sí, sí hay una forma- Dijo la anciana – Cuando la niña se aparezca de nuevo por su casa, sencillamente ábrale la puerta y dele un poco de agua, es la única forma de que deje de molestarlo.\r\n"
			+ "Ese día, Demetrio padeció un escalofrío constante a lo largo de su cuerpo. El reloj, dió las 10. Faltaban 8 minutos!, Demetrio se ponía las manos en la cabeza y sudaba a litros. De repente, se escuchó el crujir de la paja seca, y…… TOC, TOC, TOC.\r\n"
			+ "Demetrio brincó, corrió a la cocina, y tomó agua fresca en un tarro que ya tenía preparado para ese momento. Abrió la puerta. Y ahí estaba, aquel cuerpo casi amorfo a causa de las llamas que la cobijaron aquella noche, a aquella misma hora. -Agua!!!, por favor agua!!, AGUA!!-Suplicó la niña.\r\n"
			+ "Ya con el tarro en la mano y sin pensarlo dos veces, Demetrio le sirvió agua, la cual la niña bebió en un segundo. -Más por favor!!- Le dijo la niña de nuevo.\r\n"
			+ "Este le sirvió de nuevo. En los ojos de la pequeña niña, Demetrio distinguió perfectamente, como si fuera una película, el momento en el que la niña se quemaba, un frío intenso heló la piel de Demetrio, y en los ojos de la infante, aún se reflejaba el momento de su tragedia. \r\n"
			+ "Ya acabado el tarro, la niña se volteó y se fue, atravesando los matorrales, atravesando el bosque como si flotara, hasta que se perdió de los ojos de aquel asustado hombre. Se volteó y se acostó, su cama se encontraba hirviendo!!!, como si fuera el infierno propio.";
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
