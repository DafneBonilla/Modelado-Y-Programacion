public class Dittuu extends Fighter {

    private SpSkill<Dittuu> skill;

    public Dittuu() {
        this.name = "Dittuu";
        this.health = 100;
        this.block = 0;
        skill = new DefaultSkill<Dittuu>();
    }

    public void transform(SpSkill<Dittuu> spSkill) {
        this.skill = spSkill;
    }
}    
