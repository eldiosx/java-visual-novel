package application.EP1NinaMuerta;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.stage.Stage;

public class NinaMuertaStageBuilder extends Application {
	


	    @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private Button investigarcuchillo;

	    @FXML
	    private Button investigarcuerpo;

	    @FXML
	    private Button investigarmano;

	    @FXML
	    private Button investigarsala;

	    @FXML
	    private Button investigarsangre;

	    @FXML
	    private Button investigarsuelo;

	    @FXML
	    private DialogPane textsuelo;

	    @FXML
	    void initialize() {
	        assert investigarcuchillo != null : "fx:id=\"investigarcuchillo\" was not injected: check your FXML file 'EP1NinaMuerta.fxml'.";
	        assert investigarcuerpo != null : "fx:id=\"investigarcuerpo\" was not injected: check your FXML file 'EP1NinaMuerta.fxml'.";
	        assert investigarmano != null : "fx:id=\"investigarmano\" was not injected: check your FXML file 'EP1NinaMuerta.fxml'.";
	        assert investigarsala != null : "fx:id=\"investigarsala\" was not injected: check your FXML file 'EP1NinaMuerta.fxml'.";
	        assert investigarsangre != null : "fx:id=\"investigarsangre\" was not injected: check your FXML file 'EP1NinaMuerta.fxml'.";
	        assert investigarsuelo != null : "fx:id=\"investigarsuelo\" was not injected: check your FXML file 'EP1NinaMuerta.fxml'.";
	        assert textsuelo != null : "fx:id=\"textsuelo\" was not injected: check your FXML file 'EP1NinaMuerta.fxml'.";

	    }

		@Override
		public void start(Stage primaryStage) throws Exception {
			// TODO Auto-generated method stub
			
		}

}
