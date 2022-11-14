package players;

import cards.*;
import views.View;
import java.net.Socket;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PlayerClient implements Player {

	private String name;

	private String deckString;

	private int numCards;

	private Socket socket;

	private View view;

	private boolean active;

	private BufferedReader reader;

	private BufferedWriter writer;

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

	@Override
	public CardHolder getDeck() {
		return null;
	}

	@Override
	public void setDeck(CardHolder deck) throws DCPlayerException {
		try {
			deckString = reader.readLine();
			numCards = readNumber();
		} catch (IOException ioe) {
			throw new DCPlayerException("Error setting deck");
		}
	}

	@Override
	public int getScore() {
		return 0;
	}

	@Override
	public void setScore(int i) {
	}

	@Override
	public int getBet() {
		return 0;
	}

	@Override
	public void setBet(int i) {
	}

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
		return 0;
	}

	@Override
	public void setWins(int i) {
	}

	@Override
	public int getTriumph() throws DCPlayerException {
		int answer = 0;
		while (true) {
			answer = view.askInt("Escribe el numero del palo de triunfo 1 - Rojo, 2 - Azul, 3 - Amarillo, 4 - Verde");
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

	@Override
	public void addCard(Card card) {
	}

	@Override
	public Card giveCard(int i) {
		return null;
	}

	@Override
	public void showText(String message) throws DCPlayerException {
		try {
			String line = reader.readLine();
			this.view.showText(line);
		} catch (IOException ioe) {
			throw new DCPlayerException("Error showing text");
		}
	}

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
		return "end";
	}

	private void manageMessage(Message message) throws DCPlayerException {
		switch (message) {
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

	@Override
	public void setView(View view) {
		this.view = view;
	}

	@Override
	public int askCard() throws DCPlayerException {
		view.showText("Tu mano es: \n" + deckString);
		String question = "Ingresa el numero de la carta que quieres jugar\n";
		int answer = -1;
		while (true) {
			answer = view.askInt(question);
			if (answer >= 0 && answer < numCards + 1) {
				break;
			}
			view.showText("Respuesta invalida, el numero debe ser entre 0 y " + numCards);
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

	@Override
	public void end() throws DCPlayerException {
		this.active = false;
		try {
			socket.close();
		} catch (IOException e) {
			view.showText("Hubo un error cerrando la conexion");
			System.exit(0);
		}
	}

}
