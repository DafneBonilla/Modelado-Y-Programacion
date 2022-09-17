package Menus;

import Dishes.Dish;

/**
 * Class to represent the daily menu
 * A daily menu is a menu that has a name, a number of dishes and an array of
 * dishes
 */
public class GeneralMenu implements Menu {

    /**
     * Class of the general menu iterator
     */
    private class GeneralMenuIterator implements MenuIterator {

        /* The index of the next element */
        private int index;

        /**
         * Constructor of the general menu iterator
         */
        private GeneralMenuIterator() {
            index = 0;
        }

        /**
         * Returns true if the iteration has more elements
         * 
         * @return true if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return index < dishes.length;
        }

        /**
         * Returns the next dish in the iteration
         * 
         * @return the next dish in the iteration
         */
        @Override
        public Dish next() {
            return dishes[index++];
        }

        /**
         * Remove a dish from the menu
         * 
         * @param dish the dish to remove
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
            index = 0;
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

    /* The array of dishes */
    private Dish[] dishes;

    /* The number of dishes */
    private int numberOfDishes;

    /* The name of the menu */
    private String name;

    /**
     * Constructor of the general menu
     */
    public GeneralMenu() {
        this.name = "Menu general";
        dishes = new Dish[3];
        numberOfDishes = dishes.length;
        dishes[0] = new Dishes.CheeseHamburger();
        dishes[1] = new Dishes.TofuHamburger();
        dishes[2] = new Dishes.ChickenHamburger();

    }

    /**
     * Add a dish to the menu
     * 
     * @param dish the dish to add
     */
    @Override
    public void add(Dish dish) {
        Dish[] newDishes = new Dish[numberOfDishes + 1];
        for (int i = 0; i < numberOfDishes; i++) {
            newDishes[i] = dishes[i];
        }
        newDishes[numberOfDishes] = dish;
        dishes = newDishes;
        numberOfDishes++;
    }

    /**
     * Remove a dish from the menu
     * 
     * @param dish the dish to remove
     */
    @Override
    public void remove(Dish dish) {
        if (numberOfDishes == 0) {
            return;
        }
        boolean is = false;
        for (int i = 0; i < dishes.length; i++) {
            if (dishes[i].getID() == dish.getID()) {
                is = true;
                break;
            }
        }
        if (is) {
            Dish[] temp = new Dish[dishes.length - 1];
            int j = 0;
            for (int i = 0; i < dishes.length; i++) {
                if (dishes[i].getID() != dish.getID()) {
                    temp[j++] = dishes[i];
                }
            }
            dishes = temp;
            numberOfDishes--;
        }
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
        return new GeneralMenuIterator();
    }

}
