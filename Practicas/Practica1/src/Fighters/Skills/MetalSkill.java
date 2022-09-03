public class MetalSkill extends SpSkill<MeganMan> {

    public MetalSkill(MeganMan owner) {
        atkBoost = 5;
        defBoost = 35;
        name = "Metal";
        this.owner = owner;
    }

    @Override
    public int hit(Fighter target) {
        int damage = atkBoost - target.getBlock();
        owner.gainBlock(20);
        return damage;
    }

    @Override
    public int defend() {
        return defBoost;
    }

    @Override
    public String getDescription() {
        return "Nombre: " + name + " Atk: " + atkBoost + " Def: " + defBoost + " Al atacar ganas 20 de escudo";
    }
}
