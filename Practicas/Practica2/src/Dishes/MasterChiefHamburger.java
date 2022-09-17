package Dishes;

/**
 * Class to represent a MasterChief hamburger.
 */
public class MasterChiefHamburger extends Hamburger {

    /**
     * Constructor for the MasterChief hamburger.
     */
    public MasterChiefHamburger() {
        this.id = 23;
        this.name = "Master Chief Burger";
        this.description = "Hamburguesa con carne de covenant, queso sagrado, lechuga, tomate, jalapenios, ketchup, mostaza y mayonesa";
        this.price = 5.50;
        this.cheese = true;
        this.vegetarian = false;
    }

    /**
     * Method to prepare the meat of the hamburger
     */
    @Override
    protected void prepareMeat() {
        System.out.println("Cociendo carne de covenant");
    }

    /**
     * Method to put the meat of the hamburger
     */
    @Override
    protected void putMeat() {
        System.out.println("Poniendo carne de covenant");
    }

    /**
     * Method to put the cheese of the hamburger
     */
    @Override
    protected void putCheese() {
        if (cheese) {
            System.out.println("Poniendo queso sagrado");
        }
    }

    /**
     * Method to put the vegetables of the hamburger
     */
    @Override
    protected void putVegetables() {
        System.out.println("Poniendo lechuga, tomate, y jalapenios");
    }

    /**
     * Returns a MasterChief hamburger in string format
     * 
     * @return a MasterChief hamburger in string format
     */
    @Override
    public String toString() {
        return "[ ID: " + id + " | Nombre: " + name + " | Descripcion: " + description + " | Precio: " + price
                + "$(USD) | Queso: " + cheese + " | Vegetariano: " + vegetarian + " ]";
    }

}
