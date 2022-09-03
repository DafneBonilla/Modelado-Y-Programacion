public class MetalSkill extends SpSkill<MeganMan> {

     public MetalSkill(Fighter<MeganMan> owner) {
        atkBoost = 5;
        defBoost = 35;
        name = "Metal";
        this.owner = owner;
    }

    @Override
    public int hit(Fighter target) {
        int damage = atkBoost - target.getBlock();
        owner.gainBlock(20);
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
