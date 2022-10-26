package walmart;

import clients.Observer;

/**
 * Interface to implement the Observer pattern
 */
public interface Subject {

    /**
     * Method to register an observer
     * 
     * @param o the observer to register
     */
    public void registerObserver(Observer o);

    /**
     * Method to remove an observer
     * 
     * @param o the observer to remove
     */
    public void removeObserver(Observer o);

    /**
     * Method to notify the observers
     */
    public void notifyObservers();

}
