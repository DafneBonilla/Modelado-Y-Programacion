package Robots;

/**
 * Class to represent the active mode of a robot
 * An active mode has a robot
 */
public class ActiveMode implements RobotMode {

    /* The robot */
    private Robot robot;

    /**
     * Creates a new active mode
     * 
     * @param robot the robot that has this mode
     */
    public ActiveMode(Robot robot) {
        this.robot = robot;
    }

    /**
     * The robot sleeps
     */
    @Override
    public void sleep() {
        System.out.println("A mimir...");
        this.robot.setState(this.robot.getSleepMode());
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
        System.out.println("Caminando hacia el cliente");
        this.robot.setState(this.robot.getWalkMode());
        this.robot.setWithClient(true);
    }

    /**
     * The robot takes an order
     */
    @Override
    public void takeOrder() {
        System.out.println("No puedo tomar ordenes, no estoy con un cliente");
    }

    /**
     * The robot cooks
     */
    @Override
    public void cook() {
        System.out.println("No puedo cocinar, no tengo orden");
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
        System.out.println("No puedo mostrar el menu, no estoy con un cliente");
    }

    /**
     * Returns the robot mode in string format
     * 
     * @return the robot mode in string format
     */
    @Override
    public String toString() {
        return "Modo activo";
    }

}
