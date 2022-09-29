package ShipComponents.ShipComponentsFactory;

import ShipComponents.*;

public class PropulsionFactory extends ComponentFactory {

    @Override
    public Component build(int i) {
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
