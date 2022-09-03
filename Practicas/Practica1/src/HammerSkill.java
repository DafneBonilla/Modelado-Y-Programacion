public class HammerSkill extends SpSkill<Korby> {
    
    public HammerSkill(Fighter<Korby> owner) {
        atkBoost = 35;
        defBoost = 5;
        name = "Hammer";
        this.owner = owner;
    }

    @Override
    public int hit(Fighter target) {
        int damage = atkBoost - target.getBlock();
        owner.gainBlock(defBoost);
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
