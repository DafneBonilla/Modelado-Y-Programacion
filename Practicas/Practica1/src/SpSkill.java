public abstract class SpSkill<T extends Fighter<T>> {

    protected int atkBoost;

    protected int defBoost;

    protected String name;

    public int getAtkBoost() {
        return atkBoost;
    }

    public int getDefBoost() {
        return defBoost;
    }

    public abstract int hit(Fighter<T> target);

    public abstract int defend();

    public String getName() {
        return name;
    }

}
