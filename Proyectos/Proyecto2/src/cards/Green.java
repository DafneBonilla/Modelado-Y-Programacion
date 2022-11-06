package cards;

public class Green implements Color {

    private Card card;

    public Green(Card card) {
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    public int getMerit() {
        return 4;
    }

    public String toString() {
        return "Verde";
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
