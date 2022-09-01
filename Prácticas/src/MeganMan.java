public class MeganMan extends Fighter {

    private SpSkill<MeganMan> skill;

    public MeganMan() {
        this.name = "MeganMan";
        this.health = 100;
        this.block = 0;
        skill = new DefaultSkill<MeganMan>();
    }

    public void transform(SpSkill<MeganMan> spSkill) {
        this.skill = spSkill;
    }
}    
