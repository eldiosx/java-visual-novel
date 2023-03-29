import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.io.IOException;
import java.io.File;
import javax.sound.sampled.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
//import javax.imageio.ImageIO;

public class MainMenu extends JFrame {
    private static final long serialVersionUID = 1L;
	private Clip bgMusic;
    private ImageIcon backgroundImage;
    private JLabel titleLabel;
    private JButton startButton;
    private ImageIcon startImage;
    private JButton settingsButton;
    private ImageIcon settingsImage;
    private JButton exitButton;
    private ImageIcon exitImage;

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
            private static final long serialVersionUID = 1L;

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
        titleLabel.setBorder(new EmptyBorder(10, 0, 10, 0));
        titleLabel.setForeground(Color.gray);
        titleLabel.setFont(new Font("Sans Serif", Font.BOLD, 48));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        contentPanel.add(titleLabel, BorderLayout.NORTH);

        // Configurar los botones
        // Start
        startImage = new ImageIcon("../assets/icons/start.png");
        startButton = new JButton();
        startButton.setIcon(startImage);
        startButton.setOpaque(false); // Eliminar fondo
        startButton.setContentAreaFilled(false); // Eliminar fondo
        startButton.setBorderPainted(false); // Eliminar borde
        // Setting
        settingsImage = new ImageIcon("../assets/icons/setting.png");
        settingsButton = new JButton();
        settingsButton.setIcon(settingsImage);
        settingsButton.setOpaque(false);
        settingsButton.setContentAreaFilled(false);
        settingsButton.setBorderPainted(false);
        // Exit
        exitImage = new ImageIcon("../assets/icons/exit.png");
        exitButton = new JButton();
        exitButton.setIcon(exitImage);
        exitButton.setOpaque(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setBorderPainted(false);
        // Panel
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 0, 0));
        buttonPanel.setBorder(new EmptyBorder(200, 200, 60, 200));
        buttonPanel.setOpaque(false); // Establecer como no opaco para que se muestre el fondo de la ventana
        buttonPanel.add(startButton);
        buttonPanel.add(settingsButton);
        buttonPanel.add(exitButton);
        contentPanel.add(buttonPanel, BorderLayout.CENTER);

        // Configurar el fondo de pantalla
        backgroundImage = new ImageIcon("../assets/images/background.jpg");

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
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return new ImageIcon(resizedImage);
    }

    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        mainMenu.setVisible(true);
    }
}