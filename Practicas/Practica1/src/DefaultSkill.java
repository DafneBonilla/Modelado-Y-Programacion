/**
 * Class to represent the default skill of every fighter
 * The default skill has a damage of 20 and a defense of 20
 */
public class DefaultSkill<T extends Fighter> extends SpSkill<T> {

    /**
     * Constructor of the default skill
     * 
     * @param owner the owner of the skill
     */
    public DefaultSkill(T owner) {
        atkBoost = 20;
        defBoost = 20;
        name = "Defeault";
        this.owner = owner;
    }

    /**
     * Calculates and returns the damage that the skill will do to the target
     * 
     * @param target the target of the hit
     * @return the damage that the skill will do to the target
     */
    @Override
    public int hit(Fighter target) {
        int dmg = atkBoost - target.getBlock();
        return dmg;
    }

    /**
     * Calculates and returns the amount of block that the skill will give to the
     * owner
     * 
     * @return the amount of block that the skill will give to the owner
     */
    @Override
    public int defend() {
        return defBoost;
    }

    /**
     * Returns a description of the skill, this description contains the name, the
     * attack boost and the defense boost
     * 
     * @return a description of the skill
     */
    @Override
    public String getDescription() {
        return "Nombre: " + name + " Atk: " + atkBoost + " Def: " + defBoost;
    }

}
