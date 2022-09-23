package PizzasDonCangrejo;

/**
 * Abstract class to represent a pizza.
 * A pizza has a name, price, meat, cheese and dough.
 */
public abstract class Pizza {

    /* The name of the pizza */
    protected String name;

    /* The price of the pizza. */
    protected double price;

    /* The meat of the pizza */
    protected String meat;

    /* The name of the cheese */
    protected String cheese;

    /* The dough of the pizza */
    protected String dough;

    /**
     * Returns the name of the pizza.
     * 
     * @return the name of the pizza.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the price of the pizza.
     * 
     * @return the price of the pizza.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns the meat of the pizza.
     * 
     * @return the meat of the pizza.
     */
    public String getMeat() {
        return meat;
    }

    /**
     * Returns the cheese of the pizza.
     * 
     * @return the cheese of the pizza.
     */
    public String getCheese() {
        return cheese;
    }

    /**
     * Returns the dough of the pizza.
     * 
     * @return the dough of the pizza.
     */
    public String getDough() {
        return dough;
    }

}
