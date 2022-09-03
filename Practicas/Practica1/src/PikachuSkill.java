public class PikachuSkill extends SpSkill<Dittuu> {
    public PikachuSkill() {
        atkBoost = 5;
        defBoost = 35;
        name = "Pikachu";
    }

    @Override
    public int hit(Fighter target) {
        int damage = atkBoost - target.getBlock();
        target.gainBlock(20);
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
