/**
 * Interface to implement the Observer pattern
 */
public interface Subject {

    /**
     * Registers an observer to the ring
     * 
     * @param o the observer to be registered
     */
    public void registerObserver(Observer o);

    /**
     * Removes an observer from the ring
     * 
     * @param o the observer to be removed
     */
    public void removeObserver(Observer o);

    /**
     * Notifies the observers of the subject
     */
    public void notifyObserver();

}
