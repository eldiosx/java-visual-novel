import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Dimension2D;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
//import javax.imageio.ImageIO;

public class MainMenu extends Application {
    private Clip bgMusic;
    private Image backgroundImage;
    private Button startButton;
    private Image startImage;
    private Button settingsButton;
    private Image settingsImage;
    private Button exitButton;
    private Image exitImage;

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        root.setPrefSize(800, 600);
        primaryStage.setResizable(true);
        primaryStage.setTitle("Tu videojuego favorito de serie B");
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Platform.exit();
                System.exit(0);
            }
        });

        // Configurar el contenido
        StackPane contentPane = new StackPane();
        contentPane.setStyle("-fx-background-color: black;");
        root.setCenter(contentPane);

        // Titulo
        Text titleLabel = new Text("Tu videojuego favorito de serie B");
        titleLabel.setFont(Font.font("Sans Serif", FontWeight.BOLD, 48));
        titleLabel.setStyle("-fx-text-fill: gray;");
        contentPane.getChildren().add(titleLabel);

        // Botones
        // Start
        startImage = new Image(new File("../assets/icons/start.png").toURI().toString());
        startButton = new Button();
        startButton.setGraphic(new ImageView(startImage));
        startButton.setPadding(new Insets(0));
        // Settings
        settingsImage = new Image(new File("../assets/icons/setting.png").toURI().toString());
        settingsButton = new Button();
        settingsButton.setGraphic(new ImageView(settingsImage));
        settingsButton.setPadding(new Insets(0));
        // Exit
        exitImage = new Image(new File("../assets/icons/exit.png").toURI().toString());
        exitButton = new Button();
        exitButton.setGraphic(new ImageView(exitImage));
        exitButton.setPadding(new Insets(0));

        GridPane buttonGrid = new GridPane();
        buttonGrid.setVgap(40);
        buttonGrid.setAlignment(Pos.CENTER);
        buttonGrid.add(startButton, 0, 0);
        buttonGrid.add(settingsButton, 0, 1);
        buttonGrid.add(exitButton, 0, 2);
        contentPane.getChildren().add(buttonGrid);

        // Configurar la imagen de fondo
        backgroundImage = new Image(new File("../assets/images/background.jpg").toURI().toString());
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.fitWidthProperty().bind(primaryStage.widthProperty());
        backgroundImageView.fitHeightProperty().bind(primaryStage.heightProperty());
        contentPane.getChildren().add(backgroundImageView);
        
        // SONIDO (En un futuro creare una clase aparte con todos los sonidos aparte)
        // Cargar la música de fondo (Cambiar el soporte para .ogg)
        try {
            bgMusic = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem
                    .getAudioInputStream(new File("../assets/audio/GiratinaRemix.wav"));
            bgMusic.open(inputStream);
            bgMusic.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }

        // Hacer responsive la ventana
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                Component comp = (Component) evt.getSource();
                Dimension size = comp.getSize();
                titleLabel.setFont(new Font("Sans Serif", Font.BOLD, size.width / 20));
                // Escalar las imágenes en función del tamaño de la ventana dividiendo
                startButton.setIcon(scaleImage(startImage.getImage(), size.width / 6, size.width / 12));
                settingsButton.setIcon(scaleImage(settingsImage.getImage(), size.width / 4, size.width / 10));
                exitButton.setIcon(scaleImage(exitImage.getImage(), size.width / 6, size.width / 12));
            }
        });

        // Comenzar el juego (Boton Start)

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cargar la escena IntroScene
                IntroScene introScene = new IntroScene();
                introScene.setVisible(true);
            	// Cerrar la ventana actual
                dispose();
            }
        });

        // Abrir los settings
        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abrir la ventana de ajustes
                SettingsWindow settingsWindow = new SettingsWindow();
                settingsWindow.setVisible(true);
                dispose();
            }
        });
        // Salir
        exitButton.addActionListener(e -> {
            dispose();
            System.exit(0);
        });
    }

    // Método para escalar la imagen (scaleImage)
    private ImageIcon scaleImage(Image image, int width, int height) {
        BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resizedImage.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return new ImageIcon(resizedImage);
    }

    public static void main(String[] args) {
        // Iniciar la ventana principal
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainMenu mainMenu = new MainMenu();
                mainMenu.setVisible(true);
            }
        });
    }
}
        