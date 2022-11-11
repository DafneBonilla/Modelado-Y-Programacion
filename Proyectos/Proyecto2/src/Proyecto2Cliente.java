import java.io.IOException;
import java.net.Socket;

import player.CException;
import player.DCPlayerException;
import view.View;

/**
 * Class to make the proyect 2 work with the client
 */
public class Proyecto2Cliente {

    public static void use() {
        System.out.println("Uso: java Proyecto2Cliente <host> <puerto>");
        System.exit(0);
    }

    /**
     * Main method
     * 
     * @param args the arguments
     */
    public static void main(String[] args) {

        if (args.length != 2) {
            use();
        }
        String host = args[0];
        int port = 1234;
        try {
            port = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            use();
        }
        View auxView = new View(null, null);
        String name = auxView.askString("Introduce tu nombre");
        try {
            Socket socket = new Socket(host, port);
            View view = new View(name, socket);
            view.getPlayer().read();
        } catch (DCPlayerException dcpe) {
            auxView.showText(dcpe.getMessage());
            auxView.showText("Hubo un problema de comunicacion con el servidor");
            auxView.showText("Terminando ejecucion");
            System.exit(0);
        } catch (CException ce) {
            auxView.showText(ce.getMessage());
            auxView.showText("Hubo un error al no encontrar un clase, por favor revisar que compilaste bien");
            auxView.showText("Terminando la ejecucion");
            System.out.println(0);
        } catch (IOException ioe) {
            auxView.showText(ioe.getMessage());
            auxView.showText("Hubo un problema al intentar conectarse al servidor");
            auxView.showText("Terminando ejecucion");
            System.exit(0);
        }

    }

}
