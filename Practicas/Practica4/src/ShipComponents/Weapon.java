package ShipComponents;

/**
 * Abstract class to represent the weapon component of a ship
 * A weapon has a name, a description, an attack, a defense, a speed, a weight
 * and a price
 */
public abstract class Weapon implements Component {

    /* Name of the weapon */
    protected String name;

    /* Description of the weapon */
    protected String description;

    /* Attack of the weapons */
    protected int atk;

    /* Defense of the weapon */
    protected int def;

    /* Speed of the weapon */
    protected int spd;

    /* Weight of the weapon */
    protected int wt;

    /* Price of the weapon */
    protected double price;

    /**
     * Returns the name of the weapon
     * 
     * @return the name of the weapon
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Returns the description of the weapon
     * 
     * @return the description of the weapon
     */
    @Override
    public String getDescription() {
        return description;
    }

    /**
     * Returns the attack of the weapon
     * 
     * @return the attack of the weapon
     */
    @Override
    public int getAtk() {
        return atk;
    }

    /**
     * Returns the defense of the weapon
     * 
     * @return the defense of the weapon
     */
    @Override
    public int getDef() {
        return def;
    }

    /**
     * Returns the speed of the weapon
     * 
     * @return the speed of the weapon
     */
    @Override
    public int getSpd() {
        return spd;
    }

    /**
     * Returns the weight of the weapon
     * 
     * @return the weight of the weapon
     */
    @Override
    public int getWt() {
        return wt;
    }

    /**
     * Returns the price of the weapon
     * 
     * @return the price of the weapon
     */
    @Override
    public double getPrice() {
        return price;
    }

}
