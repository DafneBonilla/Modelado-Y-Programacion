package Ships;

/**
 * Class to represent a ship factory, it builds ships for the store catalog
 */
public class ShipFactoryGeneric extends ShipFactory {

    /**
     * Constructor of the generic ship factory
     */
    public ShipFactoryGeneric() {
        builder = new ShipBuilderPersonalized();
    }

    /**
     * Builds a predefined ship
     * 
     * @param i the index of the ship to build
     * @return the ship built
     */
    @Override
    public Ship build(int i) {
        builder = builder.propulsion(i);
        builder = builder.armor(i);
        builder = builder.cabin(i);
        builder = builder.weapon(i);
        return builder.build();
    }

}
