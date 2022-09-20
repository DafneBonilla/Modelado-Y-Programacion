package Menus;

import java.util.ArrayList;
import java.util.Iterator;
import Dishes.Dish;

/**
 * Class to represent the daily menu
 * A daily menu is a menu that has a name, a number of dishes and a list of
 * dishes
 */
public class DailyMenu implements Menu {

    /**
     * Class of the daily menu iterator
     */
    private class DailyMenuIterator implements MenuIterator {

        /* The iterator of the list of dishes */
        private Iterator<Dish> iterator;

        /**
         * Constructor of the daily menu iterator
         */
        private DailyMenuIterator() {
            iterator = dishes.iterator();
        }

        /**
         * Returns true if the iteration has more elements
         * 
         * @return true if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        /**
         * Returns the next dish in the iteration
         * 
         * @return the next dish in the iteration
         */
        @Override
        public Dish next() {
            return iterator.next();
        }

        /**
         * Removes from the underlying collection the last element returned by this
         * iterator
         * Not implemented in most of our iterators
         */
        @Override
        public void remove() {
            iterator.remove();
        }

        /**
         * Restarts the iterator
         */
        @Override
        public void restart() {
            iterator = dishes.iterator();
        }

        /**
         * Returns the name of the menu the iterator is iterating
         * 
         * @return the namein of the menu the iterator is iterating
         */
        @Override
        public String getName() {
            return name;
        }

    }

    /* The list of dishes */
    private ArrayList<Dish> dishes;

    /* The number of dishes */
    private int numberOfDishes;

    /* The name of the menu */
    private String name;

    /**
     * Constructor of the daily menu
     */
    public DailyMenu() {
        this.name = "Menu del dia";
        dishes = new ArrayList<Dish>();
        numberOfDishes = dishes.size();
        dishes.add(new Dishes.CanekHamburger());
        dishes.add(new Dishes.MushroomHamburger());
        dishes.add(new Dishes.MasterChiefHamburger());
    }

    /**
     * Add a dish to the menu
     * 
     * @param dish the dish to add
     */
    @Override
    public void add(Dish dish) {
        dishes.add(dish);
        numberOfDishes = dishes.size();
    }

    /**
     * Remove a dish from the menu
     * 
     * @param dish the dish to remove
     */
    @Override
    public void remove(Dish dish) {
        dishes.remove(dish);
        numberOfDishes = dishes.size();
    }

    /**
     * Returns the number of dishes in the menu
     * 
     * @return the number of dishes in the menu
     */
    public int getNumberOfDishes() {
        return numberOfDishes;
    }

    /**
     * Returns an iterator of the menu
     * 
     * @return an iterator of the menu
     */
    @Override
    public MenuIterator iterator() {
        return new DailyMenuIterator();
    }

}
