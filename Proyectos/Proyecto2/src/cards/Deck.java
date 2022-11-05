package cards;

import java.util.Iterator;
import java.util.List;

public class Deck implements CardHolder {
    
    private class DeckIterator implements CardHolderIterator {
        
        private Iterator<Card> iterator;

        public boolean hasNext() {
            return false;
        }

        public Card next() {
            return null;
        }
        
        public void restart() {
            
        }
    }

    private List<Card> cards;
    
    
    public Deck() {
        
    }

    public Deck(List<Card> cards) {
        
    }
    
    public Deck(Long seed) {
        
    }
    
    public void addCard(Card card) {

    }

    public Card getCard(int i) {
        return null;
    }

    public Card checkCard(int i) {
        return null;
    }

    public void sort() {

    }

    public void size() {
        
    }

    private Card[] turnArray() {
        return null;
    }
    
    private void turnDeck(Card[] cards){

    }

    public void shuffle() {

    }

    private void shuffleAux(Card[] cards) {

    }

    public boolean isEmpty() {
        return false;
    }

    public CardHolder copy() {
        return null;
    }

    public List<Card> getList() {
        return null;
    }

}
