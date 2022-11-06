package cards;

import java.util.List;

public interface CardHolder {

    public void addCard(Card card);

    public Card getCard(int i);

    public Card checkCard(int i);

    public void sort();

    public int size();

    public void shuffle();

    public boolean isEmpty();

    public CardHolder copy();

    public List<Card> getList();

    public CardHolderIterator getIterator();

}
