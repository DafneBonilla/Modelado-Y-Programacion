package ShipComponents.ShipComponentsFactory;

import ShipComponents.*;

public class WeaponFactory extends ComponentFactory {

    @Override
    public Component build(int i) {
        switch (i) {
            case 0:
                return new WeaponSinglelaser();
            case 1:
                return new WeaponPlasmamissiles();
            case 2:
                return new WeaponDeathlaser();
            default:
                return null;
        }
    }

}
