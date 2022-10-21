package walmart;

import java.util.List;
import clients.*;
import utility.*;

public class AccountManager {

    private List<ClientInterface> clients;

    private ClientBuilder builder;

    private ClientInterface account;

    private Asker asker;

    public AccountManager(List<ClientInterface> clientes) {
        this.clients = clientes;
        this.asker = Asker.getAsker();
    }

    public ClientInterface getAccount() {
        workAccount();
        return account;
    }

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

    private ClientInterface verifyAccount(String user, String pas) {
        ClientInterface clie = null;
        for (ClientInterface client : clients) {
            if (client.getUsername().equals(user) && client.getPassword().equals(pas)) {
                clie = client;
            }
        }
        return clie;
    }

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
        ques = "Ingrese su nacionalidad:";
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
        account = builder.build();
        if (account != null) {
            System.out.println("Cuenta creada exitosamente");
        } else {
            System.out.println("Error al crear la cuenta");
        }
    }

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
