package WaySub;

/**
 * Class to represent an oregano bread.
 */
public class BreadOregano extends Bread {

    /**
     * Constructor for the oregano bread.
     */
    public BreadOregano() {
        name = "Oregano";
        price = 20.00;
    }

    /**
     * Returns the description of the bread.
     * 
     * @return the description of the bread.
     */
    @Override
    public String getDescription() {
        return "Sandwich de Pan de Oregano";
    }

}
