package cards;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Deck implements CardHolder {

    private List<Card> cards;

    private long seed;

    private class DeckIterator implements CardHolderIterator {

        private Iterator<Card> iterator;

        public DeckIterator() {
            iterator = cards.iterator();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public Card next() {
            return iterator.next();
        }

        @Override
        public void restart() {
            iterator = cards.iterator();
        }

        @Override
        public int size() {
            return cards.size();
        }

    }

    public Deck() {
        cards = new LinkedList<Card>();
        seed = 0;
    }

    public Deck(List<Card> cards) {
        this.cards = cards;
        seed = 0;
    }

    public Deck(long seed) {
        cards = new LinkedList<Card>();
        this.seed = seed;
    }

    @Override
    public void addCard(Card card) {
        cards.add(card);
    }

    @Override
    public Card getCard(int i) {
        Card card = cards.get(i);
        cards.remove(i);
        return card;
    }

    @Override
    public Card checkCard(int i) {
        return cards.get(i);
    }

    @Override
    public void sort() {
        cards.sort((card1, card2) -> card1.compareTo(card2));
    }

    @Override
    public int size() {
        return cards.size();
    }

    private Card[] turnArray() {
        Card[] answer = new Card[cards.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = getCard(i);
        }
        return answer;
    }

    private void turnDeck(Card[] cards) {
        for (int i = 0; i < cards.length; i++) {
            addCard(cards[i]);
        }
    }

    @Override
    public void shuffle() {
        Card[] array = turnArray();
        shuffleAux(array);
        turnDeck(array);

    }

    /*
     * https://www.geeksforgeeks.org/shuffle-a-given-array-using-fisher-yates-
     * shuffle-algorithm/
     */
    private void shuffleAux(Card[] cards) {
        int n = cards.length;
        Random random = new Random(seed);
        for (int i = 0; i < cards.length; i++) {
            int randomValue = i + random.nextInt(n - i);
            Card randomElement = cards[randomValue];
            cards[randomValue] = cards[i];
            cards[i] = randomElement;
        }
    }

    @Override
    public boolean isEmpty() {
        return cards.isEmpty();
    }

    @Override
    public CardHolder copy() {
        Deck answer = new Deck();
        for (int i = 0; i < cards.size(); i++) {
            answer.addCard(cards.get(i));
        }
        return answer;
    }

    @Override
    public List<Card> getList() {
        return cards;
    }

    @Override
    public CardHolderIterator getIterator() {
        return new DeckIterator();
    }

}
