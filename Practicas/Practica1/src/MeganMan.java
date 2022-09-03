import java.util.concurrent.ThreadLocalRandom;

public class MeganMan extends Fighter<MeganMan> {

    public MeganMan() {
        super();
        this.name = "MeganMan";
        this.skill = new DefaultSkill<MeganMan>(this);
    }

    @Override
    public void transform() {
        this.skill = generator();
    }

    protected SpSkill<MeganMan> generator() {
        int random = ThreadLocalRandom.current().nextInt(1, 3 + 1);
        switch (random) {
            case 1:
                return new ElectricSkill(this);
            case 2:
                return new MetalSkill(this);
            case 3:
                return new ZeroSkill(this);
            default:
                return new DefaultSkill<MeganMan>(this);
        }
    }
}