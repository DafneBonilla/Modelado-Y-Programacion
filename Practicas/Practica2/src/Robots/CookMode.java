package Robots;

import Dishes.Dish;

/**
 * Class to represent the cook mode of a robot
 * A cook mode has a robot and the dish that will be cooked
 */
public class CookMode implements RobotMode {

    /* The robot */
    private Robot robot;

    /* The dish that will be cooked */
    private Dish dish;

    /**
     * Creates a new cook mode
     * 
     * @param robot the robot that has this mode
     */
    public CookMode(Robot robot) {
        this.robot = robot;
        this.dish = null;

    }

    /**
     * The robot sleeps
     */
    @Override
    public void sleep() {
        System.out.println("No puedo dormir, estoy cocinando");
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
        System.out.println("No puedo caminar, estoy cocinando");
    }

    /**
     * The robot takes an order
     */
    @Override
    public void takeOrder() {
        System.out.println("No puedo tomar ordenes, estoy cocinando");
    }

    /**
     * The robot cooks
     */
    @Override
    public void cook() {
        if (this.robot.getDish() != null) {
            Dish dishy = this.robot.getDish();
            this.dish = dishy;
            System.out.println("Empezando a cocinar " + dishy.getName());
            dishy.cook();
            System.out.println("Listo");
            this.robot.setOrderIsReady(true);
            this.robot.setDish(null);
        } else {
            System.out.println("No puedo cocinar, ya tengo un platillo cocinado");
        }
    }

    /**
     * The robot delivers a dish
     */
    @Override
    public void deliver() {
        if (this.robot.isOrderIsReady()) {
            System.out.println("La comida esta lista");
            System.out.println("Entregando " + this.dish.getName());
            this.dish = null;
            this.robot.setOrderIsReady(false);
            this.robot.setWithClient(false);
            this.robot.setState(this.robot.getSleepMode());
        } else {
            System.out.println("No puedo entregar, no tengo comida lista");
        }
    }

    /**
     * The robot shows the menu
     */
    @Override
    public void showMenu() {
        System.out.println("No puedo mostrar el menu, estoy cocinando");
    }

    /**
     * Returns the robot mode in string format
     * 
     * @return the robot mode in string format
     */
    @Override
    public String toString() {
        return "Modo cocinando";
    }

}
