import java.util.concurrent.ThreadLocalRandom;

public class MeganMan extends Fighter {

    private SpSkill<MeganMan> skill;

    public MeganMan() {
        super();
        this.name = "MeganMan";
        this.skill = new DefaultSkill<MeganMan>(this);
    }

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

    @Override
    public int defend() {
        int newBlock = skill.defend();
        gainBlock(newBlock);
        return newBlock;
    }

    @Override
    public String getSkillName() {
        return skill.getName();
    }

    @Override
    public void transform() {
        this.skill = generator();
    }

    private SpSkill<MeganMan> generator() {
        int random = ThreadLocalRandom.current().nextInt(1, 3 + 1);
        switch (random) {
            case 1:
                return new ElectricSkill(this);
            case 2:
                return new MetalSkill(this);
            case 3:
                return new ZeroSkill(this);
            default:
                return new DefaultSkill<MeganMan>(this);
        }
    }

    @Override
    public String getInfo() {
        return "MeganMan: " + getHP() + " HP, " + skill.getAtkBoost() + " ATK, " + skill.getDefBoost() + " DEF, "
                + getBlock() + " Escudo y Habilidad " + skill.getName();
    }
}