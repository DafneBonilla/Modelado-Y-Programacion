/**
 * Interfaz para luchadores. Un luchador tiene nombre, número de
 * cuenta, promedio y edad. La clase implementa {@link Registro}, por lo que
 * puede representarse con una línea de texto y definir sus propiedades con una
 * línea de texto; además de determinar si sus campos cazan valores arbitrarios.
 */

public abstract class Figther {

    // Atributos
    private String name;
    private int health;
    private int block;
    private SpSkill<Fighter> skill;
    
    /**
     * G
     * 
     */
    public int hit(Fighter target) {
        if (target.isAlive()) {
            int damage = skill.hit(target);
            target = getHealth();
            target -= damage;
            return damage;
        } else {
            return Integer.MIN_VALUE;
        }
    }
    
    /**
     * M
     */
    public int defend() {
        int newBlock = skill.defend();
        block += newBlock;
        return newBlock;
    }
    
    public void transform(SpSkill<Fighter> skill) {}

    public String getName() {
        return this.name;
    }

    /**
     * Returns Fighters
     * @return 
     */
    public int getHealth() {
        return this.health;
    }
    
    /**
     * Returns Fighters
     * @return 
     */
    public int getBlock() {
        return this.block;
    }  

    /**
     * Returns Fighters
     * @return 
     */
    public void lowerHealth(int damage) {
        if (damage > 0) {
            this.health -= damage;
        }
    }
    
    /**
     * Returns Fighters
     * @return 
     */
    public String getSkillName() {
        return skill.getName();
    }
}