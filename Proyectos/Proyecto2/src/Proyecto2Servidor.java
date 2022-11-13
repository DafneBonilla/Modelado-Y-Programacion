import java.io.IOException;
import game.GameControl;
import player.DCPlayerException;
import view.View;

/**
 * Class to make the proyect 2 work with the server.
 */
public class Proyecto2Servidor {

    public static void use() {
        System.out.println("Uso: java Proyecto2Servidor <#jugadores> <puerto>");
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
    
}
