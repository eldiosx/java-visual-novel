import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class MainMenu extends JFrame {
    private JLabel titleLabel;
    private JButton settingsButton;
    private JButton startButton;
    private ImageIcon backgroundImage;
    private ImageIcon settingsImage;
    private ImageIcon startImage;

    public MainMenu() {
        // Configurar la ventana
        setTitle("Tu videojuego favorito de serie B");
        setMinimumSize(new Dimension(800, 600));
        setExtendedState(Frame.MAXIMIZED_BOTH); // Maximiza la ventana al tamaño de la pantalla
        // setSize(800, 600); // Tamaño inicial
        setResizable(true); // Permitir redimensionamiento
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Configurar el diseño del contenido
        JPanel contentPanel = new JPanel(new BorderLayout()) {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), null);
            }
        };
        contentPanel.setBackground(Color.BLACK); // Establecer el color de fondo
        setContentPane(contentPanel);
        // Titulo, me falta la sombrita o cambiar por una imagen
        titleLabel = new JLabel("Tu videojuego favorito de serie B");
        titleLabel.setForeground(Color.gray);
        titleLabel.setFont(new Font("Sans Serif", Font.BOLD, 48));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        contentPanel.add(titleLabel, BorderLayout.NORTH);

        // Configurar los botones
        settingsImage = new ImageIcon("../assets/icons/setting.png");
        settingsButton = new JButton();
        settingsButton.setIcon(settingsImage);
        settingsButton.setOpaque(false); // Eliminar fondo
        settingsButton.setContentAreaFilled(false); // Eliminar borde
        settingsButton.setBorderPainted(false);
        startImage = new ImageIcon("../assets/icons/start.png");
        startButton = new JButton();
        startButton.setIcon(startImage);
        startButton.setOpaque(false);
        startButton.setContentAreaFilled(false); // Eliminar fondo
        startButton.setBorderPainted(false); // Eliminar borde
        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 0, 0));
        buttonPanel.setBorder(new EmptyBorder(200, 200, 50, 200));
        buttonPanel.setOpaque(false); // Establecer como no opaco para que se muestre el fondo de la ventana
        buttonPanel.add(startButton);
        buttonPanel.add(settingsButton);
        contentPanel.add(buttonPanel, BorderLayout.CENTER);

        // Configurar el fondo de pantalla
        backgroundImage = new ImageIcon("../assets/images/fondo1.jpg");

        // Hacer responsive la ventana
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                Component comp = (Component) evt.getSource();
                Dimension size = comp.getSize();
                titleLabel.setFont(new Font("Sans Serif", Font.BOLD, size.width / 20));
                // Escalar las imágenes en función del tamaño de la ventana
                settingsButton.setIcon(scaleImage(settingsImage.getImage(), size.width / 3, size.width / 8)); //Sera un pelin mas ancho que el de START
                startButton.setIcon(scaleImage(startImage.getImage(), size.width / 4, size.width / 8));
            }
        });

        // Agregar un ActionListener al botón "start" para que lleve a la escena
        // "IntroScene"

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
        MainMenu mainMenu = new MainMenu();
        mainMenu.setVisible(true);
    }
}