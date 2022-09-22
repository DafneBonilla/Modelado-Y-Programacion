package WaySub;

public abstract class Ingredient implements Sandwich {

    protected String name;

    protected double price;

    protected Sandwich filling;

    @Override
    public double getPrice() {
        return price + filling.getPrice();
    }

    @Override
    public int checkIngredient(String ing) {
        if (ing.equals(name)) {
            return 1 + filling.checkIngredient(ing);
        } else {
            return filling.checkIngredient(ing);
        }
    }

    public String getName() {
        return name;
    }

    public Sandwich getFilling() {
        return filling;
    }

}
