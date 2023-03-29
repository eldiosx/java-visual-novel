import java.awt.*;
import javax.swing.*;

public class IntroScene extends JFrame {
    private static final long serialVersionUID = 1L;
	private JLabel titleLabel;
    private JLabel subtitleLabel;
    private JLabel descriptionLabel;

    public IntroScene() {
        // Configurar la ventana
        setTitle("Tu videojuego favorito de serie B");
        setMinimumSize(new Dimension(800, 600));
        setExtendedState(Frame.MAXIMIZED_BOTH); // Maximiza la ventana al tamaño de la pantalla
        // setSize(800, 600); // Tamaño inicial
        setResizable(true); // Permitir redimensionamiento
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Configurar el diseño del contenido
        JPanel contentPanel = new JPanel(new BorderLayout());
        setContentPane(contentPanel);

        // Configurar los textos
        titleLabel = new JLabel("Título de la Escena");
        titleLabel.setFont(new Font("Sans Serif", Font.BOLD, 48));
        subtitleLabel = new JLabel("Subtítulo");
        subtitleLabel.setFont(new Font("Sans Serif", Font.PLAIN, 24));
        descriptionLabel = new JLabel("<html>Descripción de la escena<br>en varias líneas.</html>");
        descriptionLabel.setFont(new Font("Sans Serif", Font.PLAIN, 18));

        // Agregar los textos al contenido
        JPanel textPanel = new JPanel(new GridLayout(3, 1));
        textPanel.add(titleLabel);
        textPanel.add(subtitleLabel);
        textPanel.add(descriptionLabel);
        contentPanel.add(textPanel, BorderLayout.CENTER);

        // Hacer responsive los textos
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        subtitleLabel.setHorizontalAlignment(JLabel.CENTER);
        descriptionLabel.setHorizontalAlignment(JLabel.CENTER);

        // Hacer responsive la ventana
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                Component comp = (Component) evt.getSource();
                Dimension size = comp.getSize();
                titleLabel.setFont(new Font("Sans Serif", Font.BOLD, size.width / 16));
                subtitleLabel.setFont(new Font("Sans Serif", Font.PLAIN, size.width / 32));
                descriptionLabel.setFont(new Font("Sans Serif", Font.PLAIN, size.width / 48));
            }
        });
    }

    public static void main(String[] args) {
        IntroScene introScene = new IntroScene();
        introScene.setVisible(true);
    }
}
