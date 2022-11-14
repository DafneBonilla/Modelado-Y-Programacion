package games;

import cards.*;
import players.*;
import java.util.List;

public abstract class GamePart implements Subject {

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

    @Override
    public void sendText(String text) throws DCPlayerException {
        for (Player player : players) {
            player.showText(text);
        }
    }

    @Override
    public void registerObserver(Observer o) {
        players.add((Player) o);
    }

    @Override
    public void removeObserver(Observer o) {
        players.remove(o);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public CardHolder getDeck() {
        return mainDeck;
    }

}
