package WaySub;

public class Mustard extends Ingredient {

    public Mustard(Sandwich filling) {
        this.filling = filling;
        name = "Mostaza";
        price = 1.00;
    }

    @Override
    public String getDescription() {
        return filling.getDescription() + ", Mostaza";
    }

}
