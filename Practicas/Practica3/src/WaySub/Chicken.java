package WaySub;

public class Chicken extends Ingredient {

    public Chicken(Sandwich filling) {
        this.filling = filling;
        name = "Pollo";
        price = 1.00;
    }

    @Override
    public String getDescription() {
        return filling.getDescription() + ", Pollo";
    }

}
