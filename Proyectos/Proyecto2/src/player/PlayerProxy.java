package player;

import cards.*;
import view.View;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
		return null;
	}

	@Override
	public CardHolder getDeck() {
		return null;
	}

	@Override
	public void setDeck(CardHolder deck) throws DCPlayerException {
		
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
