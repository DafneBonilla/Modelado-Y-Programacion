package players;

import cards.*;
import views.*;

public interface Player extends Observer {

    public String getName() throws DCPlayerException;

    public CardHolder getDeck();

    public void setDeck(CardHolder deck) throws DCPlayerException;

    public int getScore();

    public void setScore(int i);

    public int getBet();

    public void setBet(int i);

    public int askBet(int numRound) throws DCPlayerException;

    public int getWins();

    public void setWins(int i);

    public int getTriumph() throws DCPlayerException;

    public int getContinue() throws DCPlayerException;

    public void addCard(Card card);

    public Card giveCard(int i);

    @Override
    public void showText(String message) throws DCPlayerException;

    public String read() throws DCPlayerException;

    public void setView(View view);

    public int askCard() throws DCPlayerException;

    public void end() throws DCPlayerException;

}
