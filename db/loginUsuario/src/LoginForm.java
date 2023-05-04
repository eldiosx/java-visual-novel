import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginForm extends JDialog {
    private JTextField tfUsuario;
    private JPasswordField pfPassword;
    private JButton btAceptar;
    private JButton btCancelar;
    private JPanel loginPanel;

      public LoginForm(JFrame parent) {
        super(parent);
        setTitle("Login");
        setContentPane(loginPanel);
        setMinimumSize(new Dimension(450,474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        // Botones

        btAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = tfUsuario.getText();
                String password = String.valueOf(pfPassword.getPassword());

                user = getAuthenticatedUser(usuario, password);

                if (user != null) {
                    dispose();
                    // System.out.println(user.nombre);
                }
                else {
                    JOptionPane.showMessageDialog(LoginForm.this,
                            "Usuario o Contraseña incorrecto",
                            "Prueba de nuevo",
                            JOptionPane.ERROR_MESSAGE);

                }

            }
        });

        setVisible(true);
    }

    public User user;
    private User getAuthenticatedUser(String usuario, String password){
        User user = null;


        // Conectando a Database. Preparamos el INSERT
        final String DB_URL = "jdbc:mysql://localhost/videojuegoserieb?serverTimezoneUTC";
        final String USERNAME = "root";
        final String PASS = "";


        try {
            // Abrimos conexión
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASS);
            Statement stmt = conn.createStatement();
            System.out.printf("Conexión establecida \n");

            // Preparamos la consulta
            String sql = "SELECT * FROM usuarios WHERE Usuario=? AND Contrasena=?";

            // Pasamos los datos a la consulta
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,usuario);
            preparedStatement.setString(2, password);
            System.out.printf("Consulta creada \n");

            // Ejecutamos la consulta
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                user = new User();
                user.nombre = resultSet.getString("Usuario");
                user.contrasena = resultSet.getString("Contrasena");

                System.out.printf("Consulta realizada con éxito \n");
            }
            else {
                System.out.println("ERROR");
            }

            stmt.close();
            System.out.println("Consulta cerrada con éxito \n");
            conn.close();
            System.out.printf("Conexión cerrada con éxito \n");

        }catch (Exception e){
            e.printStackTrace();
        }

        return user;

    }

}
