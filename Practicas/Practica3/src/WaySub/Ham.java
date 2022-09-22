package WaySub;

public class Ham extends Ingredient {

    public Ham(Sandwich filling) {
        this.filling = filling;
        name = "Jamon";
        price = 1.00;
    }

    @Override
    public String getDescription() {
        return filling.getDescription() + ", Jamon";
    }

}
