package games;

import cards.*;
import players.DCPlayerException;
import players.Player;
import java.util.List;

/**
 * Class to represent a round of the game
 * A round has a number of round, a number of tricks and a color of trump
 * (instance of {@link Color})
 */
public class GameRound extends GamePart {

    /* The number of the round */
    private int numRound;

    /* The number of tricks */
    private int numTricks;

    /* The color of trump */
    private Color triumph;

    /**
     * Constructor
     * 
     * @param players  the list of players
     * @param mainDeck the deck of the game part
     * @param numRound the number of the round
     */
    public GameRound(List<Player> players, CardHolder mainDeck, int numRound) {
        super(players, mainDeck);
        this.numRound = numRound;
        this.numTricks = numRound;
        this.triumph = new NoColor(null);
    }

    /**
     * Starts the game part
     * 
     * @throws DCPlayerException if a communication error occurs
     */
    @Override
    public void start() throws DCPlayerException {
        sendText("La ronda " + numRound + " va a empezar");
        this.getDeck().shuffle();
        dealCards();
        defineTriumph();
        setBets();
        for (int i = 1; i <= numTricks; i++) {
            GameTrick actual = new GameTrick(this.getPlayers(), this.getDeck(), triumph);
            actual.start();
        }
        score();
        sendText("Las puntaciones se ven asi...");
        for (Player player : this.getPlayers()) {
            sendText("El jugador " + player.getName() + " tiene " + player.getScore() + " puntos");
        }
    }

    /**
     * Deals the cards to the players
     */
    private void dealCards() {
        for (int i = 0; i < numRound; i++) {
            for (Player player : this.getPlayers()) {
                Card card = this.getDeck().getCard(0);
                player.addCard(card);
            }
        }
    }

    /**
     * Defines the color of trump
     * 
     * @throws DCPlayerException if a communication error occurs
     */
    private void defineTriumph() throws DCPlayerException {
        if (!this.getDeck().isEmpty()) {
            Card card = this.getDeck().getCard(0);
            Color triumph1 = card.getColor();
            switch (triumph1.getMerit()) {
                case 5:
                    if (card.getValue().getValue() == 0) {
                        sendText("El palo de triunfo es " + triumph);
                        this.getDeck().addCard(card);
                        return;
                    }
                    askTriumph();
                    break;
                default:
                    triumph = triumph1;
                    break;
            }
            this.getDeck().addCard(card);
            sendText("El palo de triunfo es " + triumph);
        }
    }

    /**
     * Asks the players for the color of trump
     * 
     * @throws DCPlayerException if a communication error occurs
     */
    private void askTriumph() throws DCPlayerException {
        Player player = this.getPlayers().get(0);
        sendText(player, "Jugador " + player.getName() + " elige el palo de triunfo");
        int i = validateTriumph(player);
        triumph = null;
        switch (i) {
            case 1:
                triumph = new Red(null);
                break;
            case 2:
                triumph = new Blue(null);
                break;
            case 3:
                triumph = new Yellow(null);
                break;
            case 4:
                triumph = new Green(null);
                break;
            case 5:
                triumph = new White(null);
                break;
            default:
                triumph = new Red(null);
                break;
        }
    }

    /**
     * Asks the player for the color of trump
     * 
     * @param player the player to ask
     * @return the color of trump
     * @throws DCPlayerException if a communication error occurs
     */
    private int validateTriumph(Player player) throws DCPlayerException {
        return player.getTriumph();
    }

    /**
     * Sets the bets of the players
     * 
     * @throws DCPlayerException if a communication error occurs
     */
    private void setBets() throws DCPlayerException {
        for (Player player : this.getPlayers()) {
            sendText(player, "Jugador " + player.getName() + " es tu turno de ver tus cartas.");
            sendText(player, "El palo de triunfo es " + triumph);
            int bet = askBet(player);
            player.setBet(bet);
            sendText("El jugador " + player.getName() + " ha apostado " + bet);
        }
    }

    /**
     * Asks the player for the bet
     * 
     * @param player the player to ask
     * @return the bet
     * @throws DCPlayerException if a communication error occurs
     */
    private int askBet(Player player) throws DCPlayerException {
        player.setDeck(player.getDeck());
        return player.askBet(numRound);
    }

    /**
     * Updates the score of the players
     */
    private void score() throws DCPlayerException {
        for (Player player : this.getPlayers()) {
            if (player.getBet() == player.getWins()) {
                int score = player.getScore();
                score += 20 + 10 * player.getWins();
                player.setScore(score);
            } else {
                int victories = player.getWins();
                int bet = player.getBet();
                if (victories > bet) {
                    int rest = victories - bet;
                    int score = player.getScore();
                    score -= rest * 10;
                    player.setScore(score);
                } else {
                    int rest = bet - victories;
                    int score = player.getScore();
                    score -= rest * 10;
                    player.setScore(score);
                }
            }
            player.setBet(0);
            player.setWins(0);
        }
    }

}
