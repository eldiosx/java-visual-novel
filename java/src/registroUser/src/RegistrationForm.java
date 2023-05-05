import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class RegistrationForm extends JDialog {
    private JTextField tfName;
    private JTextField tfUser;
    private JPasswordField pfPassword;
    private JPasswordField pfConfirmPassword;
    private JButton btnRegister;
    private JButton btnCancel;
    private JPanel registerPanel;

    public RegistrationForm(JFrame parent) {
        super(parent);
        setTitle("Crear una nueva Cuenta");
        setContentPane(registerPanel);
        setMinimumSize(new Dimension(450, 474));
        setModal(true);
        setLocationRelativeTo(parent);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Llamada a la Acción del Botón Registrar
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    registerUser();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        // Llamada a la acción del botón Cancelar
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();
            }
        });
        setVisible(true);
    }

    // Capturamos los datos del formulario
    private void registerUser() throws SQLException {
        String nombre = tfName.getText();
        String usuario = tfUser.getText();
        String password = String.valueOf(pfPassword.getPassword());
        String confirmPassword = String.valueOf(pfConfirmPassword.getPassword());

        // Comprobamos que estén todos rellenos
        if (nombre.isEmpty() || usuario.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Por favor introduzca todos los campos",
                    "prueba de nuevo",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Comprobamos que la contraseña es igual en ambos campos
        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this,
                    "Las contraseñas no coinciden ",
                    "Prueba de nuevo",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Pasar los datos recibidos
        user = addUserToDatabase(nombre, usuario, password);
        if (user != null) {
            dispose();
        } else {
            JOptionPane.showMessageDialog(this,
                    "ERROR al insertar el Usuario",
                    "Vuelve a  intentarlo",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    // Creamos user del tipo User que declaramos a continuación
    public User user;

    public User addUserToDatabase(String nombre, String usuario, String password) throws SQLException {
        User user = null;

        // Conectando a Database. Preparamos el INSERT
        final String DB_URL = "jdbc:mysql://localhost/videojuegoserieb?serverTimezoneUTC";
        final String USERNAME = "root";
        final String PASS = "";

        Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASS);
        Statement stmt = conn.createStatement();
        String sql = "INSERT INTO persona (Nombre, Usuario_Guardado, Contrasena_Guardado)" +
                " VALUES (?,?,?)";

        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, nombre);
        preparedStatement.setString(2, usuario);
        preparedStatement.setString(3, password);

        // Insertamos fila dentro de la tabla
        int addedRows = preparedStatement.executeUpdate();
        if (addedRows > 0) {
            user = new User();
            user.nombre = nombre;
            user.usuario = usuario;
            user.contrasena = password;
        }

        // Cerramos conexión
        stmt.close();
        conn.close();

        return user;

    }

}
