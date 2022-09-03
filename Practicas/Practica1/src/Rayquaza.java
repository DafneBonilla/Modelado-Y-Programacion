public class Rayquaza extends SpSkill<Dittuu> {
    
    public Rayquaza(Fighter<Dittuu> owner) {
        atkBoost = 20;
        defBoost = 20;
        name = "Rayquaza";
        this.owner = owner;
    }

    @Override
    public int hit(Fighter target) {
        int damage = atkBoost - target.getBlock();
        atkBoost += 20;
        if (defBoost > 0) {
            defBoost -= 10;
        }
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
