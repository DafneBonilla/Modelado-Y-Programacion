package Dishes;

/**
 * Class to represent a tofu hamburger.
 */
public class TofuHamburger extends Hamburger {

    /**
     * Constructor for the tofu hamburger.
     */
    public TofuHamburger() {
        this.id = 12;
        this.name = "Hamburguesa de tofu";
        this.description = "Hamburguesa vegetariana con tofu, queso, lechuga, tomate, cebolla, pepinillos, ketchup, mostaza y mayonesa";
        this.price = 5.00;
        this.cheese = false;
        this.vegetarian = true;
    }

    /**
     * Method to prepare the meat of the hamburger
     */
    @Override
    protected void prepareMeat() {
        System.out.println("Cociendo tofu");
    }

    /**
     * Method to put the meat of the hamburger
     */
    @Override
    protected void putMeat() {
        System.out.println("Poniendo tofu");
    }

    /**
     * Method to put the cheese of the hamburger
     */
    @Override
    protected void putCheese() {
        if (cheese) {
            System.out.println("Poniendo queso");
        }
    }

    /**
     * Method to put the vegetables of the hamburger
     */
    @Override
    protected void putVegetables() {
        System.out.println("Poniendo lechuga, tomate, cebolla y pepinillos");
    }

    /**
     * Returns a tofu hamburger in string format
     * 
     * @return a tofu hamburger in string format
     */
    @Override
    public String toString() {
        return "[ ID: " + id + " | Nombre: " + name + " | Descripcion: " + description + " | Precio: " + price
                + "$(USD) | Queso: " + cheese + " | Vegetariano: " + vegetarian + " ]";
    }

}
