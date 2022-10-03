package ShipComponents;

/**
 * Abstract class to represent the armor component of a ship
 * A armor has a name, a description, an attack, a defense, a speed, a weight
 * and a price
 */
public abstract class Armor implements Component {

    /* Name of the armor */
    protected String name;

    /* Description of the armor */
    protected String description;

    /* Attack of the armor */
    protected int atk;

    /* Defense of the armor */
    protected int def;

    /* Speed of the armor */
    protected int spd;

    /* Weight of the armor */
    protected int wt;

    /* Price of the armor */
    protected double price;

    /**
     * Returns the name of the armor
     * 
     * @return the name of the armor
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Returns the description of the armor
     * 
     * @return the description of the armor
     */
    @Override
    public String getDescription() {
        return description;
    }

    /**
     * Returns the attack of the armor
     * 
     * @return the attack of the armor
     */
    @Override
    public int getAtk() {
        return atk;
    }

    /**
     * Returns the defense of the armor
     * 
     * @return the defense of the armor
     */
    @Override
    public int getDef() {
        return def;
    }

    /**
     * Returns the speed of the armor
     * 
     * @return the speed of the armor
     */
    @Override
    public int getSpd() {
        return spd;
    }

    /**
     * Returns the weight of the armor
     * 
     * @return the weight of the armor
     */
    @Override
    public int getWt() {
        return wt;
    }

    /**
     * Returns the price of the armor
     * 
     * @return the price of the armor
     */
    @Override
    public double getPrice() {
        return price;
    }

}
