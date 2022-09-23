package WaySub;

/**
 * Interface to represent a sandwich.
 */
public interface Sandwich {

    /**
     * Returns the price of the sandwich.
     * 
     * @return the price of the sandwich.
     */
    public double getPrice();

    /**
     * Returns the description of the sandwich.
     * 
     * @return the description of the sandwich.
     */
    public String getDescription();

    /**
     * Returns the number of times a ingredients in the sandwich.
     * 
     * @param ing the ingredient to check.
     * @return the number of times the ingredient is in the sandwich.
     */
    public int checkIngredient(String ing);

    /**
     * Returns the name of the sandwich.
     * 
     * @return the name of the sandwich.
     */
    public String getName();

    /**
     * Returns the price of the ingredient.
     * 
     * @return the price of the ingredient.
     */
    public double getIngredientPrice();
}
