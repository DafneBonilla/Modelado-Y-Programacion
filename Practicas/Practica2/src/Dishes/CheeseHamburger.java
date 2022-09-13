package Dishes;

public class CheeseHamburger extends Hamburger {

    public CheeseHamburger() {
        this.id = 11;
        this.name = "Hamburguesa con queso";
        this.description = "Hamburguesa con carne de res, queso, lechuga, tomate, cebolla, pepinillos, ketchup, mostaza y mayonesa";
        this.price = 3.50;
        this.cheese = true;
        this.vegetarian = false;
    }

    @Override
    protected void prepareMeat() {
        System.out.println("Cociendo carne de res");
    }

    @Override
    protected void putMeat() {
        System.out.println("Poniendo carne de res");
    }

    @Override
    protected void putCheese() {
        if (cheese) {
            System.out.println("Poniendo queso");
        }
    }

    @Override
    protected void putVegetables() {
        System.out.println("Poniendo lechuga, tomate, cebolla y pepinillos");
    }

    @Override
    public String toString() {
        return "[ ID: " + id + " | Nombre: " + name + " | Descripción: " + description + " | Precio: " + price
                + "$(USD) | Queso: " + cheese + " | Vegetariano: " + vegetarian + " ]";
    }

}
