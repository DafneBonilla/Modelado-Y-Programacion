/**
 * Class to represent the electric skill of the fighter MeganMan
 * The electric skill has a damage of 15 and a defense of 25
 */
public class ElectricSkill extends SpSkill<MeganMan> {

    /**
     * Constructor of the electric skill
     * 
     * @param owner the owner of the skill
     */
    public ElectricSkill(MeganMan owner) {
        atkBoost = 15;
        defBoost = 25;
        name = "Electric";
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
        owner.gainHP(damage);
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
        return "Nombre: " + name + " Atk: " + atkBoost + " Def: " + defBoost + " Al atacar te curas el danio que haces";
    }
}
