package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Test {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Font x1;

    @FXML
    private Color x2;

    @FXML
    private Font x3;

    @FXML
    private Color x4;

    @FXML
    void initialize() {
        assert x1 != null : "fx:id=\"x1\" was not injected: check your FXML file 'Test.fxml'.";
        assert x2 != null : "fx:id=\"x2\" was not injected: check your FXML file 'Test.fxml'.";
        assert x3 != null : "fx:id=\"x3\" was not injected: check your FXML file 'Test.fxml'.";
        assert x4 != null : "fx:id=\"x4\" was not injected: check your FXML file 'Test.fxml'.";

    }

}

