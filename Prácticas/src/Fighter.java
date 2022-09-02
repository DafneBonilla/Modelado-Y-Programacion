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
            int damage = skill.hit(target);
            target.lowerHealth(damage);
            return damage;
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

    public void lowerHealth(int damage) {
        if (damage > 0) {
            this.hp -= damage;
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
