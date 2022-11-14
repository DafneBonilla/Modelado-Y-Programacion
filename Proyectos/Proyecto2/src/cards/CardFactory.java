package cards;

/**
 * Interface to represent a card factory
 */
public interface CardFactory {

    /**
     * Builds a card with the given color and value
     * 
     * @param color the color
     * @param value the value
     * @return the card built
     */
    public Card build(int color, int value);

}
