package WaySub;

public class Tomato extends Ingredient {

    public Tomato(Sandwich filling) {
        this.filling = filling;
        name = "Jitomate";
        price = 1.00;
    }

    @Override
    public String getDescription() {
        return filling.getDescription() + ", Jitomate";
    }

}
