package cards;

public class Wizard implements Value {

    private Card card;

    public Wizard(Card card) {
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
        return "Wizard";
    }

    public boolean equals(Object o) {   
        if (o instanceof Wizard) {
            Wizard w = (Wizard) o;
            return w.getCard().equals(card);
        }
        return false;
    }
    
}
