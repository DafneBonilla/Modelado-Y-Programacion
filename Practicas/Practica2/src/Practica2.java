import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Menus.DailyMenu;
import Menus.GeneralMenu;
import Menus.MenuIterator;
import Menus.SpecialMenu;
import Robots.Robot;

public class Practica2 {

    public static void uso() {
        System.out.println("Uso: java Practica2 <nombre>");
    }

    public static void main(String[] args) {

        String name = args[0];
        List<MenuIterator> menus = new ArrayList<>();
        menus.add(new GeneralMenu().iterator());
        menus.add(new DailyMenu().iterator());
        menus.add(new SpecialMenu().iterator());
        Robot robot = new Robot(menus, name);
        Scanner scanner = new Scanner(System.in);
        int option;
        System.out.println("Bienvenido a McBurguer, " + name);
        System.out.println("¿Que desea que el robot haga?");
        do {
            System.out.println("1. Dormir");
            System.out.println("2. Activar");
            System.out.println("3. Caminar hacia el cliente");
            System.out.println("4. Mostrar menu");
            System.out.println("5. Tomar orden");
            System.out.println("6. Cocinar");
            System.out.println("7. Entregar comida");
            System.out.println("0. Salir");
            while (true) {
                try {
                    String text = scanner.nextLine();
                    option = Integer.parseInt(text);
                    break;
                } catch (NumberFormatException nfe) {
                    System.out.println("Opcion invalida");
                    System.out.println("¿Que desea que el robot haga?");
                }
            }

        } while (option != 0);

    }

}
