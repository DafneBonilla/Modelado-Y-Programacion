package Dishes;

public class TofuHamburger extends Hamburger {

    public TofuHamburger() {
        this.id = 12;
        this.name = "Hamburguesa de tofu";
        this.description = "Hamburguesa vegetariana con tofu, queso, lechuga, tomate, cebolla, pepinillos, ketchup, mostaza y mayonesa";
        this.price = 5.00;
        this.cheese = false;
        this.vegetarian = true;
    }

    @Override
    protected void prepareMeat() {
        System.out.println("Cociendo tofu");
    }

    @Override
    protected void putMeat() {
        System.out.println("Poniendo tofu");
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
        return "[ ID: " + id + " | Nombre: " + name + " | Descripcion: " + description + " | Precio: " + price
                + "$(USD) | Queso: " + cheese + " | Vegetariano: " + vegetarian + " ]";
    }

}
