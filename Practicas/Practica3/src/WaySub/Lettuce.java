package WaySub;

/**
 * Class to represent lettuce.
 */
public class Lettuce extends Ingredient {

    /**
     * Constructor for the lettuce.
     * 
     * @param filling the sandwich to be decorated.
     */
    public Lettuce(Sandwich filling) {
        this.filling = filling;
        name = "Lechuga";
        price = 8.00;
    }

    /**
     * Returns the description of the lettuce.
     * 
     * @return the description of the lettuce.
     */
    @Override
    public String getDescription() {
        return filling.getDescription() + ", Lechuga";
    }

}
