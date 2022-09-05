public class Action {

    private int actor;

    private String movement;

    private int target;

    public Action(int actor, String movement, int target) {
        this.actor = actor;
        this.movement = movement;
        this.target = target;
    }

    public int getActor() {
        return actor;
    }

    public String getMovement() {
        return movement;
    }

    public int getTarget() {
        return target;
    }

}
