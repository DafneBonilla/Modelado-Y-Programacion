public class DragonSkill extends SpSkill<Korby> {

    public DragonSkill() {
        atkBoost = 40;
        defBoost = 10;
        name = "Dragon";
    }

    @Override
    public int hit(Fighter<Korby> target) {
        int dmg = atkBoost - (target.getBlock() / 2);
        return dmg;
    }

    @Override
    public int defend() {
        return defBoost;
    }

}
