package ShipComponents.ShipComponentsFactory;

import ShipComponents.*;

public class CabinFactory extends ComponentFactory {

    @Override
    public Component build(int i) {
        switch (i) {
            case 1:
                return new CabinOnepilot();
            case 2:
                return new CabinSmallcrew();
            case 3:
                return new CabinArmy();
            default:
                return null;
        }
    }

}
