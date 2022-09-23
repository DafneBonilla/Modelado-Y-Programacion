package WaySub;

/**
 * Class to represent mustard.
 */
public class Mustard extends Ingredient {

    /**
     * Constructor for the mustard.
     * 
     * @param filling the sandwich to be decorated.
     */
    public Mustard(Sandwich filling) {
        this.filling = filling;
        name = "Mostaza";
        price = 4.00;
    }

    /**
     * Returns the description of the mustard.
     * 
     * @return the description of the mustard.
     */
    @Override
    public String getDescription() {
        return filling.getDescription() + ", Mostaza";
    }

}
