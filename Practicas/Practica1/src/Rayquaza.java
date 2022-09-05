/**
 * Class to represent the rayquaza skill of the fighter Dittuu
 * The rayquaza skill has a damage of 20 and a defense of 20
 */
public class Rayquaza extends SpSkill<Dittuu> {

    /**
     * Constructor of the rayquaza skill
     * 
     * @param owner the owner of the skill
     */
    public Rayquaza(Dittuu owner) {
        atkBoost = 20;
        defBoost = 20;
        name = "Rayquaza";
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
        atkBoost += 20;
        if (defBoost > 0) {
            defBoost -= 10;
        }
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
        return "Nombre: " + name + " Atk: " + atkBoost + " Def: " + defBoost
                + " Al atacar aumenta tu ataque en 20 y disminuye tu defensa en 10";
    }
}
