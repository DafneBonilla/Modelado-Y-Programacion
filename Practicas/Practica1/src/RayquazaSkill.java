/**
 * Class to represent the rayquaza skill of the fighter Dittuu
 * The rayquaza skill has a damage of 20 and a defense of 20
 */
public class RayquazaSkill implements SpSkillDittuu {

    /* The attack boost of the skill */
    private int atkBoost;
    /* The defense boost of the skill */
    private int defBoost;
    /* The name of the skill */
    private String name;
    /* The owner of the skill */
    private Dittuu owner;

    /**
     * Constructor of the rayquaza skill
     * 
     * @param owner the owner of the skill
     */
    public RayquazaSkill(Dittuu owner) {
        atkBoost = 20;
        defBoost = 20;
        name = "Rayquaza";
        this.owner = owner;
    }

    /**
     * Returns the attack boost of the skill
     * 
     * @return the attack boost of the skill
     */
    @Override
    public int getAtkBoost() {
        return atkBoost;
    }

    /**
     * Returns the attack boost of the skill
     * 
     * @return the attack boost of the skill
     */
    @Override
    public int getDefBoost() {
        return defBoost;
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
     * Returns the name of the skill
     * 
     * @return the name of the skill
     */
    @Override
    public String getName() {
        return name;
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

    /**
     * Returns the owner of the skill
     * 
     * @return the owner of the skill
     */
    @Override
    public Dittuu getOwner() {
        return owner;
    }

}
