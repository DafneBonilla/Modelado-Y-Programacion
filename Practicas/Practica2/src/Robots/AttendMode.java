package Robots;

import java.util.List;
import java.util.Scanner;
import Dishes.Dish;
import Menus.MenuIterator;

/**
 * Class to represent the attend mode of a robot
 * An attend mode has a robot
 */
public class AttendMode implements RobotMode {

    /* The robot */
    private Robot robot;

    /**
     * Creates a new attend mode
     * 
     * @param robot the robot that has this mode
     */
    public AttendMode(Robot robot) {
        this.robot = robot;
    }

    /**
     * The robot sleeps
     */
    @Override
    public void sleep() {
        System.out.println("No puedo dormir, estoy atendiendo a un cliente");
    }

    /**
     * The robot is activated
     */
    @Override
    public void activate() {
        System.out.println("Ya estoy activo");
    }

    /**
     * The robot walks
     */
    @Override
    public void walk() {
        System.out.println("Ya estoy con un cliente");
    }

    /**
     * The robot takes an order
     */
    @Override
    public void takeOrder() {
        if (this.robot.isHaveOrder()) {
            System.out.println("Ya tengo una orden");
        } else {
            Dish dishy = askClient();
            if (dishy != null) {
                System.out.println("El cliente pidio " + dishy.getName());
            } else {
                System.out.println("...");
            }
        }
    }

    /**
     * The robot cooks
     */
    @Override
    public void cook() {
        if (this.robot.isHaveOrder()) {
            System.out.println("Listo para empezar a cocinar");
            this.robot.setState(this.robot.getCookMode());
        } else {
            System.out.println("No puedo cocinar, no tengo orden");
        }
    }

    /**
     * The robot delivers a dish
     */
    @Override
    public void deliver() {
        System.out.println("No puedo entregar, no tengo comida lista");
    }

    /**
     * The robot shows the menu
     */
    @Override
    public void showMenu() {
        System.out.println("Este es el menu:");
        List<MenuIterator> menus = this.robot.getMenus();
        for (MenuIterator menu : menus) {
            menu.restart();
        }
        for (MenuIterator menu : menus) {
            System.out.println(menu.getName());
            while (menu.hasNext()) {
                System.out.println(menu.next());
            }
        }
    }

    /**
     * Returns the robot mode in string format
     * 
     * @return the robot mode in string format
     */
    @Override
    public String toString() {
        return "Modo atender";
    }

    /**
     * Asks the client for a dish
     * In case the client gives a wrong dish, it returns null
     * 
     * @return the dish that the client wants
     */
    private Dish askClient() {
        System.out.println("Ingrese el id del plato que desea");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        try {
            int id = Integer.parseInt(answer);
            Dish tinyDish = this.robot.searchDish(id);
            if (tinyDish != null) {
                this.robot.setDish(tinyDish);
                this.robot.setHaveOrder(true);
                return tinyDish;
            } else {
                System.out.println("No hay ningun plato con ese id");
                return null;
            }
        } catch (NumberFormatException nfe) {
            System.out.println("No es un id valido");
            return null;
        }
    }

}
