package Menus;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import Dishes.Dish;

public class SpecialMenu implements Menu {

    private class SpecialMenuIterator implements MenuIterator {

        private Set<String> keys;

        private Iterator<String> iterator;

        public SpecialMenuIterator() {
            keys = dishes.keySet();
            iterator = keys.iterator();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public Dish next() {
            return dishes.get(iterator.next());
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void restart() {
            iterator = keys.iterator();
        }
    }

    private Hashtable<String, Dish> dishes;

    private int numberOfDishes;

    private String name;

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

    @Override
    public void add(Dish dish) {
        dishes.put(dish.getName(), dish);
    }

    @Override
    public void remove(Dish dish) {
        dishes.remove(dish.getName());
    }

    public String getName() {
        return name;
    }

    public int getNumberOfDishes() {
        return numberOfDishes;
    }

    @Override
    public MenuIterator iterator() {
        return new SpecialMenuIterator();
    }

}
