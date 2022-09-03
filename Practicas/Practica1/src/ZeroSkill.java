public class ZeroSkill extends SpSkill<MeganMan> {

    public ZeroSkill(Fighter<MeganMan> owner) {
        atkBoost = 40;
        defBoost = 0;
        name = "Zero";
        this.owner = owner;
    }

    @Override
    public int hit(Fighter target) {
        int damage = atkBoost - (target.getBlock());
        atkBoost += 10;
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