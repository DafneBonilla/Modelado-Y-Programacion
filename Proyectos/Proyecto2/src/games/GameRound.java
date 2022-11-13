package games;

import cards.*;
import players.CException;
import players.DCPlayerException;
import players.Player;
import java.util.List;

public class GameRound extends GamePart {

    private int numRound;

    private int numTricks;

    private Color triumph;

    public GameRound(List<Player> players, CardHolder mainDeck, int numRound) {
        super(players, mainDeck);
        this.numRound = numRound;
        this.numTricks = 0;
    }

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
        sendText("Las puntaciones se ven asi...\n");
        for (Player player : this.getPlayers()) {
            sendText("El jugador " + player.getName() + " tiene " + player.getScore() + " puntos\n");
        }
    }

    private void dealCards() {
        for (int i = 0; i < numRound; i++) {
            for (Player player : this.getPlayers()) {
                Card card = this.getDeck().getCard(0);
                player.addCard(card);
            }
        }
    }

    private void defineTriumph() throws DCPlayerException {
        if (!this.getDeck().isEmpty()) {
            Card card = this.getDeck().getCard(0);
            Color triumph1 = card.getColor();
            switch (triumph1.getMerit()) {
                case 5:
                    if (card.getValue().getValue() == 0) {
                        sendText("El palo de triunfo es " + triumph1);
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

    private int validateTriumph(Player player) throws DCPlayerException {
        sendText(player,
                "Escribe el numero del palo de triunfo \n 1 para \u001B[91mrojo\u001B[0m \n 2 para \u001B[94mazul\u001B[0m \n 3 para \u001B[93mamarillo\u001B[0m \n 4 para \u001B[92mverde\u001B[0m (presiona \"h\" para ver todo el historial del juego)");
        return player.getTriumph();
    }

    private void setBets() throws DCPlayerException {
        for (Player player : this.getPlayers()) {
            sendText(player, "Jugador " + player.getName() + " es tu turno de ver tus cartas.");
            sendText(player, "\nEl palo de triunfo es " + triumph + "\n");
            int bet = askBet(player);
            player.setBet(bet);
            sendText("El jugador " + player.getName() + " ha apostado " + bet);
        }
    }

    private int askBet(Player player) throws DCPlayerException {
        try {
            player.setDeck(player.getDeck());
        } catch (CException ce) {
            throw new DCPlayerException("No se pudo pasar cartas al jugador");
        }
        return player.askBet(numRound);
    }
    
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
