package Menus;

import Dishes.Dish;

public class GeneralMenu implements Menu {

    private class GeneralMenuIterator implements MenuIterator {

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

    public GeneralMenu() {
        this.name = "Menu general";

    }

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

    public String getName() {
        return name;
    }

    public int getNumberOfDishes() {
        return numberOfDishes;
    }

    @Override
    public Iterator<Dish> iterator() {
        return new GeneralMenuIterator();
    }

}
