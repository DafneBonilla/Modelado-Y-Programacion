package Dishes;

public interface Dish {

    public void cook();

    public int getID();

    public void setID(int id);

    public String getName();

    public void setName(String name);

    public String getDescription();

    public void setDescription(String description);

    public double getPrice();

    public void setPrice(double price);

    public boolean hasCheese();

    public void setCheese(boolean cheese);

    public boolean isVegetarian();

    public void setVegetarian(boolean vegetarian);

}
