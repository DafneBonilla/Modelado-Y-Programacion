import java.util.ArrayList;
import java.util.List;

/**
 * Class to represent a case of the game
 * A case has a list of actions and a maximum number of actions
 */
public class Case1 implements RiggedFight {

    /* List of actions of the case */
    private List<Action> actions = new ArrayList<Action>();
    /* Maximum number of actions of the case */
    private int maxRounds;

    /**
     * Constructor of the case
     */
    public Case1() {
        actions = new ArrayList<Action>();

        actions.add(new Action(0, "a", 1));
        actions.add(new Action(1, "a", 2));
        actions.add(new Action(2, "t", -1));

        actions.add(new Action(0, "d", -1));
        actions.add(new Action(1, "t", -1));
        actions.add(new Action(2, "a", 0));

        actions.add(new Action(0, "t", -1));
        actions.add(new Action(1, "a", 2));
        actions.add(new Action(2, "a", 0));

        actions.add(new Action(0, "a", 2));
        actions.add(new Action(1, "a", 2));
        actions.add(new Action(2, "t", -1));

        maxRounds = actions.size() + 1;
    }

    /**
     * Returns the next action to be executed
     * 
     * @return the next action
     */
    @Override
    public Action getAction() {
        if (actions.size() == 0) {
            return null;
        }
        Action actual = actions.get(0);
        actions.remove(0);
        return actual;
    }

    /**
     * Returns the maximum number of actions of the case
     * 
     * @return the maximum number of actions of the case
     */
    @Override
    public int getMaxRounds() {
        return maxRounds;
    }

}
