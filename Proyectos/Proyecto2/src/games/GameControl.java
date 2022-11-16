package games;

import cards.*;
import players.*;
import java.net.Socket;
import java.io.IOException;
import java.util.LinkedList;
import java.net.ServerSocket;

/**
 * Class to represent a facade for the game
 * A game control has an array of players (instances of {@link Player}), a card
 * holder (instance of {@link CardHolder}), a number of port, a game (instance
 * of {@link GamePart}), a number of players and a server socket
 */
public class GameControl {

    /* The array of players */
    private Player[] players;

    /* The card holder */
    private CardHolder cardHolder;

    /* The number of port */
    private int port;

    /* The game */
    private GamePart game;

    /* The number of players */
    private int numPlayers;

    /* The server socket */
    private ServerSocket server;

    /**
     * Constructor
     * 
     * @param port       the number of port
     * @param numPlayers the number of players
     */
    public GameControl(int port, int numPlayers) {
        this.players = null;
        this.cardHolder = null;
        this.port = port;
        this.game = null;
        this.numPlayers = numPlayers;
    }

    /**
     * Recives the players and saves them in the array of players
     * 
     * @throws DCPlayerException if a communication error occurs
     */
    public void recivePlayers() throws IOException {
        server = new ServerSocket(port);
        players = new Player[numPlayers];
        int i = 0;
        while (i < numPlayers) {
            Socket socket = server.accept();
            Player player = new PlayerProxy(socket);
            players[i] = player;
            i++;
            player.showText("Bienvenido");
            player.showText("En unos momentos se iniciara el juego...");
            player.showText("Esperando a que se conecten los demas jugadores...");
        }
        for (Player player : players) {
            player.showText("Todos los jugadores se han conectado");
        }
    }

    /**
     * Creates a deck of cards for the game
     */
    public void createDeck() {
        CardFactory cardFactory = new CardFactoryDefault();
        cardHolder = new Deck(System.currentTimeMillis());
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 14; j++) {
                cardHolder.addCard(cardFactory.build(i, j));
            }
        }
        for (int i = 1; i < 5; i++) {
            cardHolder.addCard(cardFactory.build(5, 0));
            cardHolder.addCard(cardFactory.build(5, 14));
        }
    }

    /**
     * Creates the game
     */
    public void createGame() {
        if (players != null && cardHolder != null) {
            game = new GameMain(numPlayers, new LinkedList<Player>(), cardHolder);
            for (Player player : players) {
                game.registerObserver(player);
            }
        }
    }

    /**
     * Starts the game
     * 
     * @throws DCPlayerException if a communication error occurs
     */
    public void startGame() throws DCPlayerException {
        if (game != null) {
            game.start();
        }
    }

    /**
     * Finish the server service and ends the clients service
     */
    public void closeServer() {
        if (game != null && game != null) {
            for (Player player : players) {
                try {
                    player.end();
                } catch (DCPlayerException dcpe) {
                    continue;
                }
            }
        }
        if (server != null) {
            try {
                server.close();
            } catch (IOException ioe) {
                return;
            }
        }
    }

}
