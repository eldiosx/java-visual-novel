package application.Ep1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Stage2 {

	@FXML
	private Button myButton2;

	@FXML
	public void initialize() {
		myButton2.setOnAction(event -> {
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
