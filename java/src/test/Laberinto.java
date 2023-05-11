package test;

import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Laberinto extends Application {
    double screenWidth = Screen.getPrimary().getVisualBounds().getWidth();
    double screenHeight = Screen.getPrimary().getVisualBounds().getHeight();
    double responsive = screenWidth * 0.07;
    private static final String RESOURCES_PATH = new File("assets").getAbsolutePath();
    private static final String EXIT_BUTTON_URL = "file:" + RESOURCES_PATH + "/sprites/knifeBloody.png";
	private static final String BACKGROUND_URL = "file:" + RESOURCES_PATH + "/images/laberinto.png";

    double originalX, originalY;

    @Override
    public void start(Stage primaryStage) {
        Image exitButtonImage = new Image(EXIT_BUTTON_URL, responsive, responsive / 3, true, true);
        ImageView imagen = new ImageView(exitButtonImage);
        Pane pane = new Pane(imagen);

        originalX = imagen.getX();
        originalY = imagen.getY();

        imagen.setOnMousePressed((MouseEvent event) -> {
            imagen.setUserData(new double[] { event.getSceneX(), event.getSceneY() });
        });

        imagen.setOnMouseDragged((MouseEvent event) -> {
            double[] posAnterior = (double[]) imagen.getUserData();
            double deltaX = event.getSceneX() - posAnterior[0];
            double deltaY = event.getSceneY() - posAnterior[1];
            imagen.setX(imagen.getX() + deltaX);
            imagen.setY(imagen.getY() + deltaY);
            imagen.setUserData(new double[] { event.getSceneX(), event.getSceneY() });
        });

        imagen.setOnMouseReleased((MouseEvent event) -> {
            if (isBlackPixel(imagen, event.getSceneX(), event.getSceneY())) {
                imagen.setX(originalX);
                imagen.setY(originalY);
            } else {
                imagen.setX(originalX);
                imagen.setY(originalY);
            }
        });
		// Establecer el fondo
		pane.setBackground(new Background(new BackgroundImage(new Image(BACKGROUND_URL), BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
				new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, true, true))));
        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setFullScreen(true);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private boolean isBlackPixel(ImageView image, double x, double y) {
        PixelReader pixelReader = image.getImage().getPixelReader();
        if (x < 0 || y < 0 || x >= image.getImage().getWidth() || y >= image.getImage().getHeight()) {
            return false;
        }
        Color color = pixelReader.getColor((int) x, (int) y);
        return color.equals(Color.BLACK);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

