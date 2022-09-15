package Robots;

import Dishes.Dish;

public class CookMode implements RobotMode {

    private Robot robot;

    private Dish dish;

    public CookMode(Robot robot) {
        this.robot = robot;
        this.dish = null;

    }

    @Override
    public void sleep() {
        System.out.println("No puedo dormir, estoy cocinando");
    }

    @Override
    public void activate() {
        System.out.println("Ya estoy activo");
    }

    @Override
    public void walk() {
        System.out.println("No puedo caminar, estoy cocinando");
    }

    @Override
    public void takeOrder() {
        System.out.println("No puedo tomar ordenes, estoy cocinando");
    }

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

    @Override
    public void showMenu() {
        System.out.println("No puedo mostrar el menu, estoy cocinando");
    }

    @Override
    public String toString() {
        return "Modo cocinando";
    }

}
