package WaySub;

public class Mayonnaise extends Ingredient {

    public Mayonnaise(Sandwich filling) {
        this.filling = filling;
        name = "Mayonesa";
        price = 1.00;
    }

    @Override
    public String getDescription() {
        return filling.getDescription() + ", Mayonesa";
    }

}
