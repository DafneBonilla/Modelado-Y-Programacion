package Robots;

/**
 * Class to represent the walk mode of a robot
 * A walk mode has a robot
 */
public class WalkMode implements RobotMode {

    /* The robot */
    private Robot robot;

    /**
     * Creates a new walk mode
     * 
     * @param robot the robot that has this mode
     */
    public WalkMode(Robot robot) {
        this.robot = robot;
    }

    /**
     * The robot sleeps
     */
    @Override
    public void sleep() {
        System.out.println("A mimir...");
        this.robot.setState(this.robot.getSleepMode());
        this.robot.setWithClient(false);
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
        System.out.println("Ya estoy caminando");
    }

    /**
     * The robot takes an order
     */
    @Override
    public void takeOrder() {
        if (this.robot.isWithClient()) {
            System.out.println("Estoy listo para atenderte, " + this.robot.getCName());
            this.robot.setState(this.robot.getAttendMode());
        } else {
            System.out.println("No puedo tomar ordenes, no estoy con un cliente");
        }
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
        System.out.println("No puedo mostrar el menu, no estoy atendiendo a un cliente");
    }

    /**
     * Returns the robot mode in string format
     * 
     * @return the robot mode in string format
     */
    @Override
    public String toString() {
        return "Modo caminando";
    }

}
