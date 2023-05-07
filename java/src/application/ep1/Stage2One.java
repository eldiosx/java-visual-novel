package application.ep1;

import application.end.Credits;
import application.ep2.Ep2;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Stage2One {

	// Instanciamos la pantalla de creditos
	Credits credits = new Credits(); // Crea una instancia de la clase Credits
	Ep2 ep2 = new Ep2(); // Crea una instancia de la clase Ep2
	Stage stage = new Stage();

	@FXML // fx:id="cuerpo"
	private Button body; // Value injected by FXMLLoader

	@FXML // fx:id="mano"
	private Button hand; // Value injected by FXMLLoader

	@FXML
	private Button continueEnd; // Value injected by FXMLLoader

	@FXML
	private Button knife; // Value injected by FXMLLoader

	@FXML
	private Label knifeText; // Value injected by FXMLLoader

	@FXML // fx:id="sala"
	private Button room; // Value injected by FXMLLoader

	@FXML // fx:id="sangre"
	private Button blood; // Value injected by FXMLLoader

	@FXML // fx:id="suelo"
	private Button floor; // Value injected by FXMLLoader
	@FXML // fx:id="textocuerpo"
	private Label textocuerpo; // Value injected by FXMLLoader

	@FXML // fx:id="textomano"
	private Label textomano; // Value injected by FXMLLoader

	@FXML // fx:id="textosala"
	private Label textosala; // Value injected by FXMLLoader

	@FXML // fx:id="textosangre"
	private Label textosangre; // Value injected by FXMLLoader

	@FXML // fx:id="textosuelo"
	private Label textosuelo; // Value injected by FXMLLoader

	int count = 0;
	boolean isRunning = true;

	@FXML
	public void initialize() {
		// Evento boton continuar
		continueEnd.setOnAction(event -> {
			// Asi podemos crear escenas que nos de la gana, util sobre todo para el LOAD
			try {
				// Ocultar el Stage principal (EP1)
				MainEp1.hideStage(MainEp1.getCurrentStage());
				// Inicia los Créditos
				credits.start(stage);

			} catch (Exception e) {
				e.printStackTrace();
			}

		});

		// Evento boton de suelo
		floor.setOnAction(event -> {
			try {
				textosuelo.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
			count++; // incrementamos el contador
			if (count >= 3) { // si ya se pulsaron 4 botones
				disableRemainingButtons(); // desactivamos los botones restantes
			}
		});

		// Evento boton de sala
		room.setOnAction(event -> {
			try {
				textosala.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
			count++; // incrementamos el contador
			if (count >= 4) { // si ya se pulsaron 4 botones
				disableRemainingButtons(); // desactivamos los botones restantes
			}
		});

		// Evento boton de mano
		hand.setOnAction(event -> {
			try {
				textomano.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
			count++; // incrementamos el contador
			if (count >= 3) { // si ya se pulsaron 4 botones
				disableRemainingButtons(); // desactivamos los botones restantes
			}
		});

		// Evento boton de cuchillo
		knife.setOnAction(event -> {
			try {
				knifeText.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
			count++; // incrementamos el contador
			if (count >= 3) { // si ya se pulsaron 4 botones
				disableRemainingButtons(); // desactivamos los botones restantes
			}
		});

		// Evento boton de sangre
		blood.setOnAction(event -> {
			try {
				textosangre.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
			count++; // incrementamos el contador
			if (count >= 3) { // si ya se pulsaron 4 botones
				disableRemainingButtons(); // desactivamos los botones restantes
			}
		});

		// Evento boton de cadaver
		body.setOnAction(event -> {
			try {
				textocuerpo.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
			count++; // incrementamos el contador
			if (count >= 3) { // si ya se pulsaron 4 botones
				disableRemainingButtons(); // desactivamos los botones restantes
			}
		});

	}

	private void disableRemainingButtons() {
		for (Node node : body.getParent().getChildrenUnmodifiable()) {
			if (node instanceof Button && !node.isDisabled()) { // si es un botón habilitado
				((Button) node).setDisable(true); // lo desactivamos
			}
		}
	}
}
