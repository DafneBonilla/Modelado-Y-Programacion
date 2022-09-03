import java.util.ArrayList;
import java.util.List;

public class Case1 implements RiggedFight {

    private List<Action> actions = new ArrayList<Action>();

    private int maxRounds;

    public Case1() {
        List<Action> actions = new ArrayList<Action>();

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

    @Override
    public Action getAction() {
        Action actual = actions.get(0);
        actions.remove(0);
        return actual;
    }

    @Override
    public int getMaxRounds() {
        return maxRounds;
    }
    
}
