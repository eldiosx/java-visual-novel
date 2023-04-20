package application.Ep1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Stage1 {

    @FXML
    private Button myButton;

    @FXML
    public void initialize() {
        myButton.setOnAction(event -> myButton.setVisible(false));
    }
}
