import players.DCPlayerException;
import views.View;
import java.io.IOException;
import games.GameControl;

/**
 * Class to make the proyect 2 work with the server.
 */
public class Proyecto2Servidor {

    public static void use() {
        System.out.println("Uso: java Proyecto2Servidor <#jugadores> <puerto>\nEl numero de jugadores debe ser entre 3 y 6");
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
        int numPlayers = 0;
        int port = 1234;
        try {
            numPlayers = Integer.parseInt(args[0]);
            port = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            use();
        }
        if (numPlayers > 2 || numPlayers < 7) {
            use();
        }
        View auxView = new View(null, null);
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
    // 20 15 12 10 
    // 10 12 15 20
}
