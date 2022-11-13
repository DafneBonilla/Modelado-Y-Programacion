package games;

import cards.*;
import players.CException;
import players.DCPlayerException;
import players.Player;
import java.util.List;

public class GameTrick extends GamePart {

    private Color triumph;

    private Color leader;

    private List<Card> plays;

    public GameTrick(List<Player> players, CardHolder mainDeck, Color triumph) {
        super(players, mainDeck);
        this.triumph = triumph;
        this.leader = null;
        this.plays = null;
    }

    public void start() throws DCPlayerException {
        sendText("El truco va a empezar");
        for (Player player : this.getPlayers()) {
            sendText(player, "Jugador " + player.getName() + " es tu turno de jugar una carta");
            sendText(player, "El palo leader es " + leader);
            sendText(player, "El palo de triunfo es " + triumph);
            int index = validateCard(player);
            Card card = reciveCard(player, index);
            sendText("El jugador " + player.getName() + " jugo la carta " + card);
            defineLeader(card);
            plays.add(card);
        }
        int winner = winnerCard();
        Player player1 = getPlayers().get(winner);
        int wins = player1.getWins();
        player1.setWins(wins + 1);
        sendText("El jugador " + player1.getName() + " gana el truco");
        CardHolder deck = this.getDeck();
        for (Card card : plays) {
            deck.addCard(card);
        }
        adjustPlayers(winner);
    }

    private void defineLeader(Card card) throws DCPlayerException {
        if (leader.getMerit() == -1) {
            if (card.getColor().getMerit() == 5) {
                return;
            }
            leader = card.getColor();
            sendText("El palo lider es " + leader);
        }
    }

    private Card reciveCard(Player player, int i) {
        return player.giveCard(i);
    }

    private int validateCard(Player player) throws DCPlayerException {
        int i = -1;
        try {
            player.setDeck(player.getDeck());
        } catch (CException ce) {
            throw new DCPlayerException("No se pudo pasar cartas al jugador");
        }
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
        for (Card card1 : hand.getList()) {
            if (card1.getColor().equals(leader)) {
                return false;
            }
        }
        return true;
    }

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

    private int playWizard() {
        for (Card card1 : plays) {
            if (card1.getValue().getValue() == 14) {
                return plays.indexOf(card1);
            }
        }
        return -1;
    }

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

    private int playJoker() {
        for (Card card1 : plays) {
            if (card1.getValue().getValue() == 0) {
                return plays.indexOf(card1);
            }
        }
        return -1;
    }

    private void adjustPlayers(int i) {
        for (int j = 0; j < i; j++) {
            List<Player> players = this.getPlayers();
            Player adjust = players.get(0);
            players.remove(adjust);
            players.add(adjust);
        }
    }

}
