package Menus;

import java.util.ArrayList;
import java.util.Iterator;

import Dishes.Dish;

public class DailyMenu implements Menu {

    private class DailyMenuIterator implements MenuIterator {

        private Iterator<Dish> iterator;

        private DailyMenuIterator() {
            iterator = dishes.iterator();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public Dish next() {
            return iterator.next();
        }

        @Override
        public void remove() {
            iterator.remove();
        }

        @Override
        public void restart() {
            iterator = dishes.iterator();
        }

        @Override
        public String getName() {
            return name;
        }

    }

    private ArrayList<Dish> dishes;

    private int numberOfDishes;

    private String name;

    public DailyMenu() {
        this.name = "Menu del dia";
        dishes = new ArrayList<Dish>();
        numberOfDishes = dishes.size();
        dishes.add(new Dishes.CanekHamburger());
        dishes.add(new Dishes.MushroomHamburger());
        dishes.add(new Dishes.MasterChiefHamburger());
    }

    @Override
    public void add(Dish dish) {
        dishes.add(dish);
    }

    @Override
    public void remove(Dish dish) {
        dishes.remove(dish);
    }

    public int getNumberOfDishes() {
        return numberOfDishes;
    }

    @Override
    public MenuIterator iterator() {
        return new DailyMenuIterator();
    }

}
