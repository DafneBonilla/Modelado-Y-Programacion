package players;

/**
 * Interface to represent an observer
 */
public interface Observer {

    /**
     * Updates the observer on what happened and to show
     * 
     * @param text the text to show
     * @throws DCPlayerException if a communication error occurs
     */
    public void showText(String text) throws DCPlayerException;

}
