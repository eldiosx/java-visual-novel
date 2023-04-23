package trash;

import javafx.application.Application;
import javafx.beans.binding.DoubleBinding;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;
//lo que faltaba
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import java.io.File;

import application.SoundBox;

public class Transition extends Application {
	private static final String RESOURCES_PATH = "assets";
	private static final String BACKGROUND_URL = "file:" + RESOURCES_PATH + "/images/horror.gif";
	private static final double LABEL_WIDTH = 200.0; // Ancho del cuadro de texto
	private static final double MARGIN_LEFT = 50.0; // Margen izquierdo
	private static final double MARGIN_BOTTOM = 50.0; // Margen inferior
	private SoundBox soundBox = new SoundBox();

	@Override
	public void start(Stage primaryStage) {

		primaryStage.setTitle("Episodio 1");
		// Configurar la ventana

		primaryStage.setResizable(true); // Se puede redimensionar
		primaryStage.setFullScreen(true); // Abre la ventana en pantalla completa
		primaryStage.setMinWidth(800); // Establece el ancho mínimo de la ventana en 800px
		primaryStage.setMinHeight(600); // Establece la altura mínima de la ventana en 600px
		primaryStage.show();

		BorderPane borderPane = new BorderPane();
		// imagen de la persona
		Image backgroundImage = new Image("file:" + RESOURCES_PATH + "/images/Prologo/Prologo/DirectorBienvenida.png");

		// caja de texto
		VBox vBox = new VBox(); // Crea un VBox para organizar los nodos verticalmente
		vBox.setAlignment(Pos.BOTTOM_LEFT); // Alinea los nodos al centro del VBox
		vBox.setSpacing(10); // Establece un espacio de 10 píxeles entre los nodos en el VBox
		// label de texto

		Label labelBienvenida = new Label(
				"Bienvenido al campamento \"The Otter\". Espero que estés preparado para dos semanas de diversión. Tus compañeros ya están ubicados en sus cabañas. La tuya es la cabaña número 7, puedes ir a acomodarte si quieres .");
		labelBienvenida.setWrapText(true);
		labelBienvenida.setFont(new Font(12));
		BackgroundFill backgroundFill = new BackgroundFill(Color.rgb(0, 0, 139, 0.5), new CornerRadii(10), null);
		labelBienvenida.setBackground(new Background(backgroundFill));
		labelBienvenida.setTextFill(Color.YELLOW);
		labelBienvenida.setStyle("-fx-padding: 20px;");
		// label de opciones
		Button buttonOpcion1 = new Button("Ir a la cabaña");
		buttonOpcion1.setWrapText(true);
		buttonOpcion1.setFont(new Font(12));
		BackgroundFill FillOpcion1 = new BackgroundFill(Color.rgb(0, 0, 139, 0.5), new CornerRadii(10), null);
		buttonOpcion1.setBackground(new Background(FillOpcion1));
		buttonOpcion1.setTextFill(Color.YELLOW);
		buttonOpcion1.setStyle("-fx-padding: 20px;");
		buttonOpcion1.setOnMouseClicked(event -> {
			soundBox.playAudio(RESOURCES_PATH + "/audio/click.ogg");
			// Agrega aquí el código que deseas ejecutar cuando se haga clic en el botón
			// "Opción1"
		});

		// Agrega la Label al VBox
		vBox.getChildren().add(labelBienvenida);
		vBox.getChildren().add(buttonOpcion1);

		// Panel principal con diseño de borde
		BorderPane borderPane1 = new BorderPane();

		// Cuadro de texto estilo mensaje
		Label label = new Label(
				"Bienvenido al campamento \"The Otter\". Espero que estés preparado para dos semanas de diversión. Tus compañeros ya están ubicados en sus cabañas. La tuya es la cabaña número 7, puedes ir a acomodarte si quieres ."); // Texto
																																																											// de
																																																											// ejemplo
		label.setWrapText(true); // Activar ajuste de texto
		label.setMaxWidth(LABEL_WIDTH); // Ancho máximo del cuadro de texto

		// Configurar el fondo del Label con un color negro con opacidad
		BackgroundFill backgroundFill1 = new BackgroundFill(Color.rgb(0, 0, 139, 0.5), new CornerRadii(10), null);
		label.setBackground(new Background(backgroundFill1));

		// Configurar el color de la fuente a amarillo
		label.setTextFill(Color.YELLOW);

		// Configurar la fuente de la letra
		label.setFont(Font.font("Arial", 16)); // Cambiar la fuente y tamaño de la letra

		// Panel de cuadro de texto en la parte inferior izquierda
		BorderPane labelsBox = new BorderPane();
		labelsBox.setPrefHeight(80); // Altura del cuadro de texto
		labelsBox.setLeft(label);
		borderPane1.setLeft(labelsBox);

		// Imagen de fondo
		Image backgroundImage1 = new Image(BACKGROUND_URL);
		ImageView backgroundImageView = new ImageView(backgroundImage1);
		borderPane1.getChildren().add(0, backgroundImageView);

		// Ajustar el margen del cuadro de texto
		borderPane1.setMargin(labelsBox, new javafx.geometry.Insets(0, 0, MARGIN_BOTTOM, MARGIN_LEFT));

		// Ajustar el ancho del cuadro de texto usando DoubleBinding
		DoubleBinding labelWidthBinding = new DoubleBinding() {
			{
				super.bind(borderPane1.widthProperty());
			}

			@Override
			protected double computeValue() {
				return borderPane1.getWidth() * 0.2; // para poner el ancho al 20%
			}
		};

		label.maxWidthProperty().bind(labelWidthBinding);

		// para crear la ventana
		Scene scene = new Scene(borderPane1);
		primaryStage.setScene(scene);

	}

	public static void main(String[] args) {
		launch(args);
	}
}
