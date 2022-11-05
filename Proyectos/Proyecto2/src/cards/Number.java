package cards;

public class Number implements Value {

    private Card card;

    private int number;

    public Number(int i) {
        this.number = i;
    }

    @Override
    public Card getCard() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getValue() {
        // TODO Auto-generated method stub
        return 0;
    }

    public String toString() {
        return "Number";
    }

    public boolean equals(Object o) {   
        if (o instanceof Number) {
            Number n = (Number) o;
            return n.getCard().equals(card);
        }
        return false;
    }

}
