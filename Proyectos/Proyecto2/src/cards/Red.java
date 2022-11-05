package cards;

public class Red implements Color {
    // Esperando pacientemente =D
    private Card card;

    public Red(Card card) {
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    public int getMerit() {
        return 0;
    }

    public String toString() {
        return card.toString();
    }

    public boolean equals(Object o) {
        return false;
    }
    
}
