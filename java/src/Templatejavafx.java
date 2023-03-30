import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Templatejavafx extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));

        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        root.setCenter(vbox);

        Button btnNewGame = new Button("Nuevo Juego");
        Button btnLoadGame = new Button("Cargar Juego");
        Button btnOptions = new Button("Opciones");
        Button btnExit = new Button("Salir");

        vbox.getChildren().addAll(btnNewGame, btnLoadGame, btnOptions, btnExit);

        HBox hbox = new HBox(10);
        hbox.setAlignment(Pos.CENTER);
        root.setBottom(hbox);

        Button btnHelp = new Button("Ayuda");
        Button btnAbout = new Button("Acerca de");

        hbox.getChildren().addAll(btnHelp, btnAbout);

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
