package WaySub;

/**
 * Class to represent an oat bread.
 */
public class BreadOat extends Bread {

    /**
     * Constructor for the oat bread.
     */
    public BreadOat() {
        name = "Avena";
        price = 15.00;
    }

    /**
     * Returns the description of the bread.
     * 
     * @return the description of the bread.
     */
    @Override
    public String getDescription() {
        return "Sandwich de Pan de Avena";
    }
}
