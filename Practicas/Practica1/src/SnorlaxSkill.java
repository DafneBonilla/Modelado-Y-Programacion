/**
 * Class to represent the snorlax skill of the fighter Dittuu
 * The snorlax skill has a damage of 7 and a defense of 33
 */
public class SnorlaxSkill implements SpSkillDittuu {

    /* The attack boost of the skill */
    private int atkBoost;
    /* The defense boost of the skill */
    private int defBoost;
    /* The name of the skill */
    private String name;
    /* The owner of the skill */
    private Dittuu owner;

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
        return "Nombre: " + name + " Atk: " + atkBoost + " Def: " + defBoost + " Al defender te curas 10 de vida";
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
