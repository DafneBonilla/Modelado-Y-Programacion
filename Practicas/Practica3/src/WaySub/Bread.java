package WaySub;

public abstract class Bread implements Sandwich {

    protected String name;

    protected double price;

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public int checkIngredient(String ing) {
        if (ing.equals(name)) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String getName() {
        return name;
    }

}
