package games;

import players.DCPlayerException;
import players.Observer;

/**
 * Interface to represent a subject for observers
 */
public interface Subject {

    /**
     * Updates the observer on what happened and to show
     * 
     * @param text the text to show
     * @throws DCPlayerException if a communication error occurs
     */
    public void sendText(String text) throws DCPlayerException;

    /**
     * Adds an observer to the subject
     * 
     * @param o the observer
     */
    public void registerObserver(Observer o);

    /**
     * Removes an observer from the subject
     * 
     * @param o the observer
     */
    public void removeObserver(Observer o);

}
