package WaySub;

/**
 * Class to represent pepperoni.
 */
public class Pepperoni extends Ingredient {

    /**
     * Constructor for the pepperoni.
     * 
     * @param filling the sandwich to be decorated.
     */
    public Pepperoni(Sandwich filling) {
        this.filling = filling;
        name = "Pepperoni";
        price = 150.00;
    }

    /**
     * Returns the description of the pepperoni.
     * 
     * @return the description of the pepperoni.
     */
    @Override
    public String getDescription() {
        return filling.getDescription() + ", Pepperoni";
    }

}
