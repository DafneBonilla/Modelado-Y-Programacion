package ShipComponents;

/**
 * Abstract class to represent the propulsion component of a ship
 * A propulsion has a name, a description, an attack, a defense, a speed, a
 * weight and a price
 */
public abstract class Propulsion implements Component {

    /* Name of the propulsion */
    protected String name;

    /* Description of the propulsion */
    protected String description;

    /* Attack of the propulsion */
    protected int atk;

    /* Defense of the propulsion */
    protected int def;

    /* Speed of the propulsion */
    protected int spd;

    /* Weight of the propulsion */
    protected int wt;

    /* Price of the propulsion */
    protected double price;

    /**
     * Returns the name of the propulsion
     * 
     * @return the name of the propulsion
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Returns the description of the propulsion
     * 
     * @return the description of the propulsion
     */
    @Override
    public String getDescription() {
        return description;
    }

    /**
     * Returns the attack of the propulsion
     * 
     * @return the attack of the propulsion
     */
    @Override
    public int getAtk() {
        return atk;
    }

    /**
     * Returns the defense of the propulsion
     * 
     * @return the defense of the propulsion
     */
    @Override
    public int getDef() {
        return def;
    }

    /**
     * Returns the speed of the propulsion
     * 
     * @return the speed of the propulsion
     */
    @Override
    public int getSpd() {
        return spd;
    }

    /**
     * Returns the weight of the propulsion
     * 
     * @return the weight of the propulsion
     */
    @Override
    public int getWt() {
        return wt;
    }

    /**
     * Returns the price of the propulsion
     * 
     * @return the price of the propulsion
     */
    @Override
    public double getPrice() {
        return price;
    }

}
