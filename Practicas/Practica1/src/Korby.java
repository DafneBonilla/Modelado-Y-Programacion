import java.util.concurrent.ThreadLocalRandom;

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
        int random = ThreadLocalRandom.current().nextInt(1, 3 + 1);
        switch (random) {
            case 1:
                return new DragonSkill(this);
            case 2:
                return new BoomerangSkill(this);
            case 3:
                return new HammerSkill(this);
            default:
                return new DefaultSkill<Korby>(this);
        }
    }
}

// https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java