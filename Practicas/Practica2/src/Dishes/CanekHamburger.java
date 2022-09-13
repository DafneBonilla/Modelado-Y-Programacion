package Dishes;

public class CanekHamburger extends Hamburger {

    public CanekHamburger() {
        this.id = 21;
        this.name = "CanekBurguer";
        this.description = "Hamburguesa con carne de res, queso trivial, ejotes, ketchup, mostaza y mayonesa";
        this.price = 6.90;
        this.cheese = true;
        this.vegetarian = false;
    }

    @Override
    protected void prepareMeat() {
        System.out.println("Cociendo la carne de res");

    }

    @Override
    protected void putMeat() {
        System.out.println("Poniendo carne de res");
    }

    @Override
    protected void putCheese() {
        if (cheese) {
            System.out.println("Poniendo queso trivial");
        }
    }

    @Override
    protected void putVegetables() {
        System.out.println("Poniendo ejotes");
    }

    @Override
    public String toString() {
        return "[ ID: " + id + " | Nombre: " + name + " | Descripción: " + description + " | Precio: " + price
                + "$(USD) | Queso: " + cheese + " | Vegetariano: " + vegetarian + " ]";
    }

}
