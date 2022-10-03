package Ships;

import ShipComponents.*;
import ShipComponents.ShipComponentsFactory.*;

/**
 * Abstract class to represent a builder of the class {@link Ship}
 * A ship builder has a propulsion, an armor, a cabin and a weapon (all of them
 * are an instance of {@link Component}), it has an instance of the class
 * {@link ComponentFactory} to build the components of the ship, also has
 * values for attack, defense, speed, weight and price
 */
public abstract class ShipBuilder {

    /* Propulsion of the ship to build */
    protected Component propulsion;

    /* Armor of the ship to build */
    protected Component armor;

    /* Cabin of the ship to build */
    protected Component cabin;

    /* Weapon of the ship to build */
    protected Component weapon;

    /* Component factory of the builder */
    protected ComponentFactory factory;

    /* Attack of the ship to build */
    protected int atk;

    /* Defense of the ship to build */
    protected int def;

    /* Speed of the ship to build */
    protected int spd;

    /* Weight of the ship to build */
    protected int wt;

    /* Price of the ship to build */
    protected double price;

    /**
     * Builds a ship with the components of the builder
     * 
     * @return the ship built
     */
    public abstract Ship build();

    /**
     * Sets the propulsion of the ship to build
     * 
     * @param i integer for the factory to create the propulsion
     * @return the ship builder with the propulsion set
     */
    public abstract ShipBuilder propulsion(int i);

    /**
     * Sets the armor of the ship to build
     * 
     * @param i integer for the factory to create the armor
     * @return the ship builder with the armor set
     */
    public abstract ShipBuilder armor(int i);

    /**
     * Sets the cabin of the ship to build
     * 
     * @param i integer for the factory to create the cabin
     * @return the ship builder with the cabin set
     */
    public abstract ShipBuilder cabin(int i);

    /**
     * Sets the weapon of the ship to build
     * 
     * @param i integer for the factory to create the weapon
     * @return the ship builder with the weapon set
     */
    public abstract ShipBuilder weapon(int i);

    /**
     * Updates the values of the ship to build based on a new component
     * 
     * @param c the new component
     */
    protected void updateStats(Component c) {
        if (c != null) {
            atk += c.getAtk();
            def += c.getDef();
            spd += c.getSpd();
            wt += c.getWt();
            price += c.getPrice();
        }
    }

}
