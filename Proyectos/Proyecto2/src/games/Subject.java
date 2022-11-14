package games;

import players.DCPlayerException;
import players.Observer;

public interface Subject {

    public void sendText(String text) throws DCPlayerException;

    public void registerObserver(Observer o);

    public void removeObserver(Observer o);
    
}
