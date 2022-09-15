package Robots;

public class ActiveMode implements RobotMode {

    private Robot robot;

    public ActiveMode(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void sleep() {
        System.out.println("A mimir...");
        this.robot.setState(this.robot.getSleepMode());
    }

    @Override
    public void activate() {
        System.out.println("Ya estoy activo");
    }

    @Override
    public void walk() {
        System.out.println("Caminando hacia el cliente");
        this.robot.setState(this.robot.getWalkMode());
        this.robot.setWithClient(true);
    }

    @Override
    public void takeOrder() {
        System.out.println("No puedo tomar ordenes, no estoy con un cliente");
    }

    @Override
    public void cook() {
        System.out.println("No puedo cocinar, no tengo orden");
    }

    @Override
    public void deliver() {
        System.out.println("No puedo entregar, no tengo comida lista");

    }

    @Override
    public void showMenu() {
        System.out.println("No puedo mostrar el menu, no estoy con un cliente");
    }

    @Override
    public String toString() {
        return "Modo activo";
    }

}
