package ShipComponents.ShipComponentsFactory;

import ShipComponents.*;

/**
 * Class to represent a component factory that builds the different types of
 * armor components
 */
public class ArmorFactory extends ComponentFactory {

    /**
     * Builds a armor
     * 
     * @param i integer for the factory to create the armor
     * @return the armor built
     */
    @Override
    public Component build(int i) {
        switch (i) {
            case 0:
                return new ArmorSimple();
            case 1:
                return new ArmorReinforced();
            case 2:
                return new ArmorFortress();
            default:
                return null;
        }
    }

}
