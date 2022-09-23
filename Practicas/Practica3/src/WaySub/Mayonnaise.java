package WaySub;

/**
 * Class to represent mayonnaise.
 */
public class Mayonnaise extends Ingredient {

    /**
     * Constructor for the mayonnaise.
     * 
     * @param filling the sandwich to be decorated.
     */
    public Mayonnaise(Sandwich filling) {
        this.filling = filling;
        name = "Mayonesa";
        price = 3.00;
    }

    /**
     * Returns the description of the mayonaisse.
     * 
     * @return the description of the mayonnaise.
     */
    @Override
    public String getDescription() {
        return filling.getDescription() + ", Mayonesa";
    }

}
