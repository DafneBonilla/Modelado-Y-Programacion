import Dishes.Dish;
import Menus.DailyMenu;

public class Practica2 {

    public static void main(String[] args) {

        DailyMenu menu = new DailyMenu();
        for (Dish p : menu) {
            System.out.println(p);
        }
    }

}
