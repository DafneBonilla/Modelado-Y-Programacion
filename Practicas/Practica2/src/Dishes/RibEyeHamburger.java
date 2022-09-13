package Dishes;

public class RibEyeHamburger extends Hamburger {

    public RibEyeHamburger() {
        this.id = 32;
        this.name = "Hamburguesa de Rib Eye";
        this.description = "Hamburguesa con Rib Eye, tocino, queso premium, jalapenios, ketchup, mostaza y mayonesa";
        this.price = 14.49;
        this.cheese = true;
        this.vegetarian = false;
    }

    @Override
    protected void prepareMeat() {
        System.out.println("Cociendo Rib Eye y tocino");
    }

    @Override
    protected void putMeat() {
        System.out.println("Poniendo Rib Eye y tocino");
    }

    @Override
    protected void putCheese() {
        if (cheese) {
            System.out.println("Poniendo queso premium");
        }
    }

    @Override
    protected void putVegetables() {
        System.out.println("Poniendo jalapenios");
    }

    @Override
    public String toString() {
        return "[ ID: " + id + " | Nombre: " + name + " | Descripción: " + description + " | Precio: " + price
                + "$(USD) | Queso: " + cheese + " | Vegetariano: " + vegetarian + " ]";
    }

}
