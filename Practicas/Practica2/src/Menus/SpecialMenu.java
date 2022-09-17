package Menus;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import Dishes.Dish;

/**
 * Class to represent the special menu
 * A special menu is a menu that has a name, a number of dishes and an hashtable
 * of dishes
 */
public class SpecialMenu implements Menu {

    /**
     * Class of the general menu iterator
     */
    private class SpecialMenuIterator implements MenuIterator {

        /* The set of keys of the hashtable */
        private Set<String> keys;

        /* The iterator of the set of keys */
        private Iterator<String> iterator;

        /**
         * Constructor of the special menu iterator
         */
        public SpecialMenuIterator() {
            keys = dishes.keySet();
            iterator = keys.iterator();
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
            return dishes.get(iterator.next());
        }

        /**
         * Removes from the underlying collection the last element returned by this
         * iterator
         * Not implemented in most of our iterators
         */
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        /**
         * Restarts the iterator
         */
        @Override
        public void restart() {
            iterator = keys.iterator();
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

    /* The hashtable of dishes */
    private Hashtable<String, Dish> dishes;

    /* The number of dishes */
    private int numberOfDishes;

    /* The name of the menu */
    private String name;

    /**
     * Constructor of the special menu
     */
    public SpecialMenu() {
        this.name = "Menu especial";
        dishes = new Hashtable<String, Dish>();
        numberOfDishes = dishes.size();
        Dish primero = new Dishes.RibEyeHamburger();
        Dish segundo = new Dishes.AvocadoHamburger();
        Dish tercero = new Dishes.OstrichHamburger();
        dishes.put(primero.getName(), primero);
        dishes.put(segundo.getName(), segundo);
        dishes.put(tercero.getName(), tercero);
    }

    /**
     * Add a dish to the menu
     * 
     * @param dish the dish to add
     */
    @Override
    public void add(Dish dish) {
        dishes.put(dish.getName(), dish);
    }

    /**
     * Remove a dish from the menu
     * 
     * @param dish the dish to remove
     */
    @Override
    public void remove(Dish dish) {
        dishes.remove(dish.getName());
    }

    /**
     * Returns the name of the menu the iterator is iterating
     * 
     * @return the namein of the menu the iterator is iterating
     */
    public String getName() {
        return name;
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
        return new SpecialMenuIterator();
    }

}
