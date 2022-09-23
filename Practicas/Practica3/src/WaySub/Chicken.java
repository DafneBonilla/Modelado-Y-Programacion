package WaySub;

/**
 * Class to represent chicken.
 */
public class Chicken extends Ingredient {

    /**
     * Constructor for the chicken.
     * 
     * @param filling the sandwich to be decorated.
     */
    public Chicken(Sandwich filling) {
        this.filling = filling;
        name = "Pollo";
        price = 10.00;
    }

    /**
     * Returns the description of the chicken.
     * 
     * @return the description of the chicken.
     */
    @Override
    public String getDescription() {
        return filling.getDescription() + ", Pollo";
    }

}
