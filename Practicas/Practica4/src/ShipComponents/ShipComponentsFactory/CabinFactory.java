package ShipComponents.ShipComponentsFactory;

import ShipComponents.*;

public class CabinFactory extends ComponentFactory {

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
