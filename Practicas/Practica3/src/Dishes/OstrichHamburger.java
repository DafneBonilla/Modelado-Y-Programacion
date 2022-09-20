package Dishes;

/**
 * Class to represent an ostrich hamburger.
 */
public class OstrichHamburger extends Hamburger {

    /**
     * Constructor for the ostrich hamburger.
     */
    public OstrichHamburger() {
        this.id = 31;
        this.name = "Hamburguesa de avestruz";
        this.description = "Hamburguesa con carne de avestruz, lechuga, raiz de zanahoria, grillos, ketchup, mostaza y mayonesa";
        this.price = 14.99;
        this.cheese = false;
        this.vegetarian = false;
    }

    /**
     * Method to prepare the meat of the hamburger
     */
    @Override
    protected void prepareMeat() {
        System.out.println("Cociendo carne de avestruz");
    }

    /**
     * Method to put the meat of the hamburger
     */
    @Override
    protected void putMeat() {
        System.out.println("Poniendo carne de avestruz");

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
        System.out.println("Poniendo raiz de zanahoria y grillos");
    }

    /**
     * Returns an ostrich hamburger in string format
     * 
     * @return an ostrich hamburger in string format
     */
    @Override
    public String toString() {
        return "[ ID: " + id + " | Nombre: " + name + " | Descripcion: " + description + " | Precio: " + price
                + "$(USD) | Queso: " + cheese + " | Vegetariano: " + vegetarian + " ]";
    }

}
