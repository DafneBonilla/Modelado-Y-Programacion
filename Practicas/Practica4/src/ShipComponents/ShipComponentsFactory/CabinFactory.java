package ShipComponents.ShipComponentsFactory;

import ShipComponents.*;

/**
 * Class to represent a component factory that builds the different types of
 * cabin components
 */
public class CabinFactory extends ComponentFactory {

    /**
     * Builds a cabin
     * 
     * @param i integer for the factory to create the cabin
     * @return the cabin built
     */
    @Override
    public Component build(int i) {
        switch (i) {
            case 0:
                return new CabinOnepilot();
            case 1:
                return new CabinSmallcrew();
            case 2:
                return new CabinArmy();
            default:
                return null;
        }
    }

}
