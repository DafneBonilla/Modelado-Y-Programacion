package players;

import cards.*;
import views.*;

/**
 * Interface to represent a player
 */
public interface Player extends Observer {

    /**
     * Updates the player if the game has started
     * 
     * @throws DCPlayerException if the player has an error
     */
    public void startUpdate() throws DCPlayerException;

    /**
     * Returns the name of the player
     * 
     * @return the name of the player
     * @throws DCPlayerException if a communication error occurs
     */
    public String getName() throws DCPlayerException;

    /**
     * Returns the card holder of the player
     * 
     * @return the card holder
     */
    public CardHolder getDeck();

    /**
     * Sets the card holder of the player
     * 
     * @param deck the card holder
     * @throws DCPlayerException if a communication error occurs
     */
    public void setDeck(CardHolder deck) throws DCPlayerException;

    /**
     * Returns the score of the player
     * 
     * @return the score
     */
    public int getScore();

    /**
     * Sets the score of the player
     * 
     * @param i the score
     */
    public void setScore(int i);

    /**
     * Returns the bet of the player
     * 
     * @return the bet
     */
    public int getBet();

    /**
     * Sets the bet of the player
     * 
     * @param i the bet
     */
    public void setBet(int i);

    /**
     * Asks the player for a bet
     * 
     * @param numRound the number of the round
     * @return the bet
     * @throws DCPlayerException if a communication error occurs
     */
    public int askBet(int numRound) throws DCPlayerException;

    /**
     * Returns the number of trick won by the player
     * 
     * @return the number of trick won
     */
    public int getWins();

    /**
     * Sets the number of trick won by the player
     * 
     * @param i the number of trick won
     */
    public void setWins(int i);

    /**
     * Asks the player for an integer to use as the color of the trump
     * 
     * @return the color of the trump
     * @throws DCPlayerException if a communication error occurs
     */
    public int getTriumph() throws DCPlayerException;

    /**
     * Asks the player if he wants to continue
     * 0 to continue, 1 to end
     * 
     * @return 0 if the player wants to continue, 1 if he wants to end
     * @throws DCPlayerException if a communication error occurs
     */
    public int getContinue() throws DCPlayerException;

    /**
     * Adds a card to the players card holder
     * 
     * @param card the card to add
     */
    public void addCard(Card card);

    /**
     * Returns the card in the players card holder at the given index
     * 
     * @param i the index
     * @return the card
     */
    public Card giveCard(int i);

    /**
     * Updates the observer on what happened and to show
     * 
     * @param message the text to show
     * @throws DCPlayerException if a communication error occurs
     */
    @Override
    public void showText(String message) throws DCPlayerException;

    /**
     * Reads a string from the connection
     * 
     * @return the string
     * @throws DCPlayerException if a communication error occurs
     */
    public String read() throws DCPlayerException;

    /**
     * Sets the players view
     * 
     * @param view the view
     */
    public void setView(View view);

    /**
     * Asks the player for a card to play
     * 
     * @return the card
     * @throws DCPlayerException if a communication error occurs
     */
    public int askCard() throws DCPlayerException;

    /**
     * Ends the players connection
     * 
     * @throws DCPlayerException if a communication error occurs
     */
    public void end() throws DCPlayerException;

}
