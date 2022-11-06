package cards;

public class Joker implements Value {

    private Card card;

    public Joker(Card card) {
        this.card = card;
    }

    @Override
    public Card getCard() {
        return card;
    }

    @Override
    public int getValue() {
        return 0;
    }

    public String toString() {
        return "Joker";
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
