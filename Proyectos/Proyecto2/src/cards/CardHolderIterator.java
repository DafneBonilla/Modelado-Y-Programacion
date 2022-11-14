package cards;

/**
 * Interface to represent a card holder iterator
 */
public interface CardHolderIterator {

    /**
     * Returns true if there is a next card
     * 
     * @return true if there is a next card, false otherwise
     */
    public boolean hasNext();

    /**
     * Returns the next card
     * 
     * @return the next card
     */
    public Card next();

    /**
     * Restarts the iterator
     */
    public void restart();

}
