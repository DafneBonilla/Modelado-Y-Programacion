package cards;

import java.io.Serializable;

/**
 * Interface to represent a card color
 */
public interface Color extends Serializable {

    /**
     * Returns the card that is associated to this color
     * 
     * @return the card that is associated to this color
     */
    public Card getCard();

    /**
     * Returns a integer representation of the color
     * 
     * @return a integer representation of the color
     */
    public int getMerit();

    /**
     * Returns a string representation of the color
     * 
     * @return a string representation of the color
     */
    @Override
    public String toString();

    /**
     * Returns true if the object received as parameter is equal to this color
     * 
     * @param o the object to compare
     * @return true if it is equal, false otherwise
     */
    public boolean equals(Object o);

}
