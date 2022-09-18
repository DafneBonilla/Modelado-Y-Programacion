package Dishes;

/**
 * Abstract class to represent a hamburger
 * A hamburger has an id, a name, a description, a price, a cheese boolean and a
 * vegetarian boolean
 */
public abstract class Hamburger implements Dish {

    /* The id of the hamburger */
    protected int id;

    /* The name of the hamburguer */
    protected String name;

    /* The name of the description */
    protected String description;

    /* The price of the hamburguer */
    protected double price;

    /* Boolean to know if the hamburger has cheese */
    protected boolean cheese;

    /* Boolean to know if the hamburger is vegetarian */
    protected boolean vegetarian;

    /**
     * Method to cook the hamburger
     */
    @Override
    public void cook() {
        putBreadBottom();
        putMayonnaise();
        putMustard();
        prepareMeat();
        putMeat();
        putCheese();
        putVegetables();
        putKetchup();
        putBreadTop();
    }

    /**
     * Method to put the bottom bread
     */
    private void putBreadBottom() {
        System.out.println("Poniendo pan inferior");
    }

    /**
     * Method to put the mayonnaise
     */
    private void putMayonnaise() {
        System.out.println("Poniendo mayonesa");
    }

    /**
     * Method to put the mustard
     */
    private void putMustard() {
        System.out.println("Poniendo mostaza");
    }

    /**
     * Method to prepare the meat of the hamburger
     */
    protected abstract void prepareMeat();

    /**
     * Method to put the meat of the hamburger
     */
    protected abstract void putMeat();

    /**
     * Method to put the cheese of the hamburger
     */
    protected abstract void putCheese();

    /**
     * Method to put the vegetables of the hamburger
     */
    protected abstract void putVegetables();

    /**
     * Method to put the ketchup of the hamburger
     */
    private void putKetchup() {
        System.out.println("Poniendo ketchup");
    }

    /**
     * Method to put the top bread of the hamburger
     */
    private void putBreadTop() {
        System.out.println("Poniendo pan superior");
    }

    /**
     * Returns the id of the hamburger
     * 
     * @return the id of the hamburger
     */
    @Override
    public int getID() {
        return id;
    }

    /**
     * Sets the id of the hamburger
     * 
     * @param id the id of the hamburger
     */
    @Override
    public void setID(int id) {
        this.id = id;
    }

    /**
     * Returns the name of the hamburger
     * 
     * @return the name of the hamburger
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the hamburger
     * 
     * @param name the name of the hamburger
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the description of the hamburger
     * 
     * @return the description of the hamburger
     */
    @Override
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the hamburger
     * 
     * @param description the description of the hamburger
     */
    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the price of the hamburger
     * 
     * @return the price of the hamburger
     */
    @Override
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the hamburger
     * 
     * @param price the price of the hamburger
     */
    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Returns the cheese boolean of the hamburger
     * 
     * @return the cheese boolean of the hamburger
     */
    @Override
    public boolean hasCheese() {
        return cheese;
    }

    /**
     * Sets the cheese boolean of the dish
     * 
     * @param cheese the cheese boolean of the dish
     */
    @Override
    public void setCheese(boolean cheese) {
        this.cheese = cheese;
    }

    /**
     * Returns the vegetarian boolean of the hamburger
     * 
     * @return the vegetarian boolean of the hamburger
     */
    @Override
    public boolean isVegetarian() {
        return vegetarian;
    }

    /**
     * Sets the vegetarian boolean of the hamburger
     * 
     * @param vegetarian the vegetarian boolean of the hamburger
     */
    @Override
    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

}
