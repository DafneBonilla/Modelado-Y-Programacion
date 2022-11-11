package game;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import cards.*;
import player.*;

public class GameControl {

    private List<Player> players;

    private CardHolder cardHolder;

    private int port;

    private GamePart game;

    private int numPlayers;

    private ServerSocket server;

    public GameControl(int port, int numPlayers) {
        this.players = null;
        this.cardHolder = null;
        this.port = port;
        this.game = null;
        this.numPlayers = numPlayers;
    }

    public void recivePlayers() throws IOException {
        server = new ServerSocket(port);
        players = new LinkedList<>();
        while (players.size() < numPlayers) {
            Socket socket = server.accept();
            Player player = new PlayerProxy(socket);
            players.add(player);
            player.showText("Bienvenido");
            player.showText("En unos momentos se iniciará el juego...");
            player.showText("Esperando a que se conecten los demás jugadores...");
        }
        for (Player player : players) {
            player.showText("Todos los jugadores se han conectado");
        }
    }

    public void createDeck() {
        CardFactory cardFactory = new CardFactoryDefault();
        cardHolder = new Deck(System.currentTimeMillis());
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 14; j++) {
                cardHolder.addCard(cardFactory.build(i, j));
            }
        }
        for (int i = 0; i < 4; i++) {
            cardHolder.addCard(cardFactory.build(5, 0));
            cardHolder.addCard(cardFactory.build(5, 14));
        }
    }

    public void createGame() {
        if (players != null && cardHolder != null) {
            game = new GameMain(numPlayers, players, cardHolder);
        }
    }

    public void startGame() {
        if (game == null) {
            game.start();
        }
    }

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
