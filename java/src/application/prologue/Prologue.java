package application.Prologue;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

<<<<<<< Updated upstream:java/src/application/prologue/Prologue.java
public class Prologue extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Prologue_Scene_Builder1.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Test");
=======
public class EP1NinaMuerta extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("EP1NinaMuerta.fxml"));
        primaryStage.setTitle("Episodio 1");
        primaryStage.setScene(new Scene(root, 1920, 1080));
>>>>>>> Stashed changes:java/src/application/Ep1/EP1NinaMuerta.java
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
