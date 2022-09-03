public class Dittuu extends Fighter<Dittuu> {

    public Dittuu() {
        super();
        this.name = "Dittuu";
        this.skill = new DefaultSkill<Dittuu>(this);
    }

    @Override
    public void transform() {
        this.skill = generator();
    }

    protected SpSkill<Dittuu> generator() {
        return null;
    }

}