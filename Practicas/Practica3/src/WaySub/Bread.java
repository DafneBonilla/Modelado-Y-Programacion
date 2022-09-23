package WaySub;

/**
 * Abstract class to represent a bread.
 * A bread has a name and a price.
 */
public abstract class Bread implements Sandwich {

    /* The name of the bread */
    protected String name;

    /* The price of the bread */
    protected double price;

    /**
     * Returns the price of the bread.
     * 
     * @return the price of the bread.
     */
    @Override
    public double getPrice() {
        return price;
    }

    /**
     * Returns the number of times a ingredients in the bread.
     * 
     * @param ing the ingredient to check.
     * @return the number of times the ingredient is in the bread.
     */
    @Override
    public int checkIngredient(String ing) {
        if (ing.equals(name)) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Returns the name of the bread.
     * 
     * @return the name of the bread.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Returns the price of the bread.
     * 
     * @return the price of the bread.
     */
    @Override
    public double getIngredientPrice() {
        return price;
    }

}
