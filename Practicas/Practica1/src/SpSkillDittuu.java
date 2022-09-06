/*+
 * Interface to represent the special skill of a Dittuu
 */
public interface SpSkillDittuu {

    /**
     * Returns the attack boost of the skill
     * 
     * @return the attack boost of the skill
     */
    public abstract int getAtkBoost();

    /**
     * Returns the defense boost of the skill
     * 
     * @return the defense boost of the skill
     */
    public abstract int getDefBoost();

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
    public abstract String getName();

    /**
     * Returns a description of the skill, this description contains the name, the
     * attack boost, the defense boost, and the special effect
     * 
     * @return a description of the skill
     */
    public abstract String getDescription();

    /**
     * Returns the owner of the skill
     * 
     * @return the owner of the skill
     */
    public abstract Dittuu getOwner();

}
