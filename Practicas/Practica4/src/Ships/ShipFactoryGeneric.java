package Ships;

public class ShipFactoryGeneric extends ShipFactory {

    public ShipFactoryGeneric() {
        builder = new ShipBuilderPersonalized();
    }

    @Override
    public Ship build(int i) {
        builder = builder.propulsion(i);
        builder = builder.armor(i);
        builder = builder.cabin(i);
        builder = builder.weapon(i);
        return builder.build();
    }

}
