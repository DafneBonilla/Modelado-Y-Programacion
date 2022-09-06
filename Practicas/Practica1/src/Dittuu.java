import java.util.concurrent.ThreadLocalRandom;

/**
 * Class to represent the fighter Dittuu
 * Dittuu has a skill of the "Dittuu" type
 */
public class Dittuu extends Fighter {

    /* The skill of Dittuu */
    private SpSkillDittuu skill;

    /**
     * Constructor of Dittuu
     */
    public Dittuu() {
        super();
        this.name = "Dittuu";
        this.skill = new DefaultSkillDittuu(this);
    }

    /**
     * Returns the damage that Diittuu will do to the target
     * If the target is dead, the damage will be Integer.MIN_VALUE
     * The damage is calculated by the skill of Dittuu
     * 
     * @param target the target of the hit
     * @return the damage that Dittuu will do to the target
     */
    @Override
    public int hit(Fighter target) {
        if (target.isAlive()) {
            int damage = skill.hit(target);
            if (damage <= 0) {
                target.lowerBlock();
                return 0;
            } else {
                target.lowerBlock();
                target.lowerHP(damage);
                return damage;
            }
        } else {
            return Integer.MIN_VALUE;
        }
    }

    /**
     * Returns the amount of block that Dittuu will give to himself
     * The block is calculated by the skill of Dittuu
     * 
     * @return the amount of block that Dittuu will give to himself
     */
    @Override
    public int defend() {
        int newBlock = skill.defend();
        gainBlock(newBlock);
        return newBlock;
    }

    /**
     * Returns the name of the skill
     * 
     * @return the name of the skill
     */
    public String getSkillName() {
        return skill.getName();
    }

    /**
     * Returns the name of the new skill that Dittuu will have
     * The new skill is randomly chosen
     * 
     * @return the name of the new skill that Dittuu will have
     */
    @Override
    public String transform() {
        this.skill = generator();
        return skill.getDescription();
    }

    /**
     * Returns a new skill of the "Dittuu" type that Dittuu will have
     * The new skill is randomly chosen
     * 
     * @return a skill of the "Dittuu" type
     */
    private SpSkillDittuu generator() {
        int random = ThreadLocalRandom.current().nextInt(1, 3 + 1);
        switch (random) {
            case 1:
                return new PikachuSkill(this);
            case 2:
                return new SnorlaxSkill(this);
            case 3:
                return new RayquazaSkill(this);
            default:
                return new DefaultSkillDittuu(this);
        }
    }

    /**
     * Returns a description of Dittuu, this description contains the name, the HP,
     * the block, and the skill name
     * 
     * @return a description of Dittuu
     */
    @Override
    public String getInfo() {
        return "Dittuu: " + getHP() + " HP, " + skill.getAtkBoost() + " ATK, " + skill.getDefBoost() + " DEF, "
                + getBlock() + " Escudo y Habilidad " + skill.getName();
    }

}