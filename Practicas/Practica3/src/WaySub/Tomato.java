package WaySub;

/**
 * Class to represent tomato.
 */
public class Tomato extends Ingredient {

    /**
     * Constructor for the tomato.
     * 
     * @param filling the sandwich to be decorated.
     */
    public Tomato(Sandwich filling) {
        this.filling = filling;
        name = "Jitomate";
        price = 7.00;
    }

    /**
     * Returns the description of the tomato.
     * 
     * @return the description of the tomato.
     */
    @Override
    public String getDescription() {
        return filling.getDescription() + ", Jitomate";
    }

}
