package Dishes;

/**
 * Class to represent an avocado hamburger.
 */
public class AvocadoHamburger extends Hamburger {

    /**
     * Constructor for the avocado hamburger.
     */
    public AvocadoHamburger() {
        this.id = 33;
        this.name = "Hamburguesa de aguacate";
        this.description = "Hamburguesa vegetariana con aguacate premiun, lechuga, tomate, cebolla, garbanzos, ketchup, mostaza y mayonesa";
        this.price = 7.95;
        this.cheese = false;
        this.vegetarian = true;
    }

    /**
     * Method to prepare the meat of the hamburger
     */
    @Override
    protected void prepareMeat() {
        System.out.println("Preparando el aguacate premium");
    }

    /**
     * Method to put the meat of the hamburger
     */
    @Override
    protected void putMeat() {
        System.out.println("Poniendo el aguacate premium ");
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
        System.out.println("Poniendo lechuga, tomate, cebolla y garbanzos");
    }

    /**
     * Returns a avocado hamburger in string format
     * 
     * @return a avocado hamburger in string format
     */
    @Override
    public String toString() {
        return "[ ID: " + id + " | Nombre: " + name + " | Descripcion: " + description + " | Precio: " + price
                + "$(USD) | Queso: " + cheese + " | Vegetariano: " + vegetarian + " ]";
    }

}
