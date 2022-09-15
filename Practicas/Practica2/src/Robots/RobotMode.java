package Robots;

public interface RobotMode {

    public void sleep();

    public void activate();

    public void walk();

    public void takeOrder();

    public void cook();

    public void deliver();

    public void showMenu();

    @Override
    public String toString();

}
