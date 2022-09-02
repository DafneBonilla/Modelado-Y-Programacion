public interface SpSkill<T extends Fighter> {

    public int getAtkBoost();

    public int getDefBoost();

    public int hit(Fighter target);

    public int defend();

    public String getName();

}
