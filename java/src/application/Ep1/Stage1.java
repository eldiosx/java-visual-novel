package application.Ep1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Stage1 {

	@FXML
	private Button myButton;

	@FXML
	public void initialize() {
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
	}
}
