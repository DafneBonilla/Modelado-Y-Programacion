import java.util.concurrent.ThreadLocalRandom;

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
        int random = ThreadLocalRandom.current().nextInt(1, 3 + 1);
        switch (random) {
            case 1:
                return new PikachuSkill(this);
            case 2:
                return new SnorlaxSkill(this);
            case 3:
                return new Rayquaza(this);
            default:
                return new DefaultSkill<Dittuu>(this);
        }
    }
}