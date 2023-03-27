import java.awt.*;
import javax.swing.*;

public class SettingsWindow extends JFrame {
    private JLabel titleLabel;
    private JLabel subtitleLabel;
    private JLabel descriptionLabel;

    public SettingsWindow() {
        // Configurar la ventana
        setTitle("Título de la Novela Gráfica");
        setSize(800, 600); // Tamaño inicial
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
                titleLabel.setFont(new Font("Sans Serif", Font.BOLD, size.width/16));
                subtitleLabel.setFont(new Font("Sans Serif", Font.PLAIN, size.width/32));
                descriptionLabel.setFont(new Font("Sans Serif", Font.PLAIN, size.width/48));
            }
        });
    }

    public static void main(String[] args) {
        SettingsWindow settingsWindow = new SettingsWindow();
        settingsWindow.setVisible(true);
    }
}
