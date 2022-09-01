public class Korby extends Fighter {

    private SpSkill<Korby> skill;

    public Korby() {
        this.name = "Korby";
        this.health = 100;
        this.block = 0;
        skill = new DefaultSkill<Korby>();
    }

    public void transform(SpSkill<Korby> spSkill) {
        this.skill = spSkill;
    }
}    
