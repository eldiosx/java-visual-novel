package applicationOldClases;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import application.SoundBox;


public class DeadGirlSceneBuilder extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DeadGirlSceneBuilder.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setTitle("DeadGirl");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
