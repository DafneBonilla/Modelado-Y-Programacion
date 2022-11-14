package views;

import players.*;

/**
 * Interface to represent a view
 */
public interface View {

    /**
     * Asks the user for an integer
     * 
     * @param question the question to ask
     * @return the integer entered by the user
     */
    public int askInt(String question);

    /**
     * Asks the user for a string
     * 
     * @param question the question to ask
     * @return the string entered by the user
     */
    public String askString(String question);

    /**
     * Shows the user a message
     * 
     * @param message the message to show
     */
    public void showText(String message);

    /**
     * Returns the player of the view
     * 
     * @return the player of the view
     */
    public Player getPlayer();

}
