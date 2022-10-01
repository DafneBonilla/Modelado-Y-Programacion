package Ships;

/**
 * Abstract class to represent a factory of the class {@link Ship}
 * It has an instance of the class {@link ShipBuilder} to build the ship
 * The factory is used to create predefined ships
 */
public abstract class ShipFactory {

    /* Ship builder of the factory */
    protected ShipBuilder builder;

    /**
     * Builds a predefined ship
     * 
     * @return the ship built
     */
    public abstract Ship build(int i);

}
