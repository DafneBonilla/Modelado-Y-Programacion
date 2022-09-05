/**
 * Class to represent the pikachu skill of the fighter Dittuu
 * The pikachu skill has a damage of 23 and a defense of 17
 */
public class PikachuSkill extends SpSkill<Dittuu> {

    /**
     * Constructor of the pikachu Skill
     * 
     * @param owner the owner of the skill
     */
    public PikachuSkill(Dittuu owner) {
        atkBoost = 23;
        defBoost = 17;
        name = "Pikachu";
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
        owner.lowerHP(5);
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
        atkBoost += 5;
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
        return "Nombre: " + name + " Atk: " + atkBoost + " Def: " + defBoost
                + " Al defender aumenta tu ataque en 5 y al atacar te hace 5 de danio";
    }

}
