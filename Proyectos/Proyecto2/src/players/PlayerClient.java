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
 * Class to represent a player client
 * A player client has a name, a deck (as a string), a number of cards, a
 * socket, a view (instance of {@link View}), a boolean to indicate if the
 * player is active, a BufferedReader and a BufferedWriter
 */
public class PlayerClient implements Player {

	/* The name of the player */
	private String name;

	/* The deck of the player */
	private String deckString;

	/* The number of cards in the deck */
	private int numCards;

	/* The socket of the player */
	private Socket socket;

	/* The view of the player */
	private View view;

	/* Indicates if the player is active */
	private boolean active;

	/* The BufferedReader of the player */
	private BufferedReader reader;

	/* The BufferedWriter of the player */
	private BufferedWriter writer;

	/**
	 * Constructor
	 * 
	 * @param name   the name of the player
	 * @param socket the socket of the player
	 * @throws IOException if an I/O error occurs when creating the reader or writer
	 */
	public PlayerClient(String name, Socket socket) throws IOException {
		this.name = name;
		this.socket = socket;
		this.deckString = "no hay cartas";
		this.numCards = 0;
		this.view = null;
		this.active = true;
		if (socket != null) {
			this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			this.writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		}
	}

	/**
	 * Updates the player if the game has started
	 */
	@Override
	public void startUpdate() {
		if (this.view != null) {
			this.view.startUpdate();
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
		try {
			writer.write(name);
			writer.newLine();
			writer.flush();
			return name;
		} catch (IOException ioe) {
			throw new DCPlayerException("Error getting name");
		}
	}

	/**
	 * Returns the card holder of the player
	 * 
	 * @return the card holder
	 */
	@Override
	public CardHolder getDeck() {
		return null;
	}

	/**
	 * Sets the card holder of the player
	 * 
	 * @param deck the card holder
	 * @throws DCPlayerException if a communication error occurs
	 */
	@Override
	public void setDeck(CardHolder deck) throws DCPlayerException {
		try {
			numCards = readNumber();
			deckString = "";
			for (int i = 0; i < numCards; i++) {
				if (i == numCards - 1) {
					deckString = deckString + reader.readLine();
				} else {
					deckString = deckString + reader.readLine() + "\n";
				}
			}
		} catch (IOException ioe) {
			throw new DCPlayerException("Error setting deck");
		}
	}

	/**
	 * Returns the score of the player
	 * 
	 * @return the score
	 */
	@Override
	public int getScore() {
		return 0;
	}

	/**
	 * Sets the score of the player
	 * 
	 * @param i the score
	 */
	@Override
	public void setScore(int i) {
	}

	/**
	 * Returns the bet of the player
	 * 
	 * @return the bet
	 */
	@Override
	public int getBet() {
		return 0;
	}

	/**
	 * Sets the bet of the player
	 * 
	 * @param i the bet
	 */
	@Override
	public void setBet(int i) {
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
		int numRound2 = readNumber();
		view.showText("Tu mano es: \n" + deckString);
		String question = "Define tu apuesta (numero entre 0 y " + numRound2 + ")";
		int answer = 0;
		while (true) {
			answer = view.askInt(question);
			if (answer >= 0 && answer <= numRound2) {
				break;
			}
			view.showText("Respuesta invalida, el numero debe ser entre 0 y " + numRound2);
			view.showText("Tu mano es: \n" + deckString);
		}
		try {
			writer.write(Integer.toString(answer));
			writer.newLine();
			writer.flush();
		} catch (IOException ioe) {
			throw new DCPlayerException("Error getting bet");
		}
		return answer;
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
		return 0;
	}

	/**
	 * Sets the number of trick won by the player
	 * 
	 * @param i the number of trick won
	 */
	@Override
	public void setWins(int i) {
	}

	/**
	 * Asks the player for an integer to use as the color of the trump
	 * 
	 * @return the color of the trump
	 * @throws DCPlayerException if a communication error occurs
	 */
	@Override
	public int getTriumph() throws DCPlayerException {
		int answer = 0;
		while (true) {
			answer = view.askInt(
					"Escribe el numero del palo de triunfo \n 1 para \u001B[91mrojo\u001B[0m \n 2 para \u001B[94mazul\u001B[0m \n 3 para \u001B[93mamarillo\u001B[0m \n 4 para \u001B[92mverde\u001B[0m");
			if (answer >= 1 && answer <= 4) {
				break;
			}
			view.showText("Respuesta invalida, el numero debe ser entre 1 y 4");
		}
		try {
			writer.write(Integer.toString(answer));
			writer.newLine();
			writer.flush();
		} catch (IOException e) {
			throw new DCPlayerException("Error getting triumph");
		}
		return answer;
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
		int answer = 0;
		while (true) {
			answer = view.askInt("Se votara para continuar o no. 0 para continuar, 1 para no continuar");
			if (answer == 0 || answer == 1) {
				break;
			}
			view.showText("Respuesta invalida, elija 0 o 1");
		}
		try {
			writer.write(Integer.toString(answer));
			writer.newLine();
			writer.flush();
		} catch (IOException e) {
			throw new DCPlayerException("Error getting continue");
		}
		return answer;
	}

	/**
	 * Adds a card to the players card holder
	 * 
	 * @param card the card to add
	 */
	@Override
	public void addCard(Card card) {
	}

	/**
	 * Returns the card in the players card holder at the given index
	 * 
	 * @param i the index
	 * @return the card
	 */
	@Override
	public Card giveCard(int i) {
		return null;
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
			String line = reader.readLine();
			this.view.showText(line);
		} catch (IOException ioe) {
			throw new DCPlayerException("Error showing text");
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
			while (active) {
				String line = reader.readLine();
				if (line != null) {
					manageMessage(Message.getMessage(line));
				}
			}
		} catch (IOException ioe) {
			throw new DCPlayerException("Error reading");
		}
		view.showText("Gracias por jugar");
		view.startUpdate();
		return "end";
	}

	/**
	 * Manages the message received from the connection
	 * 
	 * @param message the message
	 * @throws DCPlayerException if a communication error occurs
	 */
	private void manageMessage(Message message) throws DCPlayerException {
		switch (message) {
			case START:
				startUpdate();
				break;
			case GET_NAME:
				getName();
				break;
			case SET_DECK:
				setDeck(null);
				break;
			case ASK_BET:
				askBet(0);
				break;
			case GET_TRIUMPH:
				getTriumph();
				break;
			case GET_CONTINUE:
				getContinue();
				break;
			case SHOW_TEXT:
				showText("");
				break;
			case ASK_CARD:
				askCard();
				break;
			case END:
				end();
				break;
			default:
				break;
		}
	}

	/**
	 * Sets the players view
	 * 
	 * @param view the view
	 */
	@Override
	public void setView(View view) {
		this.view = view;
	}

	/**
	 * Asks the player for a card to play
	 * 
	 * @return the card
	 * @throws DCPlayerException if a communication error occurs
	 */
	@Override
	public int askCard() throws DCPlayerException {
		view.showText("Tu mano es: \n" + deckString);
		String question = "Ingresa el numero de la carta que quieres jugar";
		int answer = -1;
		while (true) {
			answer = view.askInt(question);
			if (answer >= 0 && answer < numCards) {
				break;
			}
			view.showText("Respuesta invalida, el numero debe ser entre 0 y " + (numCards - 1));
			view.showText("Tu mano es: \n" + deckString);
		}
		try {
			writer.write(Integer.toString(answer));
			writer.newLine();
			writer.flush();
		} catch (IOException e) {
			throw new DCPlayerException("Error asking card");
		}
		return answer;
	}

	/**
	 * Ends the players connection
	 * 
	 * @throws DCPlayerException if a communication error occurs
	 */
	@Override
	public void end() throws DCPlayerException {
		this.active = false;
		try {
			socket.close();
		} catch (IOException e) {
		}
	}

}
