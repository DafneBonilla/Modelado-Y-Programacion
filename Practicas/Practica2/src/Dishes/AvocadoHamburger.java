package Dishes;

public class AvocadoHamburger extends Hamburger {

    public AvocadoHamburger() {
        this.id = 32;
        this.name = "Hamburguesa de aguacate";
        this.description = "Hamburguesa vegetariana con aguacate premiun, lechuga, tomate, cebolla, garbanzos, ketchup, mostaza y mayonesa";
        this.price = 7.95;
        this.cheese = false;
        this.vegetarian = true;
    }

    @Override
    protected void prepareMeat() {
        System.out.println("Preparando el aguacate premium");
    }

    @Override
    protected void putMeat() {
        System.out.println("Poniendo el aguacate premium ");
    }

    @Override
    protected void putCheese() {
        if (cheese) {
            System.out.println("Poniendo queso");
        }
    }

    @Override
    protected void putVegetables() {
        System.out.println("Poniendo lechuga, tomate, cebolla y garbanzos");
    }

    @Override
    public String toString() {
        return "[ ID: " + id + " | Nombre: " + name + " | Descripción: " + description + " | Precio: " + price
                + "$(USD) | Queso: " + cheese + " | Vegetariano: " + vegetarian + " ]";
    }

}
