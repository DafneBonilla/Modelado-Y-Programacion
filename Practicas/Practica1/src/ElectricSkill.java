public class ElectricSkill extends SpSkill<MeganMan> {
    
    public ElectricSkill() {
        atkBoost = 15;
        defBoost = 25;
        name = "Electric";
    }

    @Override
    public int hit(Fighter target) {
        int damage = atkBoost - target.getBlock();
        target.gainHP(damage);
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
