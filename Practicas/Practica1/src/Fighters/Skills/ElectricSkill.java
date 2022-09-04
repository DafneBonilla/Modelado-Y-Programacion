public class ElectricSkill extends SpSkill<MeganMan> {

    public ElectricSkill(MeganMan owner) {
        atkBoost = 15;
        defBoost = 25;
        name = "Electric";
        this.owner = owner;
    }

    @Override
    public int hit(Fighter target) {
        int damage = atkBoost - target.getBlock();
        owner.gainHP(damage);
        return damage;
    }

    @Override
    public int defend() {
        return defBoost;
    }

    @Override
    public String getDescription() {
        return "Nombre: " + name + " Atk: " + atkBoost + " Def: " + defBoost + " Al atacar te curas el danio que haces";
    }
}
