public class SnorlaxSkill extends SpSkill<Dittuu> {
    
    public SnorlaxSkill() {
        atkBoost = 7;
        defBoost = 33;
        name = "Snorlax";
    }

    @Override
    public int hit(Fighter target) {
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

        return defBoost;
    } 

}
