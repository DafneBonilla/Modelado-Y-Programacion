public class HammerSkill extends SpSkill<Korby> {

    public HammerSkill(Korby owner) {
        atkBoost = 35;
        defBoost = 5;
        name = "Hammer";
        this.owner = owner;
    }

    @Override
    public int hit(Fighter target) {
        int damage = atkBoost - target.getBlock();
        owner.gainBlock(defBoost);
        return damage;
    }

    @Override
    public int defend() {
        return defBoost;
    }

    @Override
    public String getDescription() {
        return "Atk: " + atkBoost + " Def: " + defBoost + " Al atacar ganas " + defBoost + " de escudo";
    }
}
