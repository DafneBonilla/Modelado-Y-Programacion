package player;

import cards.*;
import view.View;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.net.Socket;

public class PlayerClient implements Player {

	private String name;

	private CardHolderIterator deck;

	private Socket socket;

	private View view;

	private boolean active;

	public PlayerClient(String name, Socket socket) {
		this.name = name;
		this.socket = socket;
		this.deck = null;
		this.socket = socket;
		this.view = null;
		this.active = true;
	}

	@Override
	public String getName() throws DCPlayerException {
		try {
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			writer.write(name);
			writer.newLine();
			writer.flush();
			return name;
		} catch (IOException e) {
			throw new DCPlayerException("Error getting name");
		}
	}

	@Override
	public CardHolder getDeck() {
		return null;
	}

	@Override
	public void setDeck(CardHolder deck) throws DCPlayerException, CException {
		try {
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			this.deck = (CardHolderIterator) ois.readObject();
		} catch (IOException e) {
			throw new DCPlayerException("Error setting deck");
		} catch (ClassNotFoundException e) {
			throw new CException("Error setting deck");
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
		int numRound2 = readRound();
		String cards = showDeck();
		view.showText("Tu mano es: \n" + cards);
		String question = "Define tu apuesta (numero entre 0 y " + numRound2 + ")";
		int answer = -1;
		while (true) {
			answer = view.askInt(question);
			if (answer >= 0 && answer <= numRound2) {
				break;
			}
			view.showText("Respuesta invalida, el numero debe ser entre 0 y " + numRound2);
			view.showText("Tu mano es: \n" + cards);
		}
		try {
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			writer.write(answer);
			writer.newLine();
			writer.flush();
		} catch (IOException e) {
			throw new DCPlayerException("Error getting bet");
		}
		return answer;
	}

	private int readRound() throws DCPlayerException {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			return Integer.parseInt(reader.readLine());
		} catch (IOException e) {
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
		int answer = -1;
		while (true) {
			answer = view.askInt("Escribe el numero del palo de triunfo 1 - Rojo, 2 - Azul, 3 - Amarillo, 4 - Verde");
			if (answer >= 1 && answer <= 4) {
				break;
			}
			view.showText("Respuesta invalida, el numero debe ser entre 1 y 4");
		}
		try {
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			writer.write(answer);
			writer.newLine();
			writer.flush();
		} catch (IOException e) {
			throw new DCPlayerException("Error getting triumph");
		}
		return answer;
	}

	@Override
	public int getContinue() throws DCPlayerException {
		int answer = -1;
		while (true) {
			answer = view.askInt("Se votara para continuar o no. 0 para continuar, 1 para no continuar");
			if (answer == 0 || answer == 1) {
				break;
			}
			view.showText("Respuesta invalida, elija 0 o 1");
		}
		try {
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			writer.write(answer);
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
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String line = reader.readLine();
			this.view.showText(line);
		} catch (IOException e) {
			throw new DCPlayerException("Error showing text");
		}
	}

	@Override
	public String read() throws DCPlayerException, CException {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while (active) {
				String line = reader.readLine();
				if (line != null) {
					manageMessage(Message.getMessage(line));
				}
			}
		} catch (IOException e) {
			throw new DCPlayerException("Error reading");
		}
		view.showText("Gracias por jugar");
		return "end";
	}

	private void manageMessage(Message message) throws DCPlayerException, CException {
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
		String cards = showDeck();
		view.showText("Tu mano es: \n" + cards);
		String question = "Ingresa el numero de la carta que quieres jugar\n";
		int answer = -1;
		while (true) {
			answer = view.askInt(question);
			if (answer >= 0 && answer < deck.size()) {
				break;
			}
			view.showText("Respuesta invalida, el numero debe ser entre 0 y " + (deck.size() - 1));
			view.showText("Tu mano es: \n" + cards);
		}
		try {
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			writer.write(answer);
			writer.newLine();
			writer.flush();
		} catch (IOException e) {
			throw new DCPlayerException("Error asking card");
		}
		return answer;
	}

	private String showDeck() {
		int i = 0;
		String cards = "";
		while (deck.hasNext()) {
			Card card = deck.next();
			cards += "[" + i + "] " + " " + card.toString() + "\n";
			i++;
		}
		return cards;
	}

	@Override
	public void end() throws DCPlayerException {
		this.active = false;
		try {
			socket.close();
		} catch (IOException e) {
			throw new DCPlayerException("Error ending");
		}
	}

}
