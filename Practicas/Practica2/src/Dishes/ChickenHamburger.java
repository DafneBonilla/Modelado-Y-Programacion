package Dishes;

/**
 * Class to represent a chicken hamburger.
 */
public class ChickenHamburger extends Hamburger {

    /**
     * Constructor for the chicken hamburger.
     */
    public ChickenHamburger() {
        this.id = 13;
        this.name = "Hamburguesa de pollo";
        this.description = "Hamburguesa con pollo, col, tomate, cebolla, pepinillos, ketchup, mostaza y mayonesa";
        this.price = 3.59;
        this.cheese = false;
        this.vegetarian = false;
    }

    /**
     * Method to prepare the meat of the hamburger
     */
    @Override
    protected void prepareMeat() {
        System.out.println("Cociendo carne de pollo");

    }

    /**
     * Method to put the meat of the hamburger
     */
    @Override
    protected void putMeat() {
        System.out.println("Poniendo carne de pollo");
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
        System.out.println("Poniendo col, tomate, cebolla y pepinillos");
    }

    /**
     * Returns a chicken hamburger in string format
     * 
     * @return a chicken hamburger in string format
     */
    @Override
    public String toString() {
        return "[ ID: " + id + " | Nombre: " + name + " | Descripcion: " + description + " | Precio: " + price
                + "$(USD) | Queso: " + cheese + " | Vegetariano: " + vegetarian + " ]";
    }

}
