package cards;

public class Yellow implements Color {

    private Card card;

    public Yellow(Card card) {
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    public int getMerit() {
        return 3;
    }

    public String toString() {
        return "Amarillo";
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
