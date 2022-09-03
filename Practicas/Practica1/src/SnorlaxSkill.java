public class SnorlaxSkill extends SpSkill<Dittuu> {
    
    public SnorlaxSkill(Fighter<Dittuu> owner) {
        atkBoost = 7;
        defBoost = 33;
        name = "Snorlax";
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
        owner.gainHP(10);
        return defBoost;
    } 

}
