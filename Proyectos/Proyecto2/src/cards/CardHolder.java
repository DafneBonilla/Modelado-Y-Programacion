package cards;

/**
 * Interface to represent a card holder
 */
public interface CardHolder {

    /**
     * Add a card to the holder
     * 
     * @param card the card to add
     */
    public void addCard(Card card);

    /**
     * Returns and removes the card at the position received as parameter
     * 
     * @param i the position of the card
     * @return the card at the specified position
     */
    public Card getCard(int i);

    /**
     * Returns the card at the position received as parameter
     * 
     * @param i the position of the card
     * @return the card at the specified position
     */
    public Card checkCard(int i);

    /**
     * Sorts the cards in the holder
     */
    public void sort();

    /**
     * Returns the number of cards in the holder
     * 
     * @return the number of cards in the holder
     */
    public int size();

    /**
     * Shuffles the cards in the holder
     */
    public void shuffle();

    /**
     * Returns if the holder is empty
     * 
     * @return true if the holder is empty, false otherwise
     */
    public boolean isEmpty();

    /**
     * Returns a copy of the holder
     * 
     * @return a copy of the holder
     */
    public CardHolder copy();

    /**
     * Returns an iterator for the holder
     * 
     * @return an iterator for the holder
     */
    public CardHolderIterator getIterator();

}
