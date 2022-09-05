/*+
 * Class to represent the special skill of a fighter
 * The special skill has a name, an attack boost, a defense boost, and an owner
 */
public abstract class SpSkill<T extends Fighter> {

    /* The attack boost of the skill */
    protected int atkBoost;
    /* The defense boost of the skill */
    protected int defBoost;
    /* The name of the skill */
    protected String name;
    /* The owner of the skill */
    protected Fighter owner;

    /**
     * Returns the attack boost of the skill
     * 
     * @return the attack boost of the skill
     */
    public int getAtkBoost() {
        return atkBoost;
    }

    /**
     * Returns the defense boost of the skill
     * 
     * @return the defense boost of the skill
     */
    public int getDefBoost() {
        return defBoost;
    }

    /**
     * Returns the damage that the skill will do to the target
     * 
     * @param target the target of the hit
     * @return the damage that the skill will do to the target
     */
    public abstract int hit(Fighter target);

    /**
     * Returns the amount of block that the skill will give to the owner
     * 
     * @return the amount of block that the skill will give to the owner
     */
    public abstract int defend();

    /**
     * Returns the name of the skill
     * 
     * @return the name of the skill
     */
    public String getName() {
        return name;
    }

    /**
     * Returns a description of the skill, this description contains the name, the
     * attack boost, the defense boost, and the special effect
     * 
     * @return a description of the skill
     */
    public abstract String getDescription();

}
