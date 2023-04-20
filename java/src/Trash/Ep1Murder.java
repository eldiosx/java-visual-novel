package Trash;

import java.util.*;
import application.SoundBox;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import application.SoundBox;


public class Ep1Murder extends Application{
	//Point And Click Niña Muerta
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Ep1NinaMuerta.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Episodio 1");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
    

}
