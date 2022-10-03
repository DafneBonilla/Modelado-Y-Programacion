package ShipComponents.ShipComponentsFactory;

import ShipComponents.*;

/**
 * Class to represent a component factory that builds the different types of
 * propulsion components
 */
public class PropulsionFactory extends ComponentFactory {

    /**
     * Builds a propulsion
     * 
     * @param i integer for the factory to create the propulsion
     * @return the propulsion built
     */
    @Override
    public Component build(int i) {
        switch (i) {
            case 0:
                return new PropulsionIntercontinental();
            case 1:
                return new PropulsionInterplanetary();
            case 2:
                return new PropulsionIntergalactic();
            default:
                return null;
        }
    }

}
