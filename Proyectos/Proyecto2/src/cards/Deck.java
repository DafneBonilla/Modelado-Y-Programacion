package cards;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Class to represent a deck of cards
 * A deck has a list of cards (instances of {@link Card}) and a seed for the
 * random number generator
 */
public class Deck implements CardHolder {

    /* The list of cards */
    private List<Card> cards;

    /* The seed */
    private long seed;

    /**
     * Private class to represent a deck iterator
     * A deck iterator has an iterator of cards
     */
    private class DeckIterator implements CardHolderIterator {

        /* The iterator of cards */
        private Iterator<Card> iterator;

        /**
         * Constructor
         */
        public DeckIterator() {
            iterator = cards.iterator();
        }

        /**
         * Returns true if there is a next card
         * 
         * @return true if there is a next card, false otherwise
         */
        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        /**
         * Returns the next card
         * 
         * @return the next card
         */
        @Override
        public Card next() {
            return iterator.next();
        }

        /**
         * Restarts the iterator
         */
        @Override
        public void restart() {
            iterator = cards.iterator();
        }

    }

    /**
     * Constructor for a deck with no seed
     */
    public Deck() {
        cards = new LinkedList<Card>();
        seed = 0;
    }

    /**
     * Constructor for a deck with a seed
     * 
     * @param seed the seed
     */
    public Deck(long seed) {
        cards = new LinkedList<Card>();
        this.seed = seed;
    }

    /**
     * Adds a card to the deck
     * 
     * @param card the card to add
     */
    @Override
    public void addCard(Card card) {
        cards.add(card);
    }

    /**
     * Returns and removes the card at the position received as parameter
     * 
     * @param i the position of the card
     * @return the card at the specified position
     */
    @Override
    public Card getCard(int i) {
        Card card = cards.get(i);
        cards.remove(i);
        return card;
    }

    /**
     * Returns the card at the position received as parameter
     * 
     * @param i the position of the card
     * @return the card at the specified position
     */
    @Override
    public Card checkCard(int i) {
        return cards.get(i);
    }

    /**
     * Sorts the cards in the deck
     */
    @Override
    public void sort() {
        cards.sort((card1, card2) -> card1.compareTo(card2));
    }

    /**
     * Returns the number of cards in the deck
     * 
     * @return the number of cards in the deck
     */
    @Override
    public int size() {
        return cards.size();
    }

    /**
     * Returns the deck in an array form
     * 
     * @return the deck as an array
     */
    private Card[] turnArray() {
        Card[] answer = new Card[cards.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = checkCard(i);
        }
        return answer;
    }

    /**
     * Turns an array of cards into this deck
     * 
     * @param cards the array of cards
     */
    private void turnDeck(Card[] cards) {
        this.cards = new LinkedList<Card>();
        for (int i = 0; i < cards.length; i++) {
            addCard(cards[i]);
        }
    }

    /**
     * Shuffles the cards in the deck
     */
    @Override
    public void shuffle() {
        Card[] array = turnArray();
        shuffleAux(array);
        turnDeck(array);
    }

    /**
     * Auxiliary method to shuffle an array of cards
     * Source of the algorithm:
     * https://www.geeksforgeeks.org/shuffle-a-given-array-using-fisher-yates-
     * shuffle-algorithm/
     * 
     * @param cards the array of cards
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

    /**
     * Returns if the deck is empty
     * 
     * @return true if the deck is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return cards.isEmpty();
    }

    /**
     * Returns a copy of the deck
     * 
     * @return a copy of the deck
     */
    @Override
    public CardHolder copy() {
        Deck answer = new Deck();
        for (int i = 0; i < cards.size(); i++) {
            answer.addCard(cards.get(i));
        }
        return answer;
    }

    /**
     * Returns an iterator for the deck
     * 
     * @return an iterator for the deck
     */
    @Override
    public CardHolderIterator getIterator() {
        return new DeckIterator();
    }

}
