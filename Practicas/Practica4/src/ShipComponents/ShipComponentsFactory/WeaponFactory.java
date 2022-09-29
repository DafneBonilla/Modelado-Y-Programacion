package ShipComponents.ShipComponentsFactory;

import ShipComponents.*;

public class WeaponFactory extends ComponentFactory {

    @Override
    public Component createPart(int i) {
        switch (i) {
            case 1:
                return new WeaponSinglelaser();
            case 2:
                return new WeaponPlasmamissiles();
            case 3:
                return new WeaponDeathlaser();
            default:
                return null;
        }
    }

}
