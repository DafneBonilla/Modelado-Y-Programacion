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

    private int score;

    private int bet;

    private int wins;

    private Socket socket;

    private View view;

	private boolean active;

    public PlayerClient(String name, Socket socket) {
        this.name = name;
        this.socket = socket;
        this.deck = null;
        this.score = 0;
        this.bet = 0;
        this.wins = 0;
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
	public int getScore() throws DCPlayerException {
		try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            writer.write(score);
            writer.newLine();
            writer.flush();
            return score;
        } catch (IOException e) {
            throw new DCPlayerException("Error getting score");
        }
	}

	@Override
	public void setScore(int i) throws DCPlayerException {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String line = reader.readLine();
			this.score = Integer.parseInt(line);
		} catch (IOException e) {
			throw new DCPlayerException("Error setting score");
		}
	}

	@Override
	public int getBet() throws DCPlayerException {
		try {
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			writer.write(bet);
			writer.newLine();
			writer.flush();
			return bet;
		} catch (IOException e) {
			throw new DCPlayerException("Error getting bet");
		}
	}

	@Override
	public void setBet(int i) throws DCPlayerException {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String line = reader.readLine();
			this.bet = Integer.parseInt(line);
		} catch (IOException e) {
			throw new DCPlayerException("Error setting bet");
		}
	}

	@Override
	public int getWins() throws DCPlayerException {
		try {
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			writer.write(wins);
			writer.newLine();
			writer.flush();
			return wins;
		} catch (IOException e) {
			throw new DCPlayerException("Error getting wins");
		}
	}

	@Override
	public void setWins(int i) throws DCPlayerException {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String line = reader.readLine();
			this.wins = Integer.parseInt(line);
		} catch (IOException e) {
			throw new DCPlayerException("Error setting wins");
		}
	}

	@Override
	public int getTriumph() throws DCPlayerException {
		// TODO Auto-generated method stub
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
			case GET_SCORE:
				getScore();
				break;
			case SET_SCORE:
				setScore(0);
				break;
			case GET_BET:
				getBet();
				break;
			case SET_BET:
				setBet(0);
				break;
			case GET_WINS:
				getWins();
				break;
			case SET_WINS:
				setWins(0);
				break;
			case GET_CONTINUE:
				getContinue();
				break;
			case ASK_CARD:
				askCard();
				break;
			case SHOW_TEXT:
				showText("");
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
