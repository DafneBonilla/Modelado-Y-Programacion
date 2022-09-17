package Robots;

/**
 * Class to represent the sleep mode of a robot
 * A sleep mode has a robot
 */
public class SleepMode implements RobotMode {

    /* The robot */
    private Robot robot;

    /**
     * Creates a new sleep mode
     * 
     * @param robot the robot that has this mode
     */
    public SleepMode(Robot robot) {
        this.robot = robot;
    }

    /**
     * The robot sleeps
     */
    @Override
    public void sleep() {
        System.out.println("Zzzz");
    }

    /**
     * The robot is activated
     */
    @Override
    public void activate() {
        System.out.println("Ya desperte del suenooooooooooooooooo");
        this.robot.setState(this.robot.getActiveMode());
    }

    /**
     * The robot walks
     */
    @Override
    public void walk() {
        System.out.println("Zzzz");
    }

    /**
     * The robot takes an order
     */
    @Override
    public void takeOrder() {
        System.out.println("Zzzz");
    }

    /**
     * The robot cooks
     */
    @Override
    public void cook() {
        System.out.println("Zzzz");
    }

    /**
     * The robot delivers a dish
     */
    @Override
    public void deliver() {
        System.out.println("Zzzz");
    }

    /**
     * The robot shows the menu
     */
    @Override
    public void showMenu() {
        System.out.println("Zzzz");
    }

    /**
     * Returns the robot mode in string format
     * 
     * @return the robot mode in string format
     */
    @Override
    public String toString() {
        return "Modo dormido";

    }

}
