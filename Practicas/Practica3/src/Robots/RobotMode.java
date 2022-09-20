package Robots;

/**
 * Interface to represent a robot mode
 * A robot mode has a robot
 */
public interface RobotMode {

    /**
     * The robot sleeps
     */
    public void sleep();

    /**
     * The robot is activated
     */
    public void activate();

    /**
     * The robot walks
     */
    public void walk();

    /**
     * The robot takes an order
     */
    public void takeOrder();

    /**
     * The robot cooks
     */
    public void cook();

    /**
     * The robot delivers a dish
     */
    public void deliver();

    /**
     * The robot shows the menu
     */
    public void showMenu();

    /**
     * Returns the robot mode in string format
     * 
     * @return the robot mode in string format
     */
    @Override
    public String toString();

}
