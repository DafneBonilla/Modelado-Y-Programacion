package cards;

/**
 * Class to represent the green color
 * A green color has a value of 4 and a card associated to it
 */
public class Green implements Color {

    /* The card associated to this color */
    private Card card;

    /**
     * Constructor
     * 
     * @param card the card associated to this color
     */
    public Green(Card card) {
        this.card = card;
    }

    /**
     * Returns the card associated to this color
     * 
     * @return the card associated to this color
     */
    @Override
    public Card getCard() {
        return card;
    }

    /**
     * Returns a integer representation of the color
     * 
     * @return a integer representation of the color
     */
    @Override
    public int getMerit() {
        return 4;
    }

    /**
     * Returns a string representation of the color
     * 
     * @return a string representation of the color
     */
    @Override
    public String toString() {
        return "\u001B[92mVerde\u001B[0m ";
    }

    /**
     * Returns true if the object received as parameter is equal to this color
     * 
     * @param o the object to compare
     * @return true if it is equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Color))
            return false;
        Color color = (Color) o;
        if (!(this.getMerit() == color.getMerit())) {
            return false;
        }
        return true;
    }

}
