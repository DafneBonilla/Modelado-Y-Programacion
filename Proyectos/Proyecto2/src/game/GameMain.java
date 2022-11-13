package game;

import cards.*;
import player.*;
import java.util.List;
import java.util.LinkedList;
import java.io.IOException;

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
        boolean normalFinish = true;
        try {
            sendText("La partida va a empezar, todos listos :)");
            sendText("La seed del juego es " + seed);
            for (int i = 1; i <= numRounds; i++) {
                GameRound actual = new GameRound(this.getPlayers(), this.getDeck(), numRounds);
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
            normalFinish = false;
        }
        if (normalFinish) {
            results();
        }
    }

    private void sendTextDC(String text) {
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
        sendTextDC(results);
    }

    private void resultsDC() {
        String results = "Un jugador se pudo haber desconectado o tuve un problema de conexion, terminando el juego...\n";
        results += "Ahora se anunciara al ganador del juego...\n\n";
        results += winner();
        sendTextDC(results);
        System.exit(0);
    }

    private String winner() {
        return higher(this.getPlayers());
    }

    private String higher(List<Player> players) {
        String winner = "Hubo un empate entre los Jugadores ";
        int position = bigger(players);
        Player champ = players.get(position);
        int score = champ.getScore();
        List<Player> rest = clone(players);
        Player delete = rest.get(position);
        rest.remove(delete);
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
                winner += " y " + champ.getName() ;
            } catch (DCPlayerException playerIn) {
                winner += " y Jugador desconectado";
            }
            return winner + " todos con " + score + " puntos\n";
        }
        try {
            return "El ganador es el jugador " + champ.getName() + " con " + champ.getScore() + " puntos\n";
        } catch (DCPlayerException playerIn) {
            return "El ganador es el jugador desconectado" + " con " + champ.getScore() + " puntos\n";
        }
    }

    private int bigger(List<Player> list) {
        int answer = 0;
        int score = list.get(0).getScore();
        for (Player player : list) {
            if (player.getScore() >= score) {
                answer = list.indexOf(player);
            }
        }
        return answer;
    }

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

    private List<Player> clone(List<Player> players) {
        List<Player> clone = new LinkedList<>();
        for (Player player : players) {
            clone.add(player);
        }
        return clone;
    }

}
