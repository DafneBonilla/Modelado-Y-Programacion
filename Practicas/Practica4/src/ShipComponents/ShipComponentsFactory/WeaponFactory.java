package ShipComponents.ShipComponentsFactory;

import ShipComponents.*;

/**
 * Class to represent a component factory that builds the different types of
 * weapon components
 */
public class WeaponFactory extends ComponentFactory {

    /**
     * Builds a weapon
     * 
     * @param i integer for the factory to create the weapon
     * @return the weapon built
     */
    @Override
    public Component build(int i) {
        switch (i) {
            case 0:
                return new WeaponSinglelaser();
            case 1:
                return new WeaponPlasmamissiles();
            case 2:
                return new WeaponDeathlaser();
            default:
                return null;
        }
    }

}
