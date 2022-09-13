package Menus;

import Dishes.Dish;

public interface MenuIterator extends java.util.Iterator<Dish> {

    public boolean hasNext();

    public Dish next();

    public void remove();

    public void restart();

}
