public class main {
    public static void main(String[] args) {
        LoginForm loginForm = new LoginForm(null);
        User user = loginForm.user;

        // System.out.println(user.nombre);

        if (user != null) {
            System.out.println("Autenticado correctamente con el usuario: " + user.nombre);

        } else {
            System.out.println("Autenticación fallida");
        }

    }
}
