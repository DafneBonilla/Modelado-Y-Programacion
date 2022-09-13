package Dishes;

public class ChickenHamburger extends Hamburger {

    public ChickenHamburger() {
        this.id = 13;
        this.name = "Hamburguesa de pollo";
        this.description = "Hamburguesa con pollo, col, tomate, cebolla, pepinillos, ketchup, mostaza y mayonesa";
        this.price = 3.59;
        this.cheese = false;
        this.vegetarian = false;
    }

    @Override
    protected void prepareMeat() {
        System.out.println("Cociendo carne de pollo");

    }

    @Override
    protected void putMeat() {
        System.out.println("Poniendo carne de pollo");
    }

    @Override
    protected void putCheese() {
        if (cheese) {
            System.out.println("Poniendo queso");
        }
    }

    @Override
    protected void putVegetables() {
        System.out.println("Poniendo col, tomate, cebolla y pepinillos");
    }

    @Override
    public String toString() {
        return "[ ID: " + id + " | Nombre: " + name + " | Descripción: " + description + " | Precio: " + price
                + "$(USD) | Queso: " + cheese + " | Vegetariano: " + vegetarian + " ]";
    }

}
