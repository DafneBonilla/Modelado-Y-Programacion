package cards;

import java.io.Serializable;

public class Card implements Serializable {
    
    private Color color;
    
    private Value value;

    public Card(Color color, Value value) {
        this.color = color;
        this.value = value;
    }

    public Color getColor() {
        return null;
    }

    public Value getValue() {
        return null;
    }

    public String toString() {
        return null;
    }

    public boolean equals(Object o) {
        return false;
    }

    public int compareTo(Card card) {
        return 0;
    }

}
