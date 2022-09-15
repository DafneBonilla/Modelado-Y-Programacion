package Robots;

public class WalkMode implements RobotMode {

    private Robot robot;

    public WalkMode(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void sleep() {
        System.out.println("A mimir...");
        this.robot.setState(this.robot.getSleepMode());
        this.robot.setWithClient(false);
    }

    @Override
    public void activate() {
        System.out.println("Ya estoy activo");
    }

    @Override
    public void walk() {
        System.out.println("Ya estoy caminando");
    }

    @Override
    public void takeOrder() {
        if (this.robot.isWithClient()) {
            System.out.println("Bienvenido al restaurante, " + this.robot.getCName());
            this.robot.setState(this.robot.getAttendMode());
        } else {
            System.out.println("No puedo tomar ordenes, no estoy con un cliente");
        }
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
        System.out.println("No puedo mostrar el menu, no estoy atendiendo a un cliente");
    }

    @Override
    public String toString() {
        return "Modo caminando";
    }

}
