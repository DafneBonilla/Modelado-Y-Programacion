public class Korby extends Fighter<Korby> {

    public Korby() {
        super();
        this.name = "Korby";
        this.skill = new DefaultSkill<Korby>(this);
    }

    @Override
    public void transform() {
        this.skill = generator();
    }

    protected SpSkill<Korby> generator() {
        return null;
    }
}