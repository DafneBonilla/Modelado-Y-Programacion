public class DefaultSkill<T extends Fighter<T>> extends SpSkill<T> {

    public DefaultSkill() {
        atkBoost = 20;
        defBoost = 20;
        name = "Defeault";
    }

    @Override
    public int hit(Fighter<T> target) {
        int dmg = atkBoost - target.getBlock();
        return dmg;
    }

    @Override
    public int defend() {
        return defBoost;
    }

}
