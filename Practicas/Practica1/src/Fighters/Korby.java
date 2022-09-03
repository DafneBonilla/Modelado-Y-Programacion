import java.util.concurrent.ThreadLocalRandom;

public class Korby extends Fighter {

    private SpSkill<Korby> skill;

    public Korby() {
        super();
        this.name = "Korby";
        this.skill = new DefaultSkill<Korby>(this);
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
    public String transform() {
        this.skill = generator();
        return skill.getDescription();
    }

    private SpSkill<Korby> generator() {
        int random = ThreadLocalRandom.current().nextInt(1, 3 + 1);
        switch (random) {
            case 1:
                return new DragonSkill(this);
            case 2:
                return new BoomerangSkill(this);
            case 3:
                return new HammerSkill(this);
            default:
                return new DefaultSkill<Korby>(this);
        }
    }

    @Override
    public String getInfo() {
        return "Korby: " + getHP() + " HP, " + skill.getAtkBoost() + " ATK, " + skill.getDefBoost() + " DEF, "
                + getBlock() + " Escudo y Habilidad " + skill.getName();
    }

}