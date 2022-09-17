package Dishes;

/**
 * Class to represent a Canek hamburger.
 */
public class CanekHamburger extends Hamburger {

    /**
     * Constructor for the Canek hamburger.
     */
    public CanekHamburger() {
        this.id = 21;
        this.name = "CanekBurguer";
        this.description = "Hamburguesa con carne de res, queso trivial, ejotes, ketchup, mostaza y mayonesa";
        this.price = 6.90;
        this.cheese = true;
        this.vegetarian = false;
    }

    /**
     * Method to prepare the meat of the hamburger
     */
    @Override
    protected void prepareMeat() {
        System.out.println("Cociendo la carne de res");

    }

    /**
     * Method to put the meat of the hamburger
     */
    @Override
    protected void putMeat() {
        System.out.println("Poniendo carne de res");
    }

    /**
     * Method to put the cheese of the hamburger
     */
    @Override
    protected void putCheese() {
        if (cheese) {
            System.out.println("Poniendo queso trivial");
        }
    }

    /**
     * Method to put the vegetables of the hamburger
     */
    @Override
    protected void putVegetables() {
        System.out.println("Poniendo ejotes");
    }

    /**
     * Returns a Canek hamburger in string format
     * 
     * @return a Canek hamburger in string format
     */
    @Override
    public String toString() {
        return "[ ID: " + id + " | Nombre: " + name + " | Descripcion: " + description + " | Precio: " + price
                + "$(USD) | Queso: " + cheese + " | Vegetariano: " + vegetarian + " ]";
    }

}
