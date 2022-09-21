package WaySub;

public abstract class Bread implements Sandwich {

    protected String name;

    protected double price;

    protected String description;

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int checkIngredient(String ing) {
        if (ing.equals(name)) {
            return 1;
        } else {
            return 0;
        }
    }

    public String getName() {
        return name;
    }

}
