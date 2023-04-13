package application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.util.*;
import java.sql.*;


public class CadaverEP1Principal {
	
	
	public void start(Stage primaryStage) {
        // Obtener el tamaño de la pantalla
        double screenWidth = Screen.getPrimary().getVisualBounds().getWidth();
        double screenHeight = Screen.getPrimary().getVisualBounds().getHeight(); 
        
        // Crear el contenedor principal
        BorderPane root = new BorderPane();
        
		// Crear la escena
	    Scene scene = new Scene(root, screenWidth, screenHeight);
	    Scanner read=new Scanner(System.in);
	    // Configurar la ventana
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tu videojuego favorito de serie B"); // Título de la ventana
        primaryStage.setResizable(true); // Se puede redimensionar
        primaryStage.setFullScreen(true); // Abre la ventana en pantalla completa
        primaryStage.setMinWidth(800); // Establece el ancho mínimo de la ventana en 800px
        primaryStage.setMinHeight(600); // Establece la altura mínima de la ventana en 600px
        primaryStage.show();
        
        //Declaramos la variable que vamos a necesitar para los intentos
        int intentos=0;
        //Declaramos un teclado y una variable para almacenar la opción seleccionada por el jugador
        int opcion=0;
        
        //implementamos el bucle de las opciones que se pueden investigar
        while (intentos <=4) {
        	
        	opcion= read.nextInt();
			//Boton de: Inspeccionar Cuerpo
			JButton cuerpo = new JButton("New button");
			cuerpo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CadaverEP1.corpsegirl(1);
				}
			});
			//Boton de: Inspeccionar Sangre
			JButton sangre = new JButton("New button");
			sangre.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CadaverEP1.corpsegirl(2);
				}
			});
			//Boton de: Inspeccionar Suelo
			JButton suelo = new JButton("New button");
			suelo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CadaverEP1.corpsegirl(3);
				}
			});
			//Boton de: Inspeccionar Sala
			JButton sala = new JButton("New button");
			sala.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CadaverEP1.corpsegirl(4);
				}
			});
			//Boton de: Inspeccionar Cuchillo
			JButton cuchillo = new JButton("New button");
			cuchillo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CadaverEP1.corpsegirl(5);
				}
			});
			//Boton de: Inspeccionar Mano
			JButton mano = new JButton("New button");
			mano.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CadaverEP1.corpsegirl(6);
				}
			});
			
			//Una vez terminada la acción correspondiente aumentamos el numero de intentos
			intentos=intentos + 1;
        }//Fin del while
	}
}
