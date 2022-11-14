package players;

import cards.*;
import views.View;
import java.net.Socket;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PlayerProxy implements Player {

	private CardHolder deck;

	private Socket socket;

	private int score;

	private int bet;

	private int wins;

	private BufferedWriter writer;

	private BufferedReader reader;

	public PlayerProxy(Socket socket) throws IOException {
		this.deck = new Deck();
		this.socket = socket;
		this.score = 0;
		this.bet = 0;
		this.wins = 0;
		if (socket != null) {
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		}
	}

	@Override
	public String getName() throws DCPlayerException {
		try {
			writer.write(Message.GET_NAME.toString());
			writer.newLine();
			writer.flush();
		} catch (IOException ioe) {
			throw new DCPlayerException("Error sending message to player");
		}
		String name = "";
		try {
			name = read();
		} catch (DCPlayerException dcpe) {
			throw new DCPlayerException("Error reading message from player");
		}
		return name;
	}

	@Override
	public CardHolder getDeck() {
		return deck;
	}

	@Override
	public void setDeck(CardHolder deck) throws DCPlayerException {
		this.deck = deck;
		String deckString = "";
		int i = 0;
		CardHolderIterator it = this.deck.getIterator();
		while (it.hasNext()) {
			Card card = it.next();
			deckString += "[" + i + "] " + " " + card.toString() + "\n";
			i++;
		}
		try {
			writer.write(Message.SET_DECK.toString());
			writer.newLine();
			writer.write(deckString);
			writer.write(Integer.toString(i-1));
			writer.newLine();
			writer.flush();
		} catch (IOException ioe) {
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
			writer.write(Message.ASK_BET.toString());
			writer.newLine();
			writer.write(Integer.toString(numRound));
			writer.newLine();
			writer.flush();
		} catch (IOException ioe) {
			throw new DCPlayerException("Error sending message to player");
		}
		int bet = 0;
		bet = readNumber();
		return bet;
	}

	private int readNumber() throws DCPlayerException {
		try {
			String line = reader.readLine();
			return Integer.parseInt(line);
		} catch (IOException ioe) {
			throw new DCPlayerException("Error reading round");
		} catch (NumberFormatException nfe) {
			throw new DCPlayerException("Error reading round");
		}
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
			writer.write(Message.GET_TRIUMPH.toString());
			writer.newLine();
			writer.flush();
		} catch (IOException e) {
			throw new DCPlayerException("Error sending message to player");
		}
		int triumph = 0;
		triumph = readNumber();
		return triumph;
	}

	@Override
	public int getContinue() throws DCPlayerException {
		try {
			writer.write(Message.GET_CONTINUE.toString());
			writer.newLine();
			writer.flush();
		} catch (IOException e) {
			throw new DCPlayerException("Error sending message to player");
		}
		int cont = 0;
		cont = readNumber();
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
			writer.write(Message.SHOW_TEXT.toString());
			writer.newLine();
			writer.write(message);
			writer.newLine();
			writer.flush();
		} catch (IOException ioe) {
			throw new DCPlayerException("Error sending message to player");
		}
	}

	@Override
	public String read() throws DCPlayerException {
		try {
			boolean invalid = true;
			String message = "";
			while (invalid) {
				message = reader.readLine();
				if (message != null || message != "") {
					invalid = false;
				}
			}
			return message;
		} catch (IOException ioe) {
			throw new DCPlayerException("Error reading message from player");
		}
	}

	@Override
	public void setView(View view) {
	}

	@Override
	public int askCard() throws DCPlayerException {
		try {
			writer.write(Message.ASK_CARD.toString());
			writer.newLine();
			writer.flush();
		} catch (IOException e) {
			throw new DCPlayerException("Error sending message to player");
		}
		int card = 0;
		card = readNumber();
		return card;
	}

	@Override
	public void end() throws DCPlayerException {
		try {
			writer.write(Message.END.toString());
			writer.newLine();
			writer.flush();
			} catch (IOException ioe) {
				throw new DCPlayerException("Error sending message to player");
			}
		try {
			socket.close();
		} catch (IOException ioe) {
		}
	}

}
