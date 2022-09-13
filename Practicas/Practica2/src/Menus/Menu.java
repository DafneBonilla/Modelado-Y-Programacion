package Menus;

import Dishes.Dish;

public interface Menu {

    public void add(Dish dish);

    public void remove(Dish dish);

    public MenuIterator iterator();

}
