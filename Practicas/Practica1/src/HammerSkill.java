/**
 * Class to represent the hammer skill of the fighter Korby
 * The hammer skill has a damage of 35 and a defense of 5
 */
public class HammerSkill extends SpSkill<Korby> {

    /**
     * Constructor of the hammer skill
     * 
     * @param owner the owner of the skill
     */
    public HammerSkill(Korby owner) {
        atkBoost = 35;
        defBoost = 5;
        name = "Hammer";
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
        int damage = atkBoost - target.getBlock();
        owner.gainBlock(defBoost);
        return damage;
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
     * attack boost, the defense boost, and the special effect
     * 
     * @return a description of the skill
     */
    @Override
    public String getDescription() {
        return "Nombre: " + name + " Atk: " + atkBoost + " Def: " + defBoost + " Al atacar ganas " + defBoost
                + " de escudo";
    }
}
