public interface Fighter {

    public int hit(Fighter target);

    public int defend();

    public String getName();

    public int getHealth();
    
    public int getBlock();
    
    public void lowerHealth(int damage);
        
    public String getSkillName();

    public boolean isAlive();

    public <T> void transform(SpSkill<T> skill);


}
