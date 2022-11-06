package cards;

public class Wizard implements Value {

    private Card card;

    public Wizard(Card card) {
        this.card = card;
    }

    @Override
    public Card getCard() {
        return card;
    }

    @Override
    public int getValue() {
        return 14;
    }

    public String toString() {
        return "Mago";
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
