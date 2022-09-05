/**
 * Class to represent the action of a fighter
 * An action has an actor, a target and a type
 * The type can be attack ("a"), defend ("d") or transform ("t")
 */
public class Action {

    /* Actor of the action */
    private int actor;
    /* Type of the action */
    private String movement;
    /* Target of the action */
    private int target;

    /**
     * Constructor of the action
     * 
     * @param actor    the actor of the action
     * @param movement the type of the action
     * @param target   the target of the action
     */
    public Action(int actor, String movement, int target) {
        this.actor = actor;
        this.movement = movement;
        this.target = target;
    }

    /**
     * Returns the actor of the action
     * 
     * @return the actor of the action
     */
    public int getActor() {
        return actor;
    }

    /**
     * Returns the type of the action
     * 
     * @return the type of the action
     */
    public String getMovement() {
        return movement;
    }

    /**
     * Returns the target of the action
     * 
     * @return the target of the action
     */
    public int getTarget() {
        return target;
    }

}
