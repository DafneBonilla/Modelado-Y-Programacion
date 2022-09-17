package Dishes;

public class MasterChiefHamburger extends Hamburger {

    public MasterChiefHamburger() {
        this.id = 23;
        this.name = "Master Chief Burger";
        this.description = "Hamburguesa con carne de covenant, queso sagrado, lechuga, tomate, jalapenios, ketchup, mostaza y mayonesa";
        this.price = 5.50;
        this.cheese = true;
        this.vegetarian = false;
    }

    @Override
    protected void prepareMeat() {
        System.out.println("Cociendo carne de covenant");
    }

    @Override
    protected void putMeat() {
        System.out.println("Poniendo carne de covenant");
    }

    @Override
    protected void putCheese() {
        if (cheese) {
            System.out.println("Poniendo queso sagrado");
        }
    }

    @Override
    protected void putVegetables() {
        System.out.println("Poniendo lechuga, tomate, y jalapenios");
    }

    @Override
    public String toString() {
        return "[ ID: " + id + " | Nombre: " + name + " | Descripcion: " + description + " | Precio: " + price
                + "$(USD) | Queso: " + cheese + " | Vegetariano: " + vegetarian + " ]";
    }

}
