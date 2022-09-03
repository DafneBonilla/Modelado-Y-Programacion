public class ZeroSkill extends SpSkill<MeganMan> {

    public ZeroSkill(MeganMan owner) {
        atkBoost = 40;
        defBoost = 0;
        name = "Zero";
        this.owner = owner;
    }

    @Override
    public int hit(Fighter target) {
        int damage = atkBoost - target.getBlock();
        atkBoost += 10;
        return damage;
    }

    @Override
    public int defend() {
        return defBoost;
    }

    @Override
    public String getDescription() {
        return "Atk: " + atkBoost + " Def: " + defBoost + " Al atacar aumenta tu ataque en 10";
    }
}