package Dishes;

/**
 * Interface to represent a dish
 * A dish has an id, a name, a description, a price, a cheese boolean and a
 * vegetarian boolean
 */
public interface Dish {

    /**
     * Method to cook the dish
     */
    public void cook();

    /**
     * Returns a dish in string format
     * 
     * @return a dish in string format
     */
    @Override
    public String toString();

    /**
     * Returns the id of the dish
     * 
     * @return the id of the dish
     */
    public int getID();

    /**
     * Sets the id of the dish
     * 
     * @param id the id of the dish
     */
    public void setID(int id);

    /**
     * Returns the name of the dish
     * 
     * @return the name of the dish
     */
    public String getName();

    /**
     * Sets the name of the dish
     * 
     * @param name the name of the dish
     */
    public void setName(String name);

    /**
     * Returns the description of the dish
     * 
     * @return the description of the dish
     */
    public String getDescription();

    /**
     * Sets the description of the dish
     * 
     * @param description the description of the dish
     */
    public void setDescription(String description);

    /**
     * Returns the price of the dish
     * 
     * @return the price of the dish
     */
    public double getPrice();

    /**
     * Sets the price of the dish
     * 
     * @param price the price of the dish
     */
    public void setPrice(double price);

    /**
     * Returns the cheese boolean of the dish
     * 
     * @return the cheese boolean of the dish
     */
    public boolean hasCheese();

    /**
     * Sets the cheese boolean of the dish
     * 
     * @param cheese the cheese boolean of the dish
     */
    public void setCheese(boolean cheese);

    /**
     * Returns the vegetarian boolean of the dish
     * 
     * @return the vegetarian boolean of the dish
     */
    public boolean isVegetarian();

    /**
     * Sets the vegetarian boolean of the dish
     * 
     * @param vegetarian the vegetarian boolean of the dish
     */
    public void setVegetarian(boolean vegetarian);

}
