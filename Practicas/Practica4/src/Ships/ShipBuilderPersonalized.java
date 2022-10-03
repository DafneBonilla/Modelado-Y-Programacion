package Ships;

import ShipComponents.ShipComponentsFactory.*;

/**
 * Class to represent a ship builder, it builds a ship based on what a client
 * wants
 */
public class ShipBuilderPersonalized extends ShipBuilder {

    /**
     * Builds a ship with the components of the builder
     * 
     * @return the ship built
     */
    @Override
    public Ship build() {
        if (propulsion == null || cabin == null || weapon == null || armor == null) {
            System.out.println("algo paso");
            return null;
        }
        return new Ship(this);
    }

    /**
     * Sets the propulsion of the ship to build
     * 
     * @param i integer for the factory to create the propulsion
     * @return the ship builder with the propulsion set
     */
    @Override
    public ShipBuilder propulsion(int i) {
        factory = new PropulsionFactory();
        propulsion = factory.build(i);
        updateStats(propulsion);
        return this;
    }

    /**
     * Sets the armor of the ship to build
     * 
     * @param i integer for the factory to create the armor
     * @return the ship builder with the armor set
     */
    @Override
    public ShipBuilder armor(int i) {
        factory = new ArmorFactory();
        armor = factory.build(i);
        updateStats(armor);
        return this;
    }

    /**
     * Sets the cabin of the ship to build
     * 
     * @param i integer for the factory to create the cabin
     * @return the ship builder with the cabin set
     */
    @Override
    public ShipBuilder cabin(int i) {
        factory = new CabinFactory();
        cabin = factory.build(i);
        updateStats(cabin);
        return this;
    }

    /**
     * Sets the weapon of the ship to build
     * 
     * @param i integer for the factory to create the weapon
     * @return the ship builder with the weapon set
     */
    @Override
    public ShipBuilder weapon(int i) {
        factory = new WeaponFactory();
        weapon = factory.build(i);
        updateStats(weapon);
        return this;
    }

}
