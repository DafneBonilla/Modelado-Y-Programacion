public class Korby extends Fighter<Korby> {

    public Korby() {
        super();
        this.name = "Korby";
        this.skill = new DefaultSkill<Korby>();
    }

    @Override
    public void transform() {
        this.skill = generator();
    }

    protected SpSkill<Korby> generator() {
        return new DragonSkill();
    }

}