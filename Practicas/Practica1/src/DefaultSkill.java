public class DefaultSkill<T extends Fighter<T>> extends SpSkill<T> {

    public DefaultSkill(Fighter<T> owner) {
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

}
