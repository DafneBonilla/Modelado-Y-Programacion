/**
 * Interface for the order of the fight
 */
public interface RiggedFight {

    /**
     * Returns the next action to be executed
     * 
     * @return the next action
     */
    public Action getAction();

    /**
     * Returns the maximum number of actions
     * 
     * @return the maximum number of actions
     */
    public int getMaxRounds();

}
