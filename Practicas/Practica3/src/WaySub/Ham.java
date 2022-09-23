package WaySub;

/**
 * Class to represent ham.
 */
public class Ham extends Ingredient {

    /**
     * Constructor for the ham.
     * 
     * @param filling the sandwich to be decorated.
     */
    public Ham(Sandwich filling) {
        this.filling = filling;
        name = "Jamon";
        price = 7.00;
    }

    /**
     * Returns the description of the ham.
     * 
     * @return the description of the ham.
     */
    @Override
    public String getDescription() {
        return filling.getDescription() + ", Jamon";
    }

}
