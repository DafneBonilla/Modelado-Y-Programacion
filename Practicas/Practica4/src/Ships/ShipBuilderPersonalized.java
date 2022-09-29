package Ships;

import ShipComponents.ShipComponentsFactory.*;

public class ShipBuilderPersonalized extends ShipBuilder {

    @Override
    public Ship build() {
        if (propulsion == null || cabin == null || weapon == null || armor == null) {
            return null;
        }
        return new Ship(this);
    }

    @Override
    public ShipBuilder propulsion(int i) {
        factory = new PropulsionFactory();
        propulsion = factory.createPart(i);
        updateStats(propulsion);
        return this;
    }

    @Override
    public ShipBuilder armor(int i) {
        factory = new ArmorFactory();
        armor = factory.createPart(i);
        updateStats(armor);
        return this;
    }

    @Override
    public ShipBuilder cabin(int i) {
        factory = new CabinFactory();
        cabin = factory.createPart(i);
        updateStats(cabin);
        return this;
    }

    @Override
    public ShipBuilder weapon(int i) {
        factory = new WeaponFactory();
        weapon = factory.createPart(i);
        updateStats(weapon);
        return this;
    }

}
