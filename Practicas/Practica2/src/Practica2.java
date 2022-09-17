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
        System.exit(0);
    }

    public static void main(String[] args) {

        if (args.length != 1) {
            uso();
        }

        String name = args[0];
        List<MenuIterator> menus = new ArrayList<>();
        menus.add(new GeneralMenu().iterator());
        menus.add(new DailyMenu().iterator());
        menus.add(new SpecialMenu().iterator());
        Robot robot = new Robot(menus, name);
        Scanner scanner = new Scanner(System.in);
        int option;
        System.out.println("Bienvenido a McBurguer, " + name);
        System.out.println("Estado del robot: " + robot.getState());
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
                    System.out.println("Estado del robot: " + robot.getState());
                    System.out.println("¿Que desea que el robot haga?");
                    System.out.println("1. Dormir");
                    System.out.println("2. Activar");
                    System.out.println("3. Caminar hacia el cliente");
                    System.out.println("4. Mostrar menu");
                    System.out.println("5. Tomar orden");
                    System.out.println("6. Cocinar");
                    System.out.println("7. Entregar comida");
                    System.out.println("0. Salir");
                }
            }
            switch (option) {
                case 1:
                    robot.sleep();
                    break;
                case 2:
                    robot.activate();
                    break;
                case 3:
                    robot.walk();
                    break;
                case 4:
                    robot.showMenu();
                    break;
                case 5:
                    robot.takeOrder();
                    break;
                case 6:
                    robot.cook();
                    break;
                case 7:
                    robot.deliver();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        } while (option != 0);
        System.out.println("Gracias por su visita");
    }
}
