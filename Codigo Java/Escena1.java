package Escena_Inicial;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

public class Escena1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Escena1 frame = new Escena1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Escena1() {
		setBackground(new Color(0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCartelInicial = new JLabel("Welcome to the OtterCamp");
		lblCartelInicial.setBounds(658, 56, 617, 63);
		lblCartelInicial.setForeground(Color.YELLOW);
		lblCartelInicial.setBackground(Color.BLUE);
		lblCartelInicial.setBackground(new Color(0,0,0,128));//opacidad del 50%
		lblCartelInicial.setOpaque(true); 
		lblCartelInicial.setFont(new Font("Comic Sans MS", Font.PLAIN, 45));
		lblCartelInicial.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblCartelInicial);
		
		JButton btnInicio = new JButton("Jugar");
		btnInicio.setBounds(1142, 697, 133, 53);
		contentPane.add(btnInicio);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 1920, 1080);
		lblFondo.setHorizontalAlignment(SwingConstants.CENTER);
		lblFondo.setIcon(new ImageIcon("C:\\Users\\darkn\\OneDrive\\Escritorio\\Imagenes Trabajo BBDD y Programacion\\fondo1.jpg"));
		contentPane.add(lblFondo);
		lblCartelInicial.setLabelFor(lblFondo);
	}
}
