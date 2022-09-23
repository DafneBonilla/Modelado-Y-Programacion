package WaySub;

/**
 * Abstract class to represent a ingredient.
 * A ingredient has a name, a price andn a filling.
 */
public abstract class Ingredient implements Sandwich {

    /* The name of the ingredient. */
    protected String name;

    /* The price of the ingredient. */
    protected double price;

    /* The filling of the ingredient. */
    protected Sandwich filling;

    /**
     * Returns the price of the ingredient.
     * 
     * @return the price of the ingredient.
     */
    @Override
    public double getPrice() {
        return price + filling.getPrice();
    }

    /**
     * Returns the number of times a ingredients in the ingredient.
     * 
     * @param ing the ingredient to check.
     * @return the number of times the ingredient is in the ingredient.
     */
    @Override
    public int checkIngredient(String ing) {
        if (ing.equals(name)) {
            return 1 + filling.checkIngredient(ing);
        } else {
            return filling.checkIngredient(ing);
        }
    }

    /**
     * Returns the name of the ingredient.
     * 
     * @return the name of the ingredient.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the filling of the ingredient.
     * 
     * @return the filling of the ingredient.
     */
    public Sandwich getFilling() {
        return filling;
    }

    /**
     * Returns the price of just the ingredient.
     * 
     * @return the price of just the ingredient.
     */
    @Override
    public double getIngredientPrice() {
        return price;
    }

}
