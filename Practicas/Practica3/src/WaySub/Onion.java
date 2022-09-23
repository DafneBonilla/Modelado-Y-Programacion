package WaySub;

/**
 * Class to represent onion.
 */
public class Onion extends Ingredient {

    /**
     * Constructor for the onion.
     * 
     * @param filling the sandwich to be decorated.
     */
    public Onion(Sandwich filling) {
        this.filling = filling;
        name = "Cebolla";
        price = 11.00;
    }

    /**
     * Returns the description of the onion.
     * 
     * @return the description of the onion.
     */
    @Override
    public String getDescription() {
        return filling.getDescription() + ", Cebolla";
    }

}
