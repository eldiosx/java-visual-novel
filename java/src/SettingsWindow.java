import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.*;

public class SettingsWindow extends JFrame {
    private JLabel titleLabel;
    private JLabel subtitleLabel;
    private JLabel descriptionLabel;
    private JButton menuButton;
    private ImageIcon menuImage;

    public SettingsWindow() {
        // Configurar la ventana
        setTitle("Tu videojuego favorito de serie B");
        setMinimumSize(new Dimension(800, 600));
        setExtendedState(Frame.MAXIMIZED_BOTH); // Maximiza la ventana al tamaño de la pantalla
        // setSize(800, 600); // Tamaño inicial
        setResizable(true); // Permitir redimensionamiento
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Configurar el diseño del contenido
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(Color.GRAY); // Establecer el color de fondo
        setContentPane(contentPanel);

        // config textos
        titleLabel = new JLabel("Titulo");
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
        contentPanel.add(textPanel, BorderLayout.NORTH);

        // Hacer responsive los textos
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        subtitleLabel.setHorizontalAlignment(JLabel.CENTER);
        descriptionLabel.setHorizontalAlignment(JLabel.CENTER);

        // Configurar los botones
        menuImage = new ImageIcon("../assets/icons/back.png");
        menuButton = new JButton();
        menuButton.setIcon(menuImage);
        menuButton.setOpaque(false); // Eliminar fondo
        menuButton.setContentAreaFilled(false); // Eliminar borde
        menuButton.setBorderPainted(false);
        JPanel buttonPanel = new JPanel(new GridLayout(1, 1, 0, 0));
        buttonPanel.setBorder(new EmptyBorder(100, 200, 60, 200));
        buttonPanel.setOpaque(false); // Establecer como no opaco para que se muestre el fondo de la ventana
        buttonPanel.add(menuButton);
        contentPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Abrir los settings
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abrir la ventana de ajustes
                MainMenu mainMenu = new MainMenu();
                mainMenu.setVisible(true);
                dispose();
            }
        });
        // Hacer responsive la ventana
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                Component comp = (Component) evt.getSource();
                Dimension size = comp.getSize();
                titleLabel.setFont(new Font("Sans Serif", Font.BOLD, size.width / 16));
                subtitleLabel.setFont(new Font("Sans Serif", Font.PLAIN, size.width / 32));
                descriptionLabel.setFont(new Font("Sans Serif", Font.PLAIN, size.width / 48));
                titleLabel.setFont(new Font("Sans Serif", Font.BOLD, size.width / 20));
                // Escalar las imágenes en función del tamaño de la ventana dividiendo
                menuButton.setIcon(scaleImage(menuImage.getImage(), size.width / 3, size.width / 8));
            }
        });
    }
    // Método para escalar la imagen
    private ImageIcon scaleImage(Image image, int width, int height) {
        BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return new ImageIcon(resizedImage);
    }
    public static void main(String[] args) {
        SettingsWindow SettingsWindow = new SettingsWindow();
        SettingsWindow.setVisible(true);
    }
}
