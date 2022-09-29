package Ships;

import ShipComponents.*;
import ShipComponents.ShipComponentsFactory.*;

public abstract class ShipBuilder {

    protected Component propulsion;

    protected Component armor;

    protected Component cabin;

    protected Component weapon;

    protected ComponentFactory factory;

    protected int atk;

    protected int def;

    protected int spd;

    protected int wt;

    protected double price;

    public abstract Ship build();

    public abstract ShipBuilder propulsion(int i);

    public abstract ShipBuilder armor(int i);

    public abstract ShipBuilder cabin(int i);

    public abstract ShipBuilder weapon(int i);

    protected void updateStats(Component c) {
        atk += c.getAtk();
        def += c.getDef();
        spd += c.getSpd();
        wt += c.getWt();
        price += c.getPrice();
    }

}
