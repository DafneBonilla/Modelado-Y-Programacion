package games;

import cards.*;
import players.Player;

import java.util.LinkedList;
import java.util.List;
import players.DCPlayerException;

/**
 * Class to represent a trick of the game
 * A trick has a color of trump (instance of {@link Color}), a leader color
 * (instance of {@link Color}) and a list of played cards (instance of
 * {@link Card})
 */
public class GameTrick extends GamePart {

    /* The color of trump */
    private Color triumph;

    /* The leader color */
    private Color leader;

    /* The list of played cards */
    private List<Card> plays;

    /**
     * Constructor
     * 
     * @param players  the list of players
     * @param mainDeck the deck of the game part
     * @param triumph  the color of trump
     */
    public GameTrick(List<Player> players, CardHolder mainDeck, Color triumph) {
        super(players, mainDeck);
        this.triumph = triumph;
        this.leader = new NoColor(null);
        this.plays = new LinkedList<>();
    }

    /**
     * Starts the game part
     * 
     * @throws DCPlayerException if a communication error occurs
     */
    @Override
    public void start() throws DCPlayerException {
        sendText("El truco va a empezar");
        for (Player player : this.getPlayers()) {
            sendText(player, "Jugador " + player.getName() + " es tu turno de jugar una carta");
            sendText(player, "El palo lider es " + leader);
            sendText(player, "El palo de triunfo es " + triumph);
            int index = validateCard(player);
            Card card = reciveCard(player, index);
            sendText("El jugador " + player.getName() + " jugo la " + card);
            defineLeader(card);
            plays.add(card);
        }
        int winner = winnerCard();
        Player player1 = getPlayers().get(winner);
        int wins = player1.getWins();
        player1.setWins(wins + 1);
        sendText("El jugador " + player1.getName() + " gana el truco");
        for (Card card : plays) {
            this.getDeck().addCard(card);
        }
        adjustPlayers(winner);
    }

    /**
     * Defines the leader color of the trick
     * 
     * @param card the card played
     * @throws DCPlayerException if a communication error occurs
     */
    private void defineLeader(Card card) throws DCPlayerException {
        if (leader.getMerit() == -1) {
            if (card.getColor().getMerit() == 5) {
                return;
            }
            leader = card.getColor();
            sendText("El palo lider es " + leader);
        }
    }

    /**
     * Returns the card in the index position of the players hand
     * 
     * @param player the player
     * @param i      the index
     * @return the card
     */
    private Card reciveCard(Player player, int i) {
        return player.giveCard(i);
    }

    /**
     * Validates the card played by the player and returns the index of the card, if
     * the card is not valid it will ask the player to play again until it is valid
     * 
     * @param player the player
     * @return the index of the card
     * @throws DCPlayerException if a communication error occurs
     */
    private int validateCard(Player player) throws DCPlayerException {
        int i = -1;
        player.setDeck(player.getDeck());
        while (true) {
            i = player.askCard();
            Card card = player.getDeck().checkCard(i);
            if (legalCard(card, player.getDeck().copy(), i)) {
                return i;
            } else {
                sendText(player, "Carta invalida, debes jugar otra carta");
            }
        }
    }

    /**
     * Checks if the card is legal to play in the trick based on the leader color,
     * the color of trump and the cards in the players hand
     * 
     * @param card the card to check
     * @param hand the players hand
     * @param i    the index of the card
     * @return true if the card is legal, false otherwise
     */
    private boolean legalCard(Card card, CardHolder hand, int i) {
        hand.getCard(i);
        if (hand.isEmpty()) {
            return true;
        }
        if (card.getColor().equals(leader)) {
            return true;
        }
        if (card.getValue().getValue() == 0 || card.getValue().getValue() == 14) {
            return true;
        }
        if (leader.getMerit() == -1) {
            return true;
        }
        CardHolderIterator it = hand.getIterator();
        while (it.hasNext()) {
            Card card1 = it.next();
            if (card1.getColor().equals(leader)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the index of the winner card
     * 
     * @return the index of the winner card
     */
    private int winnerCard() {
        int wizzard = playWizard();
        if (wizzard != -1) {
            return wizzard;
        }
        int triumph = playTriumph();
        if (triumph != -1) {
            return triumph;
        }
        int leader = playLeader();
        if (leader != -1) {
            return leader;
        }
        int joker = playJoker();
        if (joker != -1) {
            return joker;
        }
        return -1;
    }

    /**
     * Returns the index of the first wizard played, if there is no wizard played it
     * returns -1
     * 
     * @return the index of the first wizard played
     */
    private int playWizard() {
        for (Card card1 : plays) {
            if (card1.getValue().getValue() == 14) {
                return plays.indexOf(card1);
            }
        }
        return -1;
    }

    /**
     * Returns the index of the first card with the color of trump played, if there
     * is no card with the color of trump played it returns -1
     * 
     * @return the index of the first card with the color of trump played
     */
    private int playTriumph() {
        int compare = 0;
        int index = -1;
        for (Card card1 : plays) {
            if (card1.getColor().equals(triumph)) {
                if (card1.getValue().getValue() > compare) {
                    compare = card1.getValue().getValue();
                    index = plays.indexOf(card1);
                }
            }
        }
        return index;
    }

    /**
     * Returns the index of the first card with the leader color played, if there is
     * no card with the leader color played it returns -1
     * 
     * @return the index of the first card with the leader color played
     */
    private int playLeader() {
        int compare = 0;
        int index = -1;
        for (Card card1 : plays) {
            if (card1.getColor().equals(leader)) {
                if (card1.getValue().getValue() > compare) {
                    compare = card1.getValue().getValue();
                    index = plays.indexOf(card1);
                }
            }
        }
        return index;
    }

    /**
     * Returns the index of the first joker played, if there is no joker played it
     * returns -1
     * 
     * @return the index of the first joker played
     */
    private int playJoker() {
        for (Card card1 : plays) {
            if (card1.getValue().getValue() == 0) {
                return plays.indexOf(card1);
            }
        }
        return -1;
    }

    /**
     * Adjusts the players list to the winner of the trick
     * 
     * @param i the index of the winner
     */
    private void adjustPlayers(int i) {
        for (int j = 0; j < i; j++) {
            List<Player> players = this.getPlayers();
            Player adjust = players.get(0);
            players.remove(adjust);
            players.add(adjust);
        }
    }

}
