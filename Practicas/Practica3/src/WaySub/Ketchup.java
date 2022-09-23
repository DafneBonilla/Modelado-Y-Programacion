package WaySub;

/**
 * Class to represent ketchup.
 */
public class Ketchup extends Ingredient {
   
    /**
     * Constructor for the ketchup.
     */
    public Ketchup(Sandwich filling) {
        this.filling = filling;
        name = "Catsup";
        price = 5.00;
    }
    
    /**
     * Returns the description of the ketchup.
     * @return the description of the ketchup.
     */
    @Override
    public String getDescription() {
        return filling.getDescription() + ", Catsup";
    }

}
