package player;

import cards.*;
import view.*;

public interface Player {
    
    public String getName() throws DCPlayerException;
    
    public CardHolder getDeck();
    
    public void setDeck(CardHolder deck) throws DCPlayerException;
    
    public int getScore() throws DCPlayerException;
    
    public void setScore(int i) throws DCPlayerException;
    
    public int getBet() throws DCPlayerException;
    
    public void setBet(int i) throws DCPlayerException;
    
    public int getWins() throws DCPlayerException;
    
    public void setWins(int i) throws DCPlayerException;

    public int getContinue() throws DCPlayerException;

    public void addCard(Card card);

    public Card giveCard(int i);

    public String showDeck();

    public void showText(String message) throws DCPlayerException;

    public String read() throws DCPlayerException;

    public void setView(View view);

    public String askCard() throws DCPlayerException;

}
