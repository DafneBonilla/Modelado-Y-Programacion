/**
 * Class to represent the snorlax skill of the fighter Dittuu
 * The snorlax skill has a damage of 7 and a defense of 33
 */
public class SnorlaxSkill extends SpSkill<Dittuu> {
    /**
     * Constructor of the snorlax skill
     * 
     * @param owner the owner of the skill
     */
    public SnorlaxSkill(Dittuu owner) {
        atkBoost = 7;
        defBoost = 33;
        name = "Snorlax";
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
        return atkBoost - target.getBlock();
    }

    /**
     * Calculates and returns the amount of block that the skill will give to the
     * owner
     * 
     * @return the amount of block that the skill will give to the owner
     */
    @Override
    public int defend() {
        owner.gainHP(10);
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
        return "Nombre: " + name + " Atk: " + atkBoost + " Def: " + defBoost + " Al defender te curas 10 de vida";
    }

}
