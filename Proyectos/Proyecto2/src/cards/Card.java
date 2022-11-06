package cards;

import java.io.Serializable;

public class Card implements Serializable {

    private Color color;

    private Value value;

    public Card() {
        this.color = null;
        this.value = null;
    }

    public Color getColor() {
        return color;
    }

    public Value getValue() {
        return value;
    }

    public String toString() {
        return "Carta con valor " + value + " y color " + color;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Card))
            return false;
        Card card = (Card) o;
        if ((this.value.equals(card.value)) == false) {
            return false;
        } else if ((this.color.equals(card.color)) == false) {
            return false;
        }
        return true;
    }

    public int compareTo(Card card) {
        if (this.color.getMerit() > card.color.getMerit()) {
            return 1;
        } else if (this.color.getMerit() == card.color.getMerit()) {
            if (this.value.getValue() > card.value.getValue()) {
                return 1;
            } else if (this.value.getValue() == card.value.getValue()) {
                return 0;
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setValue(Value value) {
        this.value = value;
    }

}
