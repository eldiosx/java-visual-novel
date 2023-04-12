package application;

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

public class Transition extends Application {
	private static final String RESOURCES_PATH = "assets";
	private static final String BACKGROUND_URL = "file:" + RESOURCES_PATH + "/images/horror.gif";
	private static final double LABEL_WIDTH = 200.0; // Ancho del cuadro de texto
	private static final double MARGIN_LEFT = 50.0; // Margen izquierdo
	private static final double MARGIN_BOTTOM = 50.0; // Margen inferior

	@Override
	public void start(Stage primaryStage) {
		// Configuración de la ventana principal
		primaryStage.setTitle("Mi Aplicación"); // Título de la ventana

		// Panel principal con diseño de borde
		BorderPane borderPane = new BorderPane();

		// Cuadro de texto estilo mensaje
		Label label = new Label(
				"Bienvenido al campamento \"The Otter\". Espero que estés preparado para dos semanas de diversión. Tus compañeros ya están ubicados en sus cabañas. La tuya es la cabaña número 7, puedes ir a acomodarte si quieres ."); // Texto
																																																											// de
																																																											// ejemplo
		label.setWrapText(true); // Activar ajuste de texto
		label.setMaxWidth(LABEL_WIDTH); // Ancho máximo del cuadro de texto

		// Configurar el fondo del Label con un color negro con opacidad
		BackgroundFill backgroundFill = new BackgroundFill(Color.rgb(0, 0, 139, 0.5), new CornerRadii(10), null);
		label.setBackground(new Background(backgroundFill));

		// Configurar el color de la fuente a amarillo
		label.setTextFill(Color.YELLOW);

		// Configurar la fuente de la letra
		label.setFont(Font.font("Arial", 16)); // Cambiar la fuente y tamaño de la letra

		// Panel de cuadro de texto en la parte inferior izquierda
		BorderPane labelsBox = new BorderPane();
		labelsBox.setPrefHeight(80); // Altura del cuadro de texto
		labelsBox.setLeft(label);
		borderPane.setLeft(labelsBox);

		// Imagen de fondo
		Image backgroundImage = new Image(BACKGROUND_URL);
		ImageView backgroundImageView = new ImageView(backgroundImage);
		borderPane.getChildren().add(0, backgroundImageView);

		// Ajustar el margen del cuadro de texto
		borderPane.setMargin(labelsBox, new javafx.geometry.Insets(0, 0, MARGIN_BOTTOM, MARGIN_LEFT));

		// Ajustar el ancho del cuadro de texto usando DoubleBinding
		DoubleBinding labelWidthBinding = new DoubleBinding() {
			{
				super.bind(borderPane.widthProperty());
			}

			@Override
			protected double computeValue() {
				return borderPane.getWidth() * 0.2; // para poner el ancho al 20%
			}
		};

		label.maxWidthProperty().bind(labelWidthBinding);

		// para crear la ventana
		Scene scene = new Scene(borderPane);
		primaryStage.setScene(scene);

	}

	public static void main(String[] args) {
		launch(args);
	}
}
