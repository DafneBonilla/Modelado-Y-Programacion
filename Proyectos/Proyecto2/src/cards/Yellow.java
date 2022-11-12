package cards;

/**
 * Class to represent the yellow color
 * A yellow color has a value of 3 and a card associated to it
 */
public class Yellow implements Color {

    /* The card associated to this color */
    private Card card;

    /**
     * Constructor
     * 
     * @param card the card associated to this color
     */
    public Yellow(Card card) {
        this.card = card;
    }

    /**
     * Returns the card associated to this color
     * 
     * @return the card associated to this color
     */
    public Card getCard() {
        return card;
    }

    /**
     * Returns a integer representation of the color
     * 
     * @return a integer representation of the color
     */
    public int getMerit() {
        return 3;
    }

    /**
     * Returns a string representation of the color
     * 
     * @return a string representation of the color
     */
    public String toString() {
        return "Amarillo";
    }

    /**
     * Returns true if the object received as parameter is equal to this color
     * 
     * @param o the object to compare
     * @return true if it is equal, false otherwise
     */
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
