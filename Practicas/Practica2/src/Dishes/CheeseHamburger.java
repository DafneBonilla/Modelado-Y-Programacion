package Dishes;

/**
 * Class to represent a cheese hamburger.
 */
public class CheeseHamburger extends Hamburger {

    /**
     * Constructor for the cheese hamburger.
     */
    public CheeseHamburger() {
        this.id = 11;
        this.name = "Hamburguesa con queso";
        this.description = "Hamburguesa con carne de res, queso, lechuga, tomate, cebolla, pepinillos, ketchup, mostaza y mayonesa";
        this.price = 3.50;
        this.cheese = true;
        this.vegetarian = false;
    }

    /**
     * Method to prepare the meat of the hamburger
     */
    @Override
    protected void prepareMeat() {
        System.out.println("Cociendo carne de res");
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
     * Returns a cheese hamburger in string format
     * 
     * @return a cheese hamburger in string format
     */
    @Override
    public String toString() {
        return "[ ID: " + id + " | Nombre: " + name + " | Descripcion: " + description + " | Precio: " + price
                + "$(USD) | Queso: " + cheese + " | Vegetariano: " + vegetarian + " ]";
    }

}
