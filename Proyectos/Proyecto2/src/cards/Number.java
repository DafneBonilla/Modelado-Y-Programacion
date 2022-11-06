package cards;

public class Number implements Value {

    private Card card;

    private int number;

    public Number(Card card, int i) {
        this.card = card;
        this.number = i;
    }

    @Override
    public Card getCard() {
        return card;
    }

    @Override
    public int getValue() {
        return number;
    }

    public String toString() {
        return Integer.toString(number);
    }

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
