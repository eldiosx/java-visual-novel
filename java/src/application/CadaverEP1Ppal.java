package application;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadaverEP1Ppal extends JFrame {
	public CadaverEP1Ppal() {
	}

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadaverEP1Ppal frame = new CadaverEP1Ppal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Creamos el objeto de CadaverEP1
	 */
	CadaverEP1 Corpsegirl= new CadaverEP1 ();
	/**
	 * Create the frame.
	 */
	public void start(Stage primaryStage) {
	        // Obtener el tamaño de la pantalla
	        double screenWidth = Screen.getPrimary().getVisualBounds().getWidth();
	        double screenHeight = Screen.getPrimary().getVisualBounds().getHeight(); 
	        
	        // Crear el contenedor principal
	        BorderPane root = new BorderPane();
	        
			// Crear la escena
		    Scene scene = new Scene(root, screenWidth, screenHeight);
		    
		    // Configurar la ventana
	        primaryStage.setScene(scene);
	        primaryStage.setTitle("Tu videojuego favorito de serie B"); // Título de la ventana
	        primaryStage.setResizable(true); // Se puede redimensionar
	        primaryStage.setFullScreen(true); // Abre la ventana en pantalla completa
	        primaryStage.setMinWidth(800); // Establece el ancho mínimo de la ventana en 800px
	        primaryStage.setMinHeight(600); // Establece la altura mínima de la ventana en 600px
	        primaryStage.show();
	
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	
			setContentPane(contentPane);
			
			JButton btnNewButton = new JButton("New button");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Corpsegirl.corpsegirl(1);
				}
			});
			contentPane.add(btnNewButton);
	}

}
