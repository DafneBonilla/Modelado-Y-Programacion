package cards;

/**
 * Class to represent a card
 * A card has a color (instance of {@link Color}) and a value (instance of
 * {@link Value})
 */
public class Card {

    /* The color of the card */
    private Color color;

    /* The value of the card */
    private Value value;

    /**
     * Constructor
     */
    public Card() {
        this.color = null;
        this.value = null;
    }

    /**
     * Returns the color of the card
     * 
     * @return the color of the card
     */
    public Color getColor() {
        return color;
    }

    /**
     * Returns the value of the card
     * 
     * @return the value of the card
     */
    public Value getValue() {
        return value;
    }

    /**
     * Returns a string representation of the card
     * 
     * @return a string representation of the card
     */
    public String toString() {
        return "Carta con valor " + value + " y color " + color;
    }

    /**
     * Returns true if the object received as parameter is equal to this card
     * 
     * @param o the object to compare
     * @return true if it is equal, false otherwise
     */
    public boolean equals(Object o) {
        if (!(o instanceof Card))
            return false;
        Card card = (Card) o;
        if ((this.value.equals(card.value)) == false) {
            return false;
        } else if ((this.color.equals(card.color)) == false) {
            return false;
        }
        return true;
    }

    /**
     * Compares this card with the card received as parameter
     * First compares the color of the cards, then the value
     * 
     * @param card the card to compare
     * @return 1 if this card is greater than the card received as parameter, -1 if
     *         it is less, 0 if they are equal
     */
    public int compareTo(Card card) {
        if (this.color.getMerit() > card.color.getMerit()) {
            return 1;
        } else if (this.color.getMerit() == card.color.getMerit()) {
            if (this.value.getValue() > card.value.getValue()) {
                return 1;
            } else if (this.value.getValue() == card.value.getValue()) {
                return 0;
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }

    /**
     * Sets the color of the card
     * 
     * @param color the color of the card
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Sets the value of the card
     * 
     * @param value the value of the card
     */
    public void setValue(Value value) {
        this.value = value;
    }

}
