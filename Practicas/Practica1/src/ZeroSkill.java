/**
 * Class to represent the zero skill of the fighter megaman
 * The zero skill has a damage of 40 and a defense of 0
 */
public class ZeroSkill extends SpSkill<MeganMan> {
    /**
     * Constructor of the zero skill
     * 
     * @param owner the owner of the skill
     */
    public ZeroSkill(MeganMan owner) {
        atkBoost = 40;
        defBoost = 0;
        name = "Zero";
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
        atkBoost += 10;
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
        return "Nombre: " + name + " Atk: " + atkBoost + " Def: " + defBoost + " Al atacar aumenta tu ataque en 10";
    }
}