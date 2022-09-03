public class PikachuSkill extends SpSkill<Dittuu> {

    public PikachuSkill(Fighter<Dittuu> owner) {
        atkBoost = 23;
        defBoost = 17;
        name = "Pikachu";
        this.owner = owner;
    }

    @Override
    public int hit(Fighter target) {
        int damage = atkBoost - target.getBlock();
        owner.lowerHP(5);
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
        atkBoost += 5;
        return defBoost;
    }
    
}
