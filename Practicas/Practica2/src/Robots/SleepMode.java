package Robots;

public class SleepMode implements RobotMode {

    private Robot robot;

    public SleepMode(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void sleep() {
        System.out.println("Zzzz");
    }

    @Override
    public void activate() {
        System.out.println("Ya desperte del suenooooooooooooooooo");
        this.robot.setState(this.robot.getActiveMode());
    }

    @Override
    public void walk() {
        System.out.println("Zzzz");
    }

    @Override
    public void takeOrder() {
        System.out.println("Zzzz");
    }

    @Override
    public void cook() {
        System.out.println("Zzzz");
    }

    @Override
    public void deliver() {
        System.out.println("Zzzz");
    }

    @Override
    public void showMenu() {
        System.out.println("Zzzz");
    }

    @Override
    public String toString() {
        return "Modo dormido";

    }

}
