package cards;

public class Joker implements Value {

    private Card card;

    public Joker(Card card) {
        this.card = card;
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
        return "Joker";
    }

    public boolean equals(Object o) {   
        if (o instanceof Joker) {
            Joker j = (Joker) o;
            return j.getCard().equals(card);
        }
        return false;
    }
    
}
