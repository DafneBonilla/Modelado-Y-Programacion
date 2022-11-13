package game;

import player.*;
import cards.*;
import java.util.List;

public abstract class GamePart {

    private List<Player> players;

    private CardHolder mainDeck;

    public GamePart(List<Player> players, CardHolder mainDeck) {
        this.players = players;
        this.mainDeck = mainDeck;
    }

    public abstract void start() throws DCPlayerException;

    public void sendText(Player player, String text) throws DCPlayerException {
        player.showText(text);
    }

    public void sendText(String text) throws DCPlayerException {
        for (Player player : players) {
            player.showText(text);
        }
    }

    public List<Player> getPlayers() {
        return players;
    }

    public CardHolder getDeck() {
        return mainDeck;
    }

}
