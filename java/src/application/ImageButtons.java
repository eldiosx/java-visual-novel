package application;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ImageButtons extends Application {
    
    @Override
    public void start(Stage stage) {
        // Creamos una cuadrícula para las imágenes
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        
        // Creamos las imágenes y las añadimos a la cuadrícula
        Image image1 = new Image("file:///home/deck/Documents/GitHub/novelaGraficaJava/assets/icons/start.png");
        ImageView imageView1 = new ImageView(image1);
        imageView1.setPreserveRatio(true);
        imageView1.setFitHeight(100);
        imageView1.setOnMouseClicked(e -> System.out.println("Imagen 1"));
        gridPane.add(imageView1, 0, 0);
        
        Image image2 = new Image("file:///home/deck/Documents/GitHub/novelaGraficaJava/assets/icons/start.png");
        ImageView imageView2 = new ImageView(image2);
        imageView2.setPreserveRatio(true);
        imageView2.setFitHeight(100);
        imageView2.setOnMouseClicked(e -> System.out.println("Imagen 2"));
        gridPane.add(imageView2, 1, 0);
        
        Image image3 = new Image("file:///home/deck/Documents/GitHub/novelaGraficaJava/assets/icons/start.png");
        ImageView imageView3 = new ImageView(image3);
        imageView3.setPreserveRatio(true);
        imageView3.setFitHeight(100);
        imageView3.setOnMouseClicked(e -> System.out.println("Imagen 3"));
        gridPane.add(imageView3, 0, 1);
        
        Image image4 = new Image("file:///home/deck/Documents/GitHub/novelaGraficaJava/assets/icons/start.png");
        ImageView imageView4 = new ImageView(image4);
        imageView4.setPreserveRatio(true);
        imageView4.setFitHeight(100);
        imageView4.setOnMouseClicked(e -> System.out.println("Imagen 4"));
        gridPane.add(imageView4, 1, 1);
        
        // Creamos la escena y la mostramos en el escenario
        Scene scene = new Scene(gridPane, 500, 500);
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
