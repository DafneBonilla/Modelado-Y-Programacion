import views.View;
import views.ViewDefault;
import games.GameControl;
import java.io.IOException;
import players.DCPlayerException;

/**
 * Class to make the proyect 2 work with the server
 */
public class Proyecto2Servidor {

    /**
     * Shows how to use the program and exits
     */
    public static void use() {
        try {
            View auxView = new ViewDefault(null, null);
            auxView.showText(
                    "Uso: java Proyecto2Servidor <#jugadores> <puerto>\nEl numero de jugadores debe ser entre 3 y 6\nEl puerto debe ser un numero entre 1024 y 65535");
            System.exit(0);
        } catch (IOException e) {
            System.out.println("Error al crear la vista");
            System.exit(0);
        }
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
        int numPlayers = 0;
        int port = 1234;
        try {
            numPlayers = Integer.parseInt(args[0]);
            port = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            use();
        }
        if (numPlayers < 2 || numPlayers > 7) {
            use();
        }
        if (port < 1024 || port > 65535) {
            use();
        }
        View auxView;
        try {
            auxView = new ViewDefault(null, null);
        } catch (IOException ioe) {
            System.out.println("Error al crear la vista");
            return;
        }
        GameControl gameControl = new GameControl(port, numPlayers);
        try {
            gameControl.recivePlayers();
            gameControl.createDeck();
            gameControl.createGame();
            gameControl.startGame();
            gameControl.closeServer();
        } catch (DCPlayerException dcpe) {
            auxView.showText("Error de conexion entre los clientes y el servidor");
        } catch (IOException e) {
            auxView.showText("Error al crear el servidor/recibir jugadores");
            auxView.showText("Terminando la ejecucion");
            System.exit(0);
        }
    }
}
