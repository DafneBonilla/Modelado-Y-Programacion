import java.util.concurrent.ThreadLocalRandom;

/**
 * Class to represent the fighter MeganMan
 * MeganMan has a skill of the "MeganMan" type
 */
public class MeganMan extends Fighter {

    /* The skill of MeganMan */
    private SpSkillMeganMan skill;

    /**
     * Constructor of MeganMan
     */
    public MeganMan() {
        super();
        this.name = "MeganMan";
        this.skill = new DefaultSkillMeganMan(this);
    }

    /**
     * Returns the damage that MeganMan will do to the target
     * If the target is dead, the damage will be Integer.MIN_VALUE
     * The damage is calculated by the skill of MeganMan
     * 
     * @param target the target of the hit
     * @return the damage that MeganMan will do to the target
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
     * Returns the amount of block that MeganMan will give to himself
     * The block is calculated by the skill of MeganMan
     * 
     * @return the amount of block that MeganMan will give to himself
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
     * Returns the name of the new skill that MeganMan will have
     * The new skill is randomly chosen
     * 
     * @return the name of the new skill that MeganMan will have
     */
    @Override
    public String transform() {
        this.skill = generator();
        return skill.getDescription();
    }

    /**
     * Returns a new skill of the "MeganMan" type that MeganMan will have
     * The new skill is randomly chosen
     * 
     * @return a skill of the "MeganMan" type
     */
    private SpSkillMeganMan generator() {
        int random = ThreadLocalRandom.current().nextInt(1, 3 + 1);
        switch (random) {
            case 1:
                return new ElectricSkill(this);
            case 2:
                return new MetalSkill(this);
            case 3:
                return new ZeroSkill(this);
            default:
                return new DefaultSkillMeganMan(this);
        }
    }

    /**
     * Returns a description of MeganMan, this description contains the name, the
     * HP, the block, and the skill name
     * 
     * @return a description of MeganMan
     */
    @Override
    public String getInfo() {
        return "MeganMan: " + getHP() + " HP, " + skill.getAtkBoost() + " ATK, " + skill.getDefBoost() + " DEF, "
                + getBlock() + " Escudo y Habilidad " + skill.getName();
    }

}