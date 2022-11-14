package cards;

/**
 * Class to represent the number value
 * A number value has a value between 1 and 13 and a card associated to it
 */
public class Number implements Value {

    /* The card associated to this value */
    private Card card;

    /* The value of the number */
    private int number;

    /**
     * Constructor
     * 
     * @param card the card associated to this value
     * @param i    the value of the number
     */
    public Number(Card card, int i) {
        this.card = card;
        this.number = i;
    }

    /**
     * Returns the card associated to this value
     * 
     * @return the card associated to this value
     */
    public Card getCard() {
        return card;
    }

    /**
     * Returns a integer representation of the value
     * 
     * @return a integer representation of the value
     */
    public int getValue() {
        return number;
    }

    /**
     * Returns a string representation of the value
     * 
     * @return a string representation of the value
     */
    @Override
    public String toString() {
        return Integer.toString(number);
    }

    /**
     * Returns true if the object received as parameter is equal to this value
     * 
     * @param o the object to compare
     * @return true if it is equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Value))
            return false;
        Value value = (Value) o;
        if (!(this.getValue() == value.getValue())) {
            return false;
        }
        return true;
    }

}
