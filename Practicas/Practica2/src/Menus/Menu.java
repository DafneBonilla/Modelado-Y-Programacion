package Menus;

import Dishes.Dish;

/**
 * Interface to represent a menu
 */
public interface Menu {

    /**
     * Add a dish to the menu
     * 
     * @param dish the dish to add
     */
    public void add(Dish dish);

    /**
     * Remove a dish from the menu
     * 
     * @param dish the dish to remove
     */
    public void remove(Dish dish);

    /**
     * Returns an iterator of the menu
     * 
     * @return an iterator of the menu
     */
    public MenuIterator iterator();

}
