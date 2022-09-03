public class DefaultSkill<T extends Fighter> extends SpSkill<T> {

    public DefaultSkill(Fighter owner) {
        atkBoost = 20;
        defBoost = 20;
        name = "Defeault";
        this.owner = owner;
    }

    @Override
    public int hit(Fighter target) {
        int dmg = atkBoost - target.getBlock();
        return dmg;
    }

    @Override
    public int defend() {
        return defBoost;
    }

    @Override
    public String getDescription() {
        return "Atk: " + atkBoost + " Def: " + defBoost;
    }

}
