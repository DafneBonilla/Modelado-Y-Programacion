package ShipComponents;

/**
 * Abstract class to represent the cabin component of a ship
 * A cabin has a name, a description, an attack, a defense, a speed, a weight
 * and a price
 */
public abstract class Cabin implements Component {

    /* Name of the cabin */
    protected String name;

    /* Description of the cabin */
    protected String description;

    /* Attack of the cabin */
    protected int atk;

    /* Defense of the cabin */
    protected int def;

    /* Speed of the cabin */
    protected int spd;

    /* Weight of the cabin */
    protected int wt;

    /* Price of the cabin */
    protected double price;

    /**
     * Returns the name of the cabin
     * 
     * @return the name of the cabin
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Returns the description of the cabin
     * 
     * @return the description of the cabin
     */
    @Override
    public String getDescription() {
        return description;
    }

    /**
     * Returns the attack of the cabin
     * 
     * @return the attack of the cabin
     */
    @Override
    public int getAtk() {
        return atk;
    }

    /**
     * Returns the defense of the cabin
     * 
     * @return the defense of the cabin
     */
    @Override
    public int getDef() {
        return def;
    }

    /**
     * Returns the speed of the cabin
     * 
     * @return the speed of the cabin
     */
    @Override
    public int getSpd() {
        return spd;
    }

    /**
     * Returns the weight of the cabin
     * 
     * @return the weight of the cabin
     */
    @Override
    public int getWt() {
        return wt;
    }

    /**
     * Returns the price of the cabin
     * 
     * @return the price of the cabin
     */
    @Override
    public double getPrice() {
        return price;
    }

}
