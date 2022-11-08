package game;

import cards.*;
import player.Player;
import java.util.List;

public class GameTrick extends GamePart {
    
    private Color triumph;
    private Color leader;   
    private List<Card> plays;

    public GameTrick(List<Player> players, Deck mainDeck, Color triumph ) {
        
    }
    
    public void start() {
        
    }
    
    private void defineLeader() {
        
    }
    
    private Card reciveCard(Player player, int i) {
        return null;
    }
    
    private int validateCard(Player player) {
        return 0;
    }
    
    private boolean legalCard(Card card, Deck hand, int i) {
        return false;
    }
    
    private int winnerCard() {
        return 0;
    }
    
    private int playWizard() {
        return 0;
    }
    
    private int playTriumph() {
        return 0;
    }
    
    private int playLeader() {
        return 0;
    }
    
    private int playJoker() {
        return 0;
    }
    
    private void adjustPlayers() {
        
    }

}
