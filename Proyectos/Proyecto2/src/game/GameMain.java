package game;

import cards.*;
import player.DCPlayerException;
import player.Message;
import player.Player;

import java.io.IOException;
import java.util.List;

public class GameMain extends GamePart {
    
    private int numRounds;

    private boolean continues;
    
    private long seed;

    public GameMain(int numPlayers, List<Player> players, CardHolder mainDeck) {
        super(players, mainDeck);
        this.numRounds = numPlayers;
        this.continues = true;
        this.seed = System.currentTimeMillis();
    }
    
    @Override
    public void start() {
        try {
            sendText("La partida va a empezar, todos listos :)");
            sendText("La seed del juego es " + seed);
            for (int i = 1; i <= numRounds; i++) {
                GameRound actual = new GameRound(players, mainDeck, numRounds);
                actual.start();
                if (i != numRounds) {
                    carryOn();
                }
                if (!continues) {
                    break;
                }
            }
        } catch (DCPlayerException playerIn) {
            resultsDC();
        } catch (IOException ioe) {
            System.out.println("Error al guardar en el archivo, terminando el juego...");
            resultsDC();
        }
        try {
            end();
        } catch (IOException ioe) {
            System.out.println("No se pudo cerrar el archivo, abortando la ejecución...");
            System.exit(0);
        }
    }

    private void end() {
        results();
    }

    private void sendTextDC(String text) {
        System.out.println(text + "\n");
        for (Player player : getPlayers()) {
            try {
                sendText(player, text);
            } catch (DCPlayerException playerIn) {
                continue;
            }
        }
    }

    private void results() {
        String results = "Ahora se anunciara al ganador del juego...\n\n";
        results += winner();
        sendText(results);  
    }

    private void resultsDC() {
        String results = "Un jugador se pudo haber desconectado, terminando el juego...\n";
        results+= "Ahora se anunciara al ganador del juego...\n\n";
        results += winner();
        sendTextDC(results);
        System.exit(0);
    }

    private String winner() {
        return higher(players);
    }

    private int higher(List<Player> players) {
        String winner = "Hubo un empate entre los Jugadores ";
        int position = higher(players);
        Player winner1 = players.buscarIndice(position);
        int punt = winner1.getPuntuacion();
        List<Player> resto = players.clone();
        resto.delete2(position);
        boolean empate = false;
        for (Player jug : resto) {
            if (jug.getPuntuacion() == punt) {
                empate = true;
                winner += jug.getName() + ", ";
            }
        }
        if (empate) {
            winner = winner.substring(0, winner.length() - 2);
            winner += " y " + ganadorsito.getName();
            return winner + " todos con " + punt + " puntos\n";
        }
        return "El ganador es el Jugador " + ganadorsito.getNombre() + " con " + ganadorsito.getPuntuacion() + " puntos\n";
    }

    private void carryOn() {
        List<String> yes = new List<>();
        List<String> no = new List<>();
        for (Player player: players) {
            pedirRespuesta(player, yes, no);
        }
        if (yes.size() < no.size()) {
            sigue = false;
            return;
        } else if (yes.size() == no.size()) {
            for (Player player : players) {
                enviarMensajeJugador(player, "Hubo un empate, se realizara una nueva votacion");
            }
            seguir();
            return;
        }
    }

}
