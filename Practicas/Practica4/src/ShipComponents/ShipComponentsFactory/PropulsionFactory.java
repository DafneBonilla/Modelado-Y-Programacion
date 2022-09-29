package ShipComponents.ShipComponentsFactory;

import ShipComponents.*;

public class PropulsionFactory extends ComponentFactory {

    @Override
    public Component createPart(int i) {
        switch (i) {
            case 1:
                return new PropulsionIntercontinental();
            case 2:
                return new PropulsionInterplanetary();
            case 3:
                return new PropulsionIntergalactic();
            default:
                return null;
        }
    }

}
