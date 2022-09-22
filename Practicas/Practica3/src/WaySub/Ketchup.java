package WaySub;

public class Ketchup extends Ingredient {

    public Ketchup(Sandwich filling) {
        this.filling = filling;
        name = "Catsup";
        price = 1.00;
    }

    @Override
    public String getDescription() {
        return filling.getDescription() + ", Catsup";
    }

}
