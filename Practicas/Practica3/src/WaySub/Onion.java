package WaySub;

public class Onion extends Ingredient {

    public Onion(Sandwich filling) {
        this.filling = filling;
        name = "Cebolla";
        price = 1.00;
    }

    @Override
    public String getDescription() {
        return filling.getDescription() + ", Cebolla";
    }

}
