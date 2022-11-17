package games;

import cards.*;
import players.*;
import java.util.List;
import java.util.LinkedList;

/**
 * Class to represent the main game
 * The main game has number of rounds, a boolean to know if the game is over and
 * seed
 */
public class GameMain extends GamePart {

    /* The number of rounds */
    private int numRounds;

    /* The boolean to know if the game is over */
    private boolean continues;

    /* The seed of the game */
    private long seed;

    /**
     * Constructor
     * 
     * @param numPlayers the number of players
     * @param players    the list of players
     * @param mainDeck   the deck of the game part
     */
    public GameMain(int numPlayers, List<Player> players, CardHolder mainDeck) {
        super(players, mainDeck);
        this.numRounds = getNumRounds(numPlayers);
        this.continues = true;
        this.seed = System.currentTimeMillis();
    }

    /**
     * Returns the number of rounds of the game depending on the number of players
     * 
     * @param numPlayers the number of players
     * @return the number of rounds of the game
     */
    private int getNumRounds(int numPlayers) {
        switch (numPlayers) {
            case 3:
                return 20;
            case 4:
                return 15;
            case 5:
                return 12;
            case 6:
                return 10;
            default:
                return 10;
        }
    }

    /**
     * Starts the game part
     * 
     * @throws DCPlayerException if a communication error occurs
     */
    @Override
    public void start() throws DCPlayerException {
        try {
            for (Player player : getPlayers()) {
                player.startUpdate();
            }
            sendText("La partida va a empezar, todos listos :)");
            sendText("La seed del juego es " + seed);
            for (int i = 1; i <= numRounds; i++) {
                GameRound actual = new GameRound(this.getPlayers(), this.getDeck(), i);
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
            return;
        }
        results();
    }

    /**
     * Updates the observer on what happened and to show
     * If a communication error occurs its ignored
     * 
     * @param text the text to show
     */
    private void sendTextDC(String text) {
        for (Player player : getPlayers()) {
            try {
                sendText(player, text);
            } catch (DCPlayerException playerIn) {
                continue;
            }
        }
    }

    /**
     * Calculates the results of the game and show them to the players
     */
    private void results() {
        sendTextDC("Ahora se anunciara al ganador del juego...");
        sendTextDC(higher(this.getPlayers()));
    }

    /**
     * Calculates the results of the game and show them to the players, in case of a
     * communication error or player disconnection
     * If a communication error occurs its ignored
     */
    private void resultsDC() {
        sendTextDC("Un jugador se pudo haber desconectado o tuve un problema de conexion, terminando el juego...");
        sendTextDC("Ahora se anunciara al ganador del juego...");
        sendTextDC(higher(this.getPlayers()));
    }

    /**
     * Returns a string with the higher player of the list, or if there is a tie,
     * the players with the higher score
     * 
     * @param players the list of players
     * @return the player with the highest score
     */
    private String higher(List<Player> players) {
        String winner = "Hubo un empate entre los Jugadores ";
        int position = bigger(players);
        Player champ = players.get(position);
        int score = champ.getScore();
        List<Player> rest = clone(players);
        rest.remove(position);
        boolean tie = false;
        for (Player player1 : rest) {
            if (player1.getScore() == score) {
                tie = true;
                try {
                    winner += player1.getName() + ", ";
                } catch (DCPlayerException playerIn) {
                    winner += "Jugador desconectado ";
                    continue;
                }
            }
        }
        if (tie) {
            winner = winner.substring(0, winner.length() - 2);
            try {
                winner += " y " + champ.getName();
            } catch (DCPlayerException playerIn) {
                winner += " y Jugador desconectado";
            }
            return (winner + " todos con " + score + " puntos");
        }
        try {
            return "El ganador es el jugador " + champ.getName() + " con " + score + " puntos";
        } catch (DCPlayerException dcpe) {
            return "El ganador es el jugador desconectado" + " con " + score + " puntos";
        }
    }

    /**
     * Returns the position of the player with the higher score
     * 
     * @param list the list of players
     * @return the position of the player with the higher score
     */
    private int bigger(List<Player> list) {
        int answer = 0;
        int score = list.get(0).getScore();
        for (Player player : list) {
            if (player.getScore() >= score) {
                answer = list.indexOf(player);
                score = player.getScore();
            }
        }
        return answer;
    }

    /**
     * Ask the players if they want to continue playing
     * 
     * @throws DCPlayerException if a communication error occurs
     */
    private void carryOn() throws DCPlayerException {
        List<String> yes = new LinkedList<>();
        List<String> no = new LinkedList<>();
        for (Player player : this.getPlayers()) {
            int i = player.getContinue();
            if (i == 0) {
                yes.add("0");
            } else if (i == 1) {
                no.add("1");
            }
        }
        if (yes.size() < no.size()) {
            continues = false;
            return;
        } else if (yes.size() == no.size()) {
            for (Player player : this.getPlayers()) {
                sendText(player, "Hubo un empate, se realizara una nueva votacion");
            }
            carryOn();
            return;
        }
    }

    /**
     * Returns a copy of the list
     * 
     * @param list the list to copy
     * @return a copy of the list
     */
    private List<Player> clone(List<Player> players) {
        List<Player> clone = new LinkedList<>();
        for (Player player : players) {
            clone.add(player);
        }
        return clone;
    }

}
