package Menus;

import java.util.Iterator;
import Dishes.Dish;

public class DailyMenu implements Menu {

    private class DailyMenuIterator implements MenuIterator {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < dishes.length;
        }

        @Override
        public Dish next() {
            return dishes[index++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void restart() {
            index = 0;
        }
    }

    private Dish[] dishes;

    private int numberOfDishes;

    private String name;

    public DailyMenu() {
        this.name = "Menu del dia";
        dishes = new Dish[3];
        numberOfDishes = 3;
        dishes[0] = new Dishes.CanekHamburger();
        dishes[1] = new Dishes.MushroomHamburger();
        dishes[2] = new Dishes.MasterChiefHamburger();
    }

    @Override
    public void add(Dish dish) {

    }

    @Override
    public void remove(Dish dish) {
        Dish[] newDishes = new Dish[numberOfDishes - 1];
        int j = 0;
        for (int i = 0; i < numberOfDishes; i++) {
            if (dishes[i].getID() != dish.getID()) {
                newDishes[j] = dishes[i];
                j++;
            }
        }
        dishes = newDishes;
        numberOfDishes--;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfDishes() {
        return numberOfDishes;
    }

    @Override
    public Iterator<Dish> iterator() {
        return new DailyMenuIterator();
    }

}
