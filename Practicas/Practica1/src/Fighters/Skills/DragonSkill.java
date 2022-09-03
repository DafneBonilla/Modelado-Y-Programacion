public class DragonSkill extends SpSkill<Korby> {

    public DragonSkill(Korby owner) {
        atkBoost = 30;
        defBoost = 10;
        name = "Dragon";
        this.owner = owner;
    }

    @Override
    public int hit(Fighter target) {
        return atkBoost - (target.getBlock() / 2);
    }

    @Override
    public int defend() {
        return defBoost;
    }

    @Override
    public String getDescription() {
        return "Atk: " + atkBoost + " Def: " + defBoost + " Al atacar tomas la mitad del escudo del enemigo";
    }

}
