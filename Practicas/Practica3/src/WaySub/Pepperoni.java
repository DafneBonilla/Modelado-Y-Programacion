package WaySub;

public class Pepperoni extends Ingredient {

    public Pepperoni(Sandwich filling) {
        this.filling = filling;
        name = "Pepperoni";
        price = 1.00;
    }

    @Override
    public String getDescription() {
        return filling.getDescription() + ", Pepperoni";
    }

}
