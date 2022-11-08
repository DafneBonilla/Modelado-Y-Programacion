package game;

import player.*;
import cards.*;
import java.util.List;

public abstract class GamePart {
    
    private List<Player> players;
    private Deck mainDeck;

    public GamePart(List<Player> players, Deck mainDeck) {
        
    }
    
    public void start() {

    }
    public void sendText(Player player, String text) {

    }
    
    public void sendText(String text) {
        
    }
    
    public int askOption(Player player, String question, int min, int max, String error ) {
        return 0;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Deck getDeck() {
        return mainDeck;
    }

}

