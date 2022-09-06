/**
 * Class to represent the default skill of Korby
 * The default skill has a damage of 20 and a defense of 20
 */
public class DefaultSkillKorby implements SpSkillKorby {

    /* The attack boost of the skill */
    private int atkBoost;
    /* The defense boost of the skill */
    private int defBoost;
    /* The name of the skill */
    private String name;
    /* The owner of the skill */
    private Korby owner;

    /**
     * Constructor of the default skill
     * 
     * @param owner the owner of the skill
     */
    public DefaultSkillKorby(Korby owner) {
        atkBoost = 20;
        defBoost = 20;
        name = "Defeault";
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
     * attack boost and the defense boost
     * 
     * @return a description of the skill
     */
    @Override
    public String getDescription() {
        return "Nombre: " + name + " Atk: " + atkBoost + " Def: " + defBoost;
    }

    /**
     * Returns the owner of the skill
     * 
     * @return the owner of the skill
     */
    @Override
    public Korby getOwner() {
        return owner;
    }

}
