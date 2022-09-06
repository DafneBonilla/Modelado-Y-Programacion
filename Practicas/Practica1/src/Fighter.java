/**
 * Abstract class to represent a fighter
 * A fighter has a name, a health and a block
 */
public abstract class Fighter {

    /* The name of the fighter */
    protected String name;
    /* The health of the fighter */
    protected int hp;
    /* The block of the fighter */
    protected int block;

    /**
     * Constructor of the fighter
     */
    public Fighter() {
        this.hp = 100;
        this.block = 0;
    }

    /**
     * Returns the damage that the fighter will do to the target
     * 
     * @param target the target of the hit
     * @return the damage that the fighter will do to the target
     */
    public abstract int hit(Fighter target);

    /**
     * Returns the amount of block that the fighter will give to himself
     * 
     * @return the amount of block that the fighter will give to himself
     */
    public abstract int defend();

    /**
     * Returns the name of the fighter
     * 
     * @return the name of the fighter
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the health of the fighter
     * 
     * @return the health of the fighter
     */
    public int getHP() {
        return this.hp;
    }

    /**
     * Returns the block of the fighter
     * 
     * @return the block of the fighter
     */
    public int getBlock() {
        return this.block;
    }

    /**
     * Lowers the block of the fighter to 0
     */
    public void lowerBlock() {
        this.block = 0;
    }

    /**
     * Lowers the health of the fighter by the amount of damage
     * If the health of the fighter is lower than 0, it will be set to 0
     * 
     * @param damage the amount of damage that the fighter will receive
     */
    public void lowerHP(int damage) {
        if (damage > 0) {
            this.hp -= damage;
            if (hp < 0) {
                hp = 0;
            }
        }
    }

    /**
     * Increases the block of the fighter by the amount of block
     * If the new amount of block is lower than 0, it will be ignored
     * 
     * @param block the amount of block that the fighter will receive
     */
    public void gainBlock(int block) {
        if (block > 0) {
            this.block += block;
        }
    }

    /**
     * Increases the health of the fighter by the amount of health
     * If the new amount of health is lower than 0, it will be ignored
     * If the health of the fighter is greater than 100, it will be set to 100
     * 
     * @param hp the amount of health that the fighter will receive
     */
    public void gainHP(int hp) {
        if (hp > 0) {
            this.hp += hp;
            if (this.hp > 100) {
                this.hp = 100;
            }
        }
    }

    /**
     * Returns true if the fighter is alive
     * 
     * @return true if the fighter is alive
     */
    public boolean isAlive() {
        return hp != 0;
    }

    /**
     * Returns the name of the new skill that the fighter will have
     * If the fighter cannot transform, it will return null
     * 
     * @return the name of the new skill that the fighter will have
     */
    public abstract String transform();

    /**
     * Returns a description of the fighter
     * 
     * @return a description of the fighter
     */
    public abstract String getInfo();

}
