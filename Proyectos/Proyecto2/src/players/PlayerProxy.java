package players;

import cards.*;
import views.View;
import java.net.Socket;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Class to represent a player proxy
 * A player proxy has a name, a deck (instance of {@link CardHolder}), a socket,
 * a score, a bet, a number of tricks won, a BufferedReader and a BufferedWriter
 */
public class PlayerProxy implements Player {

	/* The name of the player */
	private String name;

	/* The deck of the player */
	private CardHolder deck;

	/* The socket of the player */
	private Socket socket;

	/* The score of the player */
	private int score;

	/* The bet of the player */
	private int bet;

	/* The number of tricks won by the player */
	private int wins;

	/* The BufferedReader of the player */
	private BufferedWriter writer;

	/* The BufferedWriter of the player */
	private BufferedReader reader;

	/**
	 * Constructor
	 * 
	 * @param socket the socket of the player
	 * @throws IOException if an I/O error occurs when creating the reader or writer
	 */
	public PlayerProxy(Socket socket) throws IOException {
		this.name = "";
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

	/**
	 * Updates the player if the game has started
	 * 
	 * @throws DCPlayerException if the player has an error
	 */
	@Override
	public void startUpdate() throws DCPlayerException {
		try {
			writer.write(Message.START.toString());
			writer.newLine();
			writer.flush();
		} catch (IOException e) {
			throw new DCPlayerException("Error sending start message to player");
		}
	}

	/**
	 * Returns the name of the player
	 * 
	 * @return the name of the player
	 * @throws DCPlayerException if a communication error occurs
	 */
	@Override
	public String getName() throws DCPlayerException {
		if (name != "") {
			return name;
		}
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
			this.name = name;
		} catch (DCPlayerException dcpe) {
			throw new DCPlayerException("Error reading message from player");
		}
		return name;
	}

	/**
	 * Returns the card holder of the player
	 * 
	 * @return the card holder
	 */
	@Override
	public CardHolder getDeck() {
		return deck;
	}

	/**
	 * Sets the card holder of the player
	 * 
	 * @param deck the card holder
	 * @throws DCPlayerException if a communication error occurs
	 */
	@Override
	public void setDeck(CardHolder deck) throws DCPlayerException {
		deck.sort();
		this.deck = deck;
		int i = deck.size();
		int y = 0;
		CardHolderIterator it = this.deck.getIterator();
		try {
			writer.write(Message.SET_DECK.toString());
			writer.newLine();
			writer.write(Integer.toString(i));
			writer.newLine();
			while (it.hasNext()) {
				Card card = it.next();
				writer.write("[" + y + "] " + " " + card.toString());
				writer.newLine();
				y++;
			}
			writer.flush();
		} catch (IOException ioe) {
			throw new DCPlayerException("Error sending message to player");
		}
	}

	/**
	 * Returns the score of the player
	 * 
	 * @return the score
	 */
	@Override
	public int getScore() {
		return score;
	}

	/**
	 * Sets the score of the player
	 * 
	 * @param i the score
	 */
	@Override
	public void setScore(int i) {
		this.score = i;
	}

	/**
	 * Returns the bet of the player
	 * 
	 * @return the bet
	 */
	@Override
	public int getBet() {
		return bet;
	}

	/**
	 * Sets the bet of the player
	 * 
	 * @param i the bet
	 */
	@Override
	public void setBet(int i) {
		this.bet = i;
	}

	/**
	 * Asks the player for a bet
	 * 
	 * @param numRound the number of the round
	 * @return the bet
	 * @throws DCPlayerException if a communication error occurs
	 */
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

	/**
	 * Reads and returns a number from the players BufferedReader
	 * 
	 * @return the number
	 * @throws DCPlayerException if a communication error occurs or the number is
	 *                           not a number
	 */
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

	/**
	 * Returns the number of trick won by the player
	 * 
	 * @return the number of trick won
	 */
	@Override
	public int getWins() {
		return wins;
	}

	/**
	 * Sets the number of trick won by the player
	 * 
	 * @param i the number of trick won
	 */
	@Override
	public void setWins(int i) {
		this.wins = i;
	}

	/**
	 * Asks the player for an integer to use as the color of the trump
	 * 
	 * @return the color of the trump
	 * @throws DCPlayerException if a communication error occurs
	 */
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

	/**
	 * Asks the player if he wants to continue
	 * 0 to continue, 1 to end
	 * 
	 * @return 0 if the player wants to continue, 1 if he wants to end
	 * @throws DCPlayerException if a communication error occurs
	 */
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

	/**
	 * Adds a card to the players card holder
	 * 
	 * @param card the card to add
	 */
	@Override
	public void addCard(Card card) {
		deck.addCard(card);
	}

	/**
	 * Returns the card in the players card holder at the given index
	 * 
	 * @param i the index
	 * @return the card
	 */
	@Override
	public Card giveCard(int i) {
		return deck.getCard(i);
	}

	/**
	 * Updates the observer on what happened and to show
	 * 
	 * @param message the text to show
	 * @throws DCPlayerException if a communication error occurs
	 */
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

	/**
	 * Reads a string from the connection
	 * 
	 * @return the string
	 * @throws DCPlayerException if a communication error occurs
	 */
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

	/**
	 * Sets the players view
	 * 
	 * @param view the view
	 */
	@Override
	public void setView(View view) {
	}

	/**
	 * Asks the player for a card to play
	 * 
	 * @return the card
	 * @throws DCPlayerException if a communication error occurs
	 */
	@Override
	public int askCard() throws DCPlayerException {
		try {
			writer.write(Message.ASK_CARD.toString());
			writer.newLine();
			writer.flush();
		} catch (IOException ioe) {
			throw new DCPlayerException("Error sending message to player");
		}
		int card = 0;
		card = readNumber();
		return card;
	}

	/**
	 * Ends the players connection
	 * 
	 * @throws DCPlayerException if a communication error occurs
	 */
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
