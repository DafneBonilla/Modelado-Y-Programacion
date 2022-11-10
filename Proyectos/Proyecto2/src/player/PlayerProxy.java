package player;

import cards.*;
import view.View;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class PlayerProxy implements Player {

	private CardHolder deck;

	private Socket socket;

	private int score;

	private int bet;

	private int wins;

	public PlayerProxy(Socket socket) {
		this.deck = null;
		this.socket = socket;
		this.score = 0;
		this.bet = 0;
		this.wins = 0;
	}

	@Override
	public String getName() throws DCPlayerException {
		try {
			BufferedWriter writter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			writter.write(Message.GET_NAME.toString());
			writter.newLine();
			writter.flush();
		} catch (Exception e) {
			throw new DCPlayerException("Error sending message to player");
		}
		String name = "";
		try {
			name = read();
		} catch (DCPlayerException e) {
			throw new DCPlayerException("Error reading message from player");
		} catch (CException e) {
			return name;
		}
		return name;
	}

	@Override
	public CardHolder getDeck() {
		return deck;
	}

	@Override
	public void setDeck(CardHolder deck) throws DCPlayerException, CException {
		this.deck = deck;
		try {
		} catch (Exception e) {
			throw new DCPlayerException("Error sending message to player");
		}
	}

	@Override
	public int getScore() {
		return score;
	}

	@Override
	public void setScore(int i) {
		this.score = i;
	}

	@Override
	public int getBet() {
		return bet;
	}

	@Override
	public void setBet(int i) {
		this.bet = i;
	}

	@Override
	public int askBet(int numRound) throws DCPlayerException {

	}

	@Override
	public int getWins() {
		return wins;
	}

	@Override
	public void setWins(int i) {
		this.wins = i;
	}

	@Override
	public int getTriumph() throws DCPlayerException {

	}

	@Override
	public int getContinue() throws DCPlayerException {

	}

	@Override
	public void addCard(Card card) {
		deck.addCard(card);
	}

	@Override
	public Card giveCard(int i) {
		return deck.getCard(i);
	}

	@Override
	public void showText(String message) throws DCPlayerException {
		// TODO Auto-generated method stub
	}

	@Override
	public String read() throws DCPlayerException, CException {

	}

	@Override
	public void setView(View view) {
	}

	@Override
	public int askCard() throws DCPlayerException {

	}

	@Override
	public void end() throws DCPlayerException {
		// TODO Auto-generated method stub
	}

}
