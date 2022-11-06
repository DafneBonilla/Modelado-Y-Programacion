package cards;

public class White implements Color {

    private Card card;

    public White(Card card) {
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    public int getMerit() {
        return 5;
    }

    public String toString() {
        return "Blanco";
    }

    public boolean equals(Object o) {
        if (!(o instanceof Color))
            return false;
        Color color = (Color) o;
        if (!(this.getMerit() == color.getMerit())) {
            return false;
        }
        return true;
    }

}
