import java.util.concurrent.ThreadLocalRandom;

/**
 * Class to represent the fighter Korby
 * Korby has a skill of the "Korby" type
 */
public class Korby extends Fighter {

    /* The skill of Dittuu */
    private SpSkillKorby skill;

    /**
     * Constructor of Korby
     */
    public Korby() {
        super();
        this.name = "Korby";
        this.skill = new DefaultSkillKorby(this);
    }

    /**
     * Returns the damage that Korby will do to the target
     * If the target is dead, the damage will be Integer.MIN_VALUE
     * The damage is calculated by the skill of Dittuu
     * 
     * @param target the target of the hit
     * @return the damage that Korby will do to the target
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
     * Returns the amount of block that Korby will give to himself
     * The block is calculated by the skill of Korby
     * 
     * @return the amount of block that Korby will give to himself
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
     * Returns the name of the new skill that Korby will have
     * The new skill is randomly chosen
     * 
     * @return the name of the new skill that Korby will have
     */
    @Override
    public String transform() {
        this.skill = generator();
        return skill.getDescription();
    }

    /**
     * Returns a new skill of the "Korby" type that Korby will have
     * The new skill is randomly chosen
     * 
     * @return a skill of the "Korby" type
     */
    private SpSkillKorby generator() {
        int random = ThreadLocalRandom.current().nextInt(1, 3 + 1);
        switch (random) {
            case 1:
                return new DragonSkill(this);
            case 2:
                return new BoomerangSkill(this);
            case 3:
                return new HammerSkill(this);
            default:
                return new DefaultSkillKorby(this);
        }
    }

    /**
     * Returns a description of Korby, this description contains the name, the
     * HP, the block, and the skill name
     * 
     * @return a description of Korby
     */
    @Override
    public String getInfo() {
        return "Korby: " + getHP() + " HP, " + skill.getAtkBoost() + " ATK, " + skill.getDefBoost() + " DEF, "
                + getBlock() + " Escudo y Habilidad " + skill.getName();
    }

}