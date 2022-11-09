package player;

import cards.*;
import view.*;

public interface Player {
    
    public String getName();
    
    public CardHolder getDeck();
    
    public void setDeck(CardHolder deck);
    
    public int getScore();
    
    public void setScore(int i);
    
    public int getBet();
    
    public void setBet(int i);
    
    public int getWins();
    
    public void setWins(int i);

    public int getContinue();

    public void addCard(Card card);

    public Card giveCard(int i);

    public void showText(String message);

    public String showDeck();

    public void setView(View view);

}
