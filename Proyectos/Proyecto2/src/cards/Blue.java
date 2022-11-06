package cards;

public class Blue implements Color {

    private Card card;

    public Blue(Card card) {
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    public int getMerit() {
        return 2;
    }

    public String toString() {
        return "Azul";
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
