/**
 * Class to represent the hammer skill of the fighter Korby
 * The hammer skill has a damage of 35 and a defense of 5
 */
public class HammerSkill implements SpSkillKorby {

    /* The attack boost of the skill */
    private int atkBoost;
    /* The defense boost of the skill */
    private int defBoost;
    /* The name of the skill */
    private String name;
    /* The owner of the skill */
    private Korby owner;

    /**
     * Constructor of the hammer skill
     * 
     * @param owner the owner of the skill
     */
    public HammerSkill(Korby owner) {
        atkBoost = 35;
        defBoost = 5;
        name = "Hammer";
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
        owner.gainBlock(defBoost);
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
        return "Nombre: " + name + " Atk: " + atkBoost + " Def: " + defBoost + " Al atacar ganas " + defBoost
                + " de escudo";
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
