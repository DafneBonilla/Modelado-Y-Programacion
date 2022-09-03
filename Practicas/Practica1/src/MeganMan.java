public class MeganMan extends Fighter<MeganMan> {

    public MeganMan() {
        super();
        this.name = "MeganMan";
        this.skill = new DefaultSkill<MeganMan>();
    }

    @Override
    public void transform() {
        this.skill = generator();
    }

    protected SpSkill<MeganMan> generator() {
        return null;
    }

}