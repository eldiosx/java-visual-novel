public class Main {
    public static void main(String[] args) {
        RegistrationForm myForm = new RegistrationForm(null);
        User user = myForm.user;
        if (user != null) {
            System.out.println("Usuario añadido correctamente" + user.nombre);
        }
        else {
            System.out.println("Operación cancelada");
        }
    }
    }
