package Menus;

import Dishes.Dish;

public interface MenuIterator {

    public boolean hasNext();

    public Dish next();

    public void remove();

    public void restart();

    public String getName();

}
