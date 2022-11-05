package cards;

import java.io.Serializable;

public interface Value extends Serializable {
    
    public Card getCard();
    
    public int getValue();
    
    public String toString();
    
    public boolean equals(Object o);
    
}
