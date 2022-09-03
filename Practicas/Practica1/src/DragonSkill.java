public class DragonSkill extends SpSkill<Korby> {

    public DragonSkill(Fighter<Korby> owner) {
        atkBoost = 30;
        defBoost = 10;
        name = "Dragon";
        this.owner = owner;
    }

    @Override
    public int hit(Fighter target) {
        int damage = atkBoost - (target.getBlock() / 2);
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
        return defBoost;
    }

}
