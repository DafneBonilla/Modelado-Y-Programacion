package WaySub;

public class Lettuce extends Ingredient {

    public Lettuce(Sandwich filling) {
        this.filling = filling;
        name = "Lechuga";
        price = 1.00;
    }

    @Override
    public String getDescription() {
        return filling.getDescription() + ", Lechuga";
    }

}
