package cards;

/**
 * Class to represent the wizard value
 * A wizard value has a value of 14 and a card associated to it
 */
public class Wizard implements Value {

    /* The card associated to this value */
    private Card card;

    /**
     * Constructor
     * 
     * @param card the card associated to this value
     */
    public Wizard(Card card) {
        this.card = card;
    }

    /**
     * Returns the card associated to this value
     * 
     * @return the card associated to this value
     */
    @Override
    public Card getCard() {
        return card;
    }

    /**
     * Returns a integer representation of the value
     * 
     * @return a integer representation of the value
     */
    @Override
    public int getValue() {
        return 14;
    }

    /**
     * Returns a string representation of the value
     * 
     * @return a string representation of the value
     */
    @Override
    public String toString() {
        return "Mago";
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
