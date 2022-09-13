import java.util.ArrayList;
import java.util.List;

public class Practica2 {

    public static void main(String[] args) {

        Menus.Menu menu1 = new Menus.GeneralMenu();
        Menus.Menu menu2 = new Menus.DailyMenu();
        Menus.Menu menu3 = new Menus.SpecialMenu();
        List<Menus.MenuIterator> menus = new ArrayList<Menus.MenuIterator>();
        menus.add(menu1.iterator());
        menus.add(menu2.iterator());
        menus.add(menu3.iterator());
        for (Menus.MenuIterator menu : menus) {
            while (menu.hasNext()) {
                System.out.println(menu.next());
            }
        }
    }
}
