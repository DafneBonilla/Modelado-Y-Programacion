package player;

import cards.*;
import view.View;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class PlayerClient implements Player {
    
    private String name;

    private CardHolderIterator deck;

    private int score;

    private int bet;

    private int wins;

    private Socket socket;

    private View view;

    public PlayerClient(String name, Socket socket) {
        this.name = name;
        this.socket = socket;
        this.deck = null;
        this.score = 0;
        this.bet = 0;
        this.wins = 0;
        this.socket = socket;
        this.view = null;
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
	public void setDeck(CardHolder deck) throws DCPlayerException {
		try {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            this.deck = (CardHolderIterator) ois.readObject();
        } catch (IOException e) {
            throw new DCPlayerException("Error setting deck");
        } catch (ClassNotFoundException e) {
            throw new DCPlayerException("Error with class deck");
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
	public void addCard(Card card) {
		
	}

	@Override
	public Card giveCard(int i) {
		return null;
	}

	@Override
	public String showDeck() {
		return null;
	}

	@Override
	public void showText(String message) throws DCPlayerException {
		
	}

	@Override
	public String read() throws DCPlayerException {
		return null;
	}

	@Override
	public void setView(View view) {
		
	}

	@Override
	public String askCard() throws DCPlayerException {
		return null;
	}
    
}
