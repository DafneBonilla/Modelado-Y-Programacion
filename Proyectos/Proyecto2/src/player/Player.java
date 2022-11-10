package player;

import view.*;
import cards.*;

public interface Player {
    
    public String getName() throws DCPlayerException;
    
    public CardHolder getDeck();
    
    public void setDeck(CardHolder deck) throws DCPlayerException, CException;
    
    public int getScore() throws DCPlayerException;
    
    public void setScore(int i) throws DCPlayerException;
    
    public int getBet() throws DCPlayerException;
    
    public void setBet(int i) throws DCPlayerException;
    
    public int getWins() throws DCPlayerException;
    
    public void setWins(int i) throws DCPlayerException;

    public int getTriumph() throws DCPlayerException;

    public int getContinue() throws DCPlayerException;

    public void addCard(Card card);

    public Card giveCard(int i);

    public void showText(String message) throws DCPlayerException;

    public String read() throws DCPlayerException, CException;

    public void setView(View view);

    public int askCard() throws DCPlayerException;

    public void end() throws DCPlayerException;

}
