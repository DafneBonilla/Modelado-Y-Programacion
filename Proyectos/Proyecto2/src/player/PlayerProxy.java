package player;

import cards.*;
import view.View;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class PlayerProxy implements Player {

    private CardHolder deck;

    private Socket socket;

    public PlayerProxy(Socket socket) {
        this.deck = null;
        this.socket = socket;
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
	public void setDeck(CardHolder deck) throws DCPlayerException, CException{
		this.deck = deck;
		try {
		} catch (Exception e) {
			throw new DCPlayerException("Error sending message to player");
		}
	}

	@Override
	public int getScore() throws DCPlayerException {
		return 0;
	}

	@Override
	public void setScore(int i) throws DCPlayerException {
		
	}

	@Override
	public int getBet() throws DCPlayerException {
		return 0;
	}

	@Override
	public void setBet(int i) throws DCPlayerException {
		
	}

	@Override
	public int getWins() throws DCPlayerException {
		return 0;
	}

	@Override
	public void setWins(int i) throws DCPlayerException {
		
	}

	@Override
	public int getContinue() throws DCPlayerException {
		return 0;
	}

	@Override
	public int getTriumph() throws DCPlayerException {
		return 0;
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
		
	}

	@Override
	public String read() throws DCPlayerException, CException {
		return null;
	}

	@Override
	public void setView(View view) {
		
	}

	@Override
	public int askCard() throws DCPlayerException {
		return 0;
	}

	@Override
	public void end() throws DCPlayerException {
		
	}

}
