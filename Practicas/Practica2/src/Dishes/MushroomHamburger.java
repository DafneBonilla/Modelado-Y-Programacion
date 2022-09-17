package Dishes;

/**
 * Class to represent a mushroom hamburger.
 */
public class MushroomHamburger extends Hamburger {

    /**
     * Constructor for the mushroom hamburger.
     */
    public MushroomHamburger() {
        this.id = 22;
        this.name = "Hamburguesa de hongos";
        this.description = "Hamburguesa con hongos, queso cheddar, lechuga, pepinillos, ketchup, mostaza y mayonesa";
        this.price = 7.89;
        this.cheese = true;
        this.vegetarian = true;
    }

    /**
     * Method to prepare the meat of the hamburger
     */
    @Override
    protected void prepareMeat() {
        System.out.println("Cociendo hongos");
    }

    /**
     * Method to put the meat of the hamburger
     */
    @Override
    protected void putMeat() {
        System.out.println("Poniendo hongos");
    }

    /**
     * Method to put the cheese of the hamburger
     */
    @Override
    protected void putCheese() {
        if (cheese) {
            System.out.println("Poniendo queso cheddar");
        }
    }

    /**
     * Method to put the vegetables of the hamburger
     */
    @Override
    protected void putVegetables() {
        System.out.println("Poniendo lechuga y pepinillos");
    }

    /**
     * Returns a mushroom hamburger in string format
     * 
     * @return a mushroom hamburger in string format
     */
    @Override
    public String toString() {
        return "[ ID: " + id + " | Nombre: " + name + " | Descripcion: " + description + " | Precio: " + price
                + "$(USD) | Queso: " + cheese + " | Vegetariano: " + vegetarian + " ]";
    }

}
