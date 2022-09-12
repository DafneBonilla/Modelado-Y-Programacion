package Dishes;

public abstract class Hamburger implements Dish {

    protected int id;

    protected String name;

    protected String description;

    protected double price;

    protected boolean cheese;

    protected boolean vegetarian;

    @Override
    public void cook() {
        putBreadBottom();
        putMayonnaise();
        putMustard();
        prepareMeat();
        putMeat();
        prepareVegeterianMeat();
        putVegeterianMeat();
        putCheese();
        putVegetables();
        putKetchup();
        putBreadTop();
    }

    private void putBreadBottom() {
        System.out.println("Poniendo pan inferior");
    }

    private void putMayonnaise() {
        System.out.println("Poniendo mayonesa");
    }

    private void putMustard() {
        System.out.println("Poniendo mostaza");
    }

    protected abstract void prepareMeat();

    protected abstract void putMeat();

    protected abstract void prepareVegeterianMeat();

    protected abstract void putVegeterianMeat();

    protected abstract void putCheese();

    private void putVegetables() {
        System.out.println("Poniendo lechuga");
    }

    private void putKetchup() {
        System.out.println("Poniendo ketchup");
    }

    private void putBreadTop() {
        System.out.println("Poniendo pan superior");
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public void setID(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean hasCheese() {
        return cheese;
    }

    @Override
    public void setCheese(boolean cheese) {
        this.cheese = cheese;
    }

    @Override
    public boolean isVegetarian() {
        return vegetarian;
    }

    @Override
    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

}
