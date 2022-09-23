package WaySub;

/**
 * Class to represent a white bread.
 */
public class BreadWhite extends Bread {

    /**
     * Constructor for the white bread.
     */
    public BreadWhite() {
        name = "Blanco";
        price = 10.00;
    }

    /**
     * Returns the description of the bread.
     * 
     * @return the description of the bread.
     */
    @Override
    public String getDescription() {
        return "Sandwich de Pan Blanco";
    }

}
