public class Korby implements Fighter {

    // Atributos
    private String name;
    private int health;
    private int block;
    private SpSkill<Korby> skill;

    public Korby() {
        this.name = "Korby";
        this.health = 100;
        this.block = 0;
        skill = new DefaultSkill<Korby>();
    }

    @Override
    public int hit(Fighter target) {
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

    @Override
    public int getHealth() {
        return this.health;
    }
    
    @Override
    public int getBlock() {
        return this.block;
    }  

    @Override 
    public void lowerHealth(int damage) {
        if (damage > 0) {
            this.health -= damage;
        }
    }
    
    @Override 
    public String getSkillName() {
        return skill.getName();
    }

    public boolean isAlive() {
        return health != 0;
    }

    @Override
    public <T> void transform(SpSkill<Korby> skill) {
        this.skill = skill;    
    }
}    
