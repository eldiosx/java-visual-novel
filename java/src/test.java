import javax.swing.*;
import java.awt.*;

public class test extends JPanel {

    private Image background;

    public test() {
        background = new ImageIcon("fondo.jpg").getImage(); // Cambia "fondo.jpg" por el nombre de tu imagen de fondo
        setBackground(Color.BLACK); // Establece el color de fondo en negro
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 24));
        g.drawString("La noche era oscura y silenciosa.", 50, 150);
        g.drawString("Solo el sonido de las ramas moviéndose con el viento se podía escuchar.", 50, 190);
        g.drawString("El bosque estaba envuelto en una bruma espesa y misteriosa.", 50, 230);
        g.drawString("Pero algo estaba ahí, algo que no debía estar...", 50, 270);
    }

    public static void main(String[] args) {
        JFrame windows = new JFrame("Introducción");
        windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windows.setExtendedState(Frame.MAXIMIZED_BOTH); // Maximiza la ventana al tamaño de la pantalla
        windows.setResizable(true);
        windows.setMinimumSize(new Dimension(800, 600));
        windows.getContentPane().add(new test());
        windows.setLocationRelativeTo(null);
        windows.setVisible(true);
    }
}