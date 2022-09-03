public class DragonSkill extends SpSkill<Korby> {

    public DragonSkill() {
        atkBoost = 30;
        defBoost = 10;
        name = "Dragon";
    }

    @Override
    public int hit(Fighter<Korby> target) {
        int damage = atkBoost - (target.getBlock() / 2);
        if (damage < 0) {
            target.lowerBlock();
            return 0;
        } else {
            target.lowerHP(damage);
            return damage;
        }
    }

    @Override
    public int defend() {
        return defBoost;
    }

}
