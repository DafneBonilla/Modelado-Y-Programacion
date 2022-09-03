public abstract class Fighter<T extends Fighter<T>> {

    protected String name;

    protected int hp;

    protected int block;

    protected SpSkill<T> skill;

    public Fighter() {
        this.hp = 100;
        this.block = 0;
    }

    public int hit(Fighter<T> target) {
        if (target.isAlive()) {
            return skill.hit(target);
        } else {
            return Integer.MIN_VALUE;
        }
    }
    
    public int defend() {
        int newBlock = skill.defend();
        block += newBlock;
        return newBlock;
    }

    public String getName() {
        return this.name;
    }

    public int getHP() {
        return this.hp;
    }

    public int getBlock() {
        return this.block;
    }

    public void lowerBlock() {
        this.block = 0;
    }

    public void lowerHP(int damage) {
        if (damage > 0) {
            this.hp -= damage;
            if (hp < 0) {
                hp = 0;
            }
        }
    }

    public void gainBlock(int block) {
        if (block > 0) {
            this.block += block;
        }
    }

    public void gainHP(int hp) {
        if (hp > 0) {
            this.hp += hp;
            if (hp > 100) {
                hp = 100;
            }
        }
    }

    public String getSkillName() {
        return skill.getName();
    }

    public boolean isAlive() {
        return hp != 0;
    }

    public abstract void transform();

    protected abstract SpSkill<T> generator(); // esto puede estar mal xd

}

// https://stackoverflow.com/questions/28618279/defining-generic-property-in-abstract-class-as-a-type-of-the-implementing-class
