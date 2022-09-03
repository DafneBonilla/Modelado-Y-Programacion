import java.util.concurrent.ThreadLocalRandom;

public class Dittuu extends Fighter {

    private SpSkill<Dittuu> skill;

    public Dittuu() {
        super();
        this.name = "Dittuu";
        this.skill = new DefaultSkill<Dittuu>(this);
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

    private SpSkill<Dittuu> generator() {
        int random = ThreadLocalRandom.current().nextInt(1, 3 + 1);
        switch (random) {
            case 1:
                return new PikachuSkill(this);
            case 2:
                return new SnorlaxSkill(this);
            case 3:
                return new Rayquaza(this);
            default:
                return new DefaultSkill<Dittuu>(this);
        }
    }

    @Override
    public String getInfo() {
        return "Dittuu: " + getHP() + " HP, " + skill.getAtkBoost() + " ATK, " + skill.getDefBoost() + " DEF, "
                + getBlock() + " Escudo y Habilidad " + skill.getName();
    }

}