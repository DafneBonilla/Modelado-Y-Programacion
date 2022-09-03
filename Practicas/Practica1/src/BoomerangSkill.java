public class BoomerangSkill extends SpSkill<Korby> {

    public BoomerangSkill(Fighter<Korby> owner) {
        atkBoost = 10;
        defBoost = 30;
        name = "Boomerang";
        this.owner = owner;
    }

    @Override
    public int hit(Fighter target) {
        int damage = atkBoost - target.getBlock();
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