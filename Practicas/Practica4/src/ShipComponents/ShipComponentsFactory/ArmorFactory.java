package ShipComponents.ShipComponentsFactory;

import ShipComponents.*;

public class ArmorFactory extends ComponentFactory {

    @Override
    public Component createPart(int i) {
        switch (i) {
            case 1:
                return new ArmorSimple();
            case 2:
                return new ArmorReinforced();
            case 3:
                return new ArmorFortress();
            default:
                return null;
        }
    }

}
