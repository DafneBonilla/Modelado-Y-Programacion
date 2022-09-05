/**
 * Class to represent the dragon skill of the fighter Korby
 * The dragon skill has a damage of 30 and a defense of 10
 */
public class DragonSkill extends SpSkill<Korby> {

    /**
     * Constructor of the dragon skill
     * 
     * @param owner the owner of the skill
     */
    public DragonSkill(Korby owner) {
        atkBoost = 30;
        defBoost = 10;
        name = "Dragon";
        this.owner = owner;
    }

    /**
     * Calculates and returns the amount of block that the skill will give to the
     * owner
     * 
     * @return the amount of block that the skill will give to the owner
     */
    @Override
    public int hit(Fighter target) {
        return atkBoost - (target.getBlock() / 2);
    }

    /**
     * Calculates and returns the defense that the skill will give to the owner
     * 
     * @return the defense that the skill will give to the owner
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
                + " Al atacar tomas la mitad del escudo del enemigo";
    }

}
