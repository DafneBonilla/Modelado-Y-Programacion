package ShipComponents;

/**
 * Interface to represent a component of a ship
 */
public interface Component {

    /**
     * Returns the name of the component
     * 
     * @return the name of the component
     */
    public String getName();

    /**
     * Returns the description of the component
     * 
     * @return the description of the component
     */
    public String getDescription();

    /**
     * Returns the attack of the component
     * 
     * @return the attack of the component
     */
    public int getAtk();

    /**
     * Returns the defense of the component
     * 
     * @return the defense of the component
     */
    public int getDef();

    /**
     * Returns the speed of the component
     * 
     * @return the speed of the component
     */
    public int getSpd();

    /**
     * Returns the weight of the component
     * 
     * @return the weight of the component
     */
    public int getWt();

    /**
     * Returns the price of the ship
     * 
     * @return price of the ship
     */
    public double getPrice();

}
