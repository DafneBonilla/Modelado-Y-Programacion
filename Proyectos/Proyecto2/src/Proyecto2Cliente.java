import views.View;
import java.net.Socket;
import java.io.IOException;
import players.DCPlayerException;

/**
 * Class to make the proyect 2 work with the client.
 */
public class Proyecto2Cliente {

    public static void use() {
        System.out.println("Uso: java Proyecto2Cliente <host> <puerto>");
        System.exit(0);
    }

    /**
     * Main method.
     * 
     * @param args the arguments.
     */
    public static void main(String[] args) {

        if (args.length != 2) {
            use();
        }
        String host = args[0];
        int port = 1234;
        try {
            port = Integer.parseInt(args[1]);
        } catch (NumberFormatException nfe) {
            use();
        }
        View auxView;
        try {
            auxView = new View(null, null);
        } catch (IOException ioe) {
            System.out.println("Error al crear la vista");
            return;
        }
        String name = auxView.askString("Introduce tu nombre");
        View view = null;
        try {
            Socket socket = new Socket(host, port);
            view = new View(name, socket);
            view.getPlayer().read();
        } catch (DCPlayerException dcpe) {
            auxView.showText(dcpe.getMessage());
            auxView.showText("Hubo un problema de comunicacion con el servidor");
            auxView.showText("Terminando ejecucion");
            try {
                view.getPlayer().end();
            } catch (DCPlayerException dcpe2) {
            }
            System.exit(0);
        } catch (IOException ioe) {
            auxView.showText(ioe.getMessage());
            auxView.showText("Hubo un problema al intentar conectarse al servidor");
            auxView.showText("Terminando ejecucion");
            System.exit(0);
        }
    }

}
