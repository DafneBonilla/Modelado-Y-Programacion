package Ships;

import Parts.Component;

public abstract class ShipBuilder {

    protected Component propulsion;

    protected Component armor;

    protected Component cabin;

    protected Component weapon;

    protected int atk;

    protected int def;

    protected int spd;

    protected int wt;

    protected double price;

    public abstract Ship build();

    public abstract ShipBuilder propulsion(Component prop);

    public abstract ShipBuilder armor(Component arm);

    public abstract ShipBuilder cabin(Component cab);

    public abstract ShipBuilder weapon(Component wep);

}
