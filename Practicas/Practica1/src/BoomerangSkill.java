public class BoomerangSkill extends SpSkill<Korby> {

    public BoomerangSkill() {
        atkBoost = 10;
        defBoost = 30;
        name = "Boomerang";
    }

    @Override
    public int hit(Fighter<Korby> target) {
        int damage = atkBoost - (target.getBlock());
        if (damage < 0) {
            target.lowerBlock();
            return 0;
        } else {
            target.lowerBlock();
            target.lowerHP(damage);
            return damage;
        }
    }

    @Override
    public int defend() {
        return (int) (defBoost * 1.5);
    }

}