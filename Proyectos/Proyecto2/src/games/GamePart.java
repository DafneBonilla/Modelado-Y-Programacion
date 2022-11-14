package games;

import cards.*;
import players.*;
import java.util.List;

/**
 * Abstract class to represent a game part
 * A game part has a list of players (instance of {@link Player}) and a deck
 * (instance of {@link CardHolder})
 */
public abstract class GamePart implements Subject {

    /* The list of players */
    private List<Player> players;

    /* The deck of the game part */
    private CardHolder mainDeck;

    /**
     * Constructor
     * 
     * @param players  the list of players
     * @param mainDeck the deck of the game part
     */
    public GamePart(List<Player> players, CardHolder mainDeck) {
        this.players = players;
        this.mainDeck = mainDeck;
    }

    /**
     * Stars the game part
     * 
     * @throws DCPlayerException if a communication error occurs
     */
    public abstract void start() throws DCPlayerException;

    /**
     * Updates the observer on what happened and to show
     * 
     * @param player the player to update
     * @param text   the text to show
     * @throws DCPlayerException if a communication error occurs
     */
    public void sendText(Player player, String text) throws DCPlayerException {
        player.showText(text);
    }

    /**
     * Updates the observer on what happened and to show
     * 
     * @param text the text to show
     * @throws DCPlayerException if a communication error occurs
     */
    @Override
    public void sendText(String text) throws DCPlayerException {
        for (Player player : players) {
            player.showText(text);
        }
    }

    /**
     * Adds an observer to the subject
     * 
     * @param o the observer
     */
    @Override
    public void registerObserver(Observer o) {
        players.add((Player) o);
    }

    /**
     * Removes an observer from the subject
     * 
     * @param o the observer
     */
    @Override
    public void removeObserver(Observer o) {
        players.remove(o);
    }

    /**
     * Returns the list of players
     * 
     * @return the list of players
     */
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * Returns the deck of the game part
     * 
     * @return the deck of the game part
     */
    public CardHolder getDeck() {
        return mainDeck;
    }

}
