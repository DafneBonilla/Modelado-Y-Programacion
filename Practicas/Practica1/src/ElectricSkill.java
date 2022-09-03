public class ElectricSkill extends SpSkill<MeganMan> {
    
    public ElectricSkill(Fighter<MeganMan> owner) {
        atkBoost = 15;
        defBoost = 25;
        name = "Electric";
        this.owner = owner;
    }

    @Override
    public int hit(Fighter target) {
        int damage = atkBoost - target.getBlock();
        owner.gainHP(damage);
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
