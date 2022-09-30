package ShipComponents.ShipComponentsFactory;

import ShipComponents.*;

public class PropulsionFactory extends ComponentFactory {

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
