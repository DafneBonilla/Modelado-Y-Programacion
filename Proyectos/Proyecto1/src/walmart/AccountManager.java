package walmart;

import java.util.Iterator;
import ask.Asker;
import clients.*;

public class AccountManager {
    
    private Iterator<ClientInterface> clients;

    private ClientBuilder builder;

    private ClientInterface account;
    
    private Asker asker;

    public AccountManager(Iterator<ClientInterface> clientes) {
        this.clients = clientes;
        this.asker = Asker.getAsker();
    }

    public ClientInterface getAccount() {
        workAccount();
        return account;
    }

    private void workAccount() {
        String ques = "Bienvenido a Walmart2 \n ¿Deseas iniciar sesion o registrarte? \n [0] Iniciar sesion \n [1] Registrarse \n [2] Salir";
        int option = asker.askOption(ques, 0, 2, "Opcion invalida");
        switch (option) {
            case 0:
                normalUse();
                break;
            case 1:
                createAccount();
                break;
            case 2:
                account = null;
                break;
        }
    }

    private void normalUse() {
        String ques = "Ingrese su usuario";
        String user = asker.askString(ques, "Usuario invalido");
        ques = "Ingrese su contrasenia";
        String pass = asker.askString(ques, "Contrasenia invalida");
        if (verifyAccount(user, pass) != null) {

        }
    }
    

    private ClientInterface verifyAccount(String user, String pas) {
        return null;
    }
    
    private void createAccount() {
        
    }
    
}
