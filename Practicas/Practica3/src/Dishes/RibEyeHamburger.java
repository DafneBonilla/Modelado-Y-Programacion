package Dishes;

/**
 * Class to represent a rib eye hamburger.
 */
public class RibEyeHamburger extends Hamburger {

    /**
     * Constructor for the rib eye hamburger.
     */
    public RibEyeHamburger() {
        this.id = 32;
        this.name = "Hamburguesa de Rib Eye";
        this.description = "Hamburguesa con Rib Eye, tocino, queso premium, jalapenios, ketchup, mostaza y mayonesa";
        this.price = 14.49;
        this.cheese = true;
        this.vegetarian = false;
    }

    /**
     * Method to prepare the meat of the hamburger
     */
    @Override
    protected void prepareMeat() {
        System.out.println("Cociendo Rib Eye y tocino");
    }

    /**
     * Method to put the meat of the hamburger
     */
    @Override
    protected void putMeat() {
        System.out.println("Poniendo Rib Eye y tocino");
    }

    /**
     * Method to put the cheese of the hamburger
     */
    @Override
    protected void putCheese() {
        if (cheese) {
            System.out.println("Poniendo queso premium");
        }
    }

    /**
     * Method to put the vegetables of the hamburger
     */
    @Override
    protected void putVegetables() {
        System.out.println("Poniendo jalapenios");
    }

    /**
     * Returns a rib eye hamburger in string format
     * 
     * @return a rib eye hamburger in string format
     */
    @Override
    public String toString() {
        return "[ ID: " + id + " | Nombre: " + name + " | Descripcion: " + description + " | Precio: " + price
                + "$(USD) | Queso: " + cheese + " | Vegetariano: " + vegetarian + " ]";
    }

}
