package cards;

import java.io.Serializable;

public interface Color extends Serializable {
    
    public Card getCard();
    
    public int getMerit();
    
    public String toString();
    
    public boolean equals(Object o);
    
}
