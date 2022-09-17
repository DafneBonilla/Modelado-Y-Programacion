package Dishes;

public class MushroomHamburger extends Hamburger {

    public MushroomHamburger() {
        this.id = 22;
        this.name = "Hamburguesa de hongos";
        this.description = "Hamburguesa con hongos, queso cheddar, lechuga, pepinillos, ketchup, mostaza y mayonesa";
        this.price = 7.89;
        this.cheese = true;
        this.vegetarian = true;
    }

    @Override
    protected void prepareMeat() {
        System.out.println("Cociendo hongos");
    }

    @Override
    protected void putMeat() {
        System.out.println("Poniendo hongos");
    }

    @Override
    protected void putCheese() {
        if (cheese) {
            System.out.println("Poniendo queso cheddar");
        }
    }

    @Override
    protected void putVegetables() {
        System.out.println("Poniendo lechuga y pepinillos");
    }

    @Override
    public String toString() {
        return "[ ID: " + id + " | Nombre: " + name + " | Descripcion: " + description + " | Precio: " + price
                + "$(USD) | Queso: " + cheese + " | Vegetariano: " + vegetarian + " ]";
    }

}
