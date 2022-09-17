package Menus;

import Dishes.Dish;

/**
 * Interface for the menu iterator
 */
public interface MenuIterator {

    /**
     * Returns true if the iteration has more elements
     * 
     * @return true if the iteration has more elements
     */
    public boolean hasNext();

    /**
     * Returns the next dish in the iteration
     * 
     * @return the next dish in the iteration
     */
    public Dish next();

    /**
     * Removes from the underlying collection the last element returned by this
     * iterator
     * Not implemented in most of our iterators
     */
    public void remove();

    /**
     * Restarts the iterator
     */
    public void restart();

    /**
     * Returns the name of the menu the iterator is iterating
     * 
     * @return the namein of the menu the iterator is iterating
     */
    public String getName();

}
