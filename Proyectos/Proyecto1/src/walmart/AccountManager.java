package walmart;

import java.io.Serializable;
import java.util.List;
import clients.*;
import utility.*;

/**
 * Class to represent an account manager
 * An account manager has a list of clients (instances of
 * {@link ClientInterface}), a client builder (instance of
 * {@link ClientBuilder}), an account (instance of {@link ClientInterface}) and
 * an asker (instance of {@link Asker})
 */
public class AccountManager {

    /* The list of clients */
    private List<ClientInterface> clients;

    /* The client builder */
    private ClientBuilder builder;

    /* The account */
    private ClientInterface account;

    /* The asker */
    private Asker asker;

    /**
     * Constructor
     * 
     * @param clients the list of clients
     */
    public AccountManager(List<ClientInterface> clients) {
        this.clients = clients;
        this.asker = Asker.getAsker();
    }

    /**
     * Method to get the account that the account manager obtained
     * 
     * @return the account that the account manager obtained
     */
    public ClientInterface getAccount() {
        workAccount();
        return account;
    }

    /**
     * Method to obtain an account from the user
     */
    private void workAccount() {
        System.out.println("Bienvenido a Walmart2");
        boolean working = true;
        while (working) {
            String ques = "¿Deseas iniciar sesion o registrarte? \n [0] Iniciar sesion \n [1] Registrarse \n [2] Salir";
            int option = asker.askOption(ques, 0, 2, "Opcion invalida");
            switch (option) {
                case 0:
                    normalUse();
                    if (account != null) {
                        working = false;
                    }
                    break;
                case 1:
                    createAccount();
                    if (account != null) {
                        working = false;
                    }
                    break;
                case 2:
                    account = null;
                    working = false;
                    break;
            }
        }
    }

    /**
     * Method to ask for the username and password of the user in order to log in
     * And then set the account using a proxy of the account requested
     */
    private void normalUse() {
        String ques = "Ingrese su usuario";
        String user = asker.askString(ques, "Usuario invalido");
        ques = "Ingrese su contrasenia";
        String pass = asker.askString(ques, "Contrasenia invalida");
        ClientInterface clie = verifyAccount(user, pass);
        if (clie != null) {
            account = new ClientProxy((Client) clie);
        } else {
            System.out.println("Usuario y/o contrasenia incorrectos");
        }
    }

    /**
     * Method to verify if the username and password are correct using the list of
     * clients
     * 
     * @param user the username of the account
     * @param pass the password of the account
     * @return the account if it is correct, null otherwise
     */
    private ClientInterface verifyAccount(String user, String pas) {
        ClientInterface clie = null;
        for (ClientInterface client : clients) {
            if (client.getUsername().equals(user) && client.getPassword().equals(pas)) {
                clie = client;
            }
        }
        return clie;
    }

    /**
     * Method to create a new account based on the users input
     * And then set the account using the new account
     */
    private void createAccount() {
        builder = new ClientBuilderDefault();
        String ques;
        String data;
        ques = "Ingrese su nombre de usuario:";
        boolean valid = false;
        while (!valid) {
            data = asker.askString(ques, "Nombre invalido");
            valid = verifyUsername(data);
            if (!valid) {
                System.out.println("Nombre de usuario ya existente");
            } else {
                builder.username(data);
            }
        }
        ques = "Ingrese su contrasenia:";
        data = asker.askString(ques, "Contrasenia invalida");
        builder.password(data);
        ques = "Ingrese su nacionalidad\n 0 Mexico \n 1 Estados Unidos \n 2 España";
        Country con = asker.askCountry(ques, "Nacionalidad invalida");
        builder.nationality(con);
        ques = "Ingrese su nombre completo:";
        data = asker.askString(ques, "Nombre invalido");
        builder.name(data);
        ques = "Ingrese su telefono:";
        Long data2 = asker.askLong(ques, 0L, Long.MAX_VALUE, "Telefono invalido");
        builder.phone(data2);
        ques = "Ingrese su direccion:";
        data = asker.askString(ques, "Direccion invalida");
        builder.address(data);
        ques = "Ingrese su numero de cuenta bancaria:";
        data2 = asker.askLong(ques, 0L, Long.MAX_VALUE, "Numero de cuenta invalido");
        builder.bankNumber(data2);
        ques = "Ingrese la cantidad de dinero para su cuenta:";
        data2 = asker.askLong(ques, 0L, Long.MAX_VALUE, "Cantidad invalida");
        builder.money(data2);
        account = builder.build();
        if (account != null) {
            System.out.println("Cuenta creada exitosamente");
        } else {
            System.out.println("Error al crear la cuenta");
        }
    }

    /**
     * Method to verify if the username is already taken
     * 
     * @param user the username to verify
     * @return true if the username is not taken, false otherwise
     */
    private boolean verifyUsername(String user) {
        boolean valid = true;
        for (ClientInterface client : clients) {
            if (client.getUsername().equals(user)) {
                valid = false;
            }
        }
        return valid;
    }

}
