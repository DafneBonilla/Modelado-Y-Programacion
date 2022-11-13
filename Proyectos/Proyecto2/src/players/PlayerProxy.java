package players;

import cards.*;
import views.View;

import java.net.Socket;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;

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
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(deck);
			oos.flush();
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
		try {
			BufferedWriter writter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			writter.write(Message.ASK_BET.toString());
			writter.newLine();
			writter.write(numRound);
			writter.newLine();
			writter.flush();
		} catch (Exception e) {
			throw new DCPlayerException("Error sending message to player");
		}
		int bet = 0;
		try {
			bet = Integer.parseInt(read());
		} catch (DCPlayerException e) {
			throw new DCPlayerException("Error reading message from player");
		} catch (CException e) {
			return bet;
		}
		return bet;
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
		try {
			BufferedWriter writter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			writter.write(Message.GET_TRIUMPH.toString());
			writter.newLine();
			writter.flush();
		} catch (Exception e) {
			throw new DCPlayerException("Error sending message to player");
		}
		int triumph = 0;
		try {
			triumph = Integer.parseInt(read());
		} catch (DCPlayerException e) {
			throw new DCPlayerException("Error reading message from player");
		} catch (CException e) {
			return triumph;
		}
		return triumph;
	}

	@Override
	public int getContinue() throws DCPlayerException {
		try {
			BufferedWriter writter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			writter.write(Message.GET_CONTINUE.toString());
			writter.newLine();
			writter.flush();
		} catch (Exception e) {
			throw new DCPlayerException("Error sending message to player");
		}
		int cont = 0;
		try {
			cont = Integer.parseInt(read());
		} catch (DCPlayerException e) {
			throw new DCPlayerException("Error reading message from player");
		} catch (CException e) {
			return cont;
		}
		return cont;
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
		try {
			BufferedWriter writter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			writter.write(Message.SHOW_TEXT.toString());
			writter.newLine();
			writter.write(message);
			writter.newLine();
			writter.flush();
		} catch (Exception e) {
			throw new DCPlayerException("Error sending message to player");
		}
	}

	@Override
	public String read() throws DCPlayerException, CException {
		try {
			BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(socket.getInputStream()));
			boolean invalid = true;
			String message = "";
			while (invalid) {
				message = reader.readLine();
				if (message != null || message != "") {
					invalid = false;
				}
			}
			return message;
		} catch (Exception e) {
			throw new DCPlayerException("Error reading message from player");
		}
	}

	@Override
	public void setView(View view) {
	}

	@Override
	public int askCard() throws DCPlayerException {
		try {
			BufferedWriter writter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			writter.write(Message.ASK_CARD.toString());
			writter.newLine();
			writter.flush();
		} catch (Exception e) {
			throw new DCPlayerException("Error sending message to player");
		}
		int card = 0;
		try {
			card = Integer.parseInt(read());
		} catch (DCPlayerException e) {
			throw new DCPlayerException("Error reading message from player");
		} catch (CException e) {
			return card;
		}
		return card;
	}

	@Override
	public void end() throws DCPlayerException {
		try {
			BufferedWriter writter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			writter.write(Message.END.toString());
			writter.newLine();
			writter.flush();
		} catch (Exception e) {
			throw new DCPlayerException("Error sending message to player");
		}
	}

}
