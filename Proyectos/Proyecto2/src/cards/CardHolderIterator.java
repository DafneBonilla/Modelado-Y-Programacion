package cards;

import java.io.Serializable;

public interface CardHolderIterator extends Serializable {
    
    public boolean hasNext();
    
    public Card next();
    
    public void restart();
}
