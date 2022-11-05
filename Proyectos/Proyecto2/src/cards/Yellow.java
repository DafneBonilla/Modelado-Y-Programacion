package cards;

public class Yellow implements Color {
    private Card card;

    public Yellow(Card card) {
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    public int getMerit(){
        return 0;
    }

    public String toString(){
        return card.toString();
    }

    public boolean equals(Object o){
        return false;
    }
    
}
