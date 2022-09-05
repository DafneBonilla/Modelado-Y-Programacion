/**
 * Class to represent the metal skill of the fighter MeganMan
 * The metal skill has a damage of 5 and a defense of 35
 */
public class MetalSkill extends SpSkill<MeganMan> {

    /**
     * Constructor of the metal Skill
     * 
     * @param owner the owner of the skill
     */
    public MetalSkill(MeganMan owner) {
        atkBoost = 5;
        defBoost = 35;
        name = "Metal";
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
        owner.gainBlock(20);
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
        return "Nombre: " + name + " Atk: " + atkBoost + " Def: " + defBoost + " Al atacar ganas 20 de escudo";
    }
}
