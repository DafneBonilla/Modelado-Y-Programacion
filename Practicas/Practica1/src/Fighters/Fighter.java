public abstract class Fighter {

    protected String name;

    protected int hp;

    protected int block;

    public Fighter() {
        this.hp = 100;
        this.block = 0;
    }

    public abstract int hit(Fighter target);

    public abstract int defend();

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

    public abstract String getSkillName();

    public boolean isAlive() {
        return hp != 0;
    }

    public abstract String transform();

    public abstract String getInfo();

}
