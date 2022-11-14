package cards;

/**
 * Interface to represent a card value
 */
public interface Value {

    /**
     * Returns the card that is associated to this value
     * 
     * @return the card that is associated to this value
     */
    public Card getCard();

    /**
     * Returns a integer representation of the value
     * 
     * @return a integer representation of the value
     */
    public int getValue();

    /**
     * Returns a string representation of the value
     * 
     * @return a string representation of the value
     */
    @Override
    public String toString();

    /**
     * Returns true if the object received as parameter is equal to this value
     * 
     * @param o the object to compare
     * @return true if it is equal, false otherwise
     */
    @Override
    public boolean equals(Object o);

}
