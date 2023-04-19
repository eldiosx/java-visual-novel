package application.EP1NinaMuerta;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.stage.Stage;

public class NinaMuertaStageBuilder extends Application {


		@Override
		public void start(Stage primaryStage) throws Exception {
		        FXMLLoader loader = new FXMLLoader(getClass().getResource("EP1NinaMuerta.fxml"));
		        Parent root = loader.load();

		        Scene scene = new Scene(root);

		        primaryStage.setScene(scene);
		        primaryStage.setTitle("Test");
		        primaryStage.show();
		    }

		    public static void main(String[] args) {
		        launch(args);
		    }
		}

