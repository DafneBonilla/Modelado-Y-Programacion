package cards;

public class Red implements Color {

    private Card card;

    public Red(Card card) {
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    public int getMerit() {
        return 1;
    }

    public String toString() {
        return "Rojo";
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
