package Menus;

import Dishes.Dish;

public interface Menu extends Iterable<Dish> {

    public void add(Dish dish);

    public void remove(Dish dish);

}
