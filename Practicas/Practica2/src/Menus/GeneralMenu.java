package Menus;

import Dishes.Dish;

public class GeneralMenu implements Menu {

    private class GeneralMenuIterator implements MenuIterator {

        private int index;

        private GeneralMenuIterator() {
            index = 0;
        }

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

        @Override
        public String getName() {
            return name;
        }
    }

    private Dish[] dishes;

    private int numberOfDishes;

    private String name;

    public GeneralMenu() {
        this.name = "Menu general";
        dishes = new Dish[3];
        numberOfDishes = dishes.length;
        dishes[0] = new Dishes.CheeseHamburger();
        dishes[1] = new Dishes.TofuHamburger();
        dishes[2] = new Dishes.ChickenHamburger();

    }

    @Override
    public void add(Dish dish) {
        Dish[] newDishes = new Dish[numberOfDishes + 1];
        for (int i = 0; i < numberOfDishes; i++) {
            newDishes[i] = dishes[i];
        }
        newDishes[numberOfDishes] = dish;
        dishes = newDishes;
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
        }
    }

    public String getName() {
        return name;
    }

    public int getNumberOfDishes() {
        return numberOfDishes;
    }

    @Override
    public MenuIterator iterator() {
        return new GeneralMenuIterator();
    }

}
