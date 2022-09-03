public class BoomerangSkill extends SpSkill<Korby> {

    public BoomerangSkill(Korby owner) {
        atkBoost = 10;
        defBoost = 30;
        name = "Boomerang";
        this.owner = owner;
    }

    @Override
    public int hit(Fighter target) {
        return atkBoost - target.getBlock();
    }

    @Override
    public int defend() {
        return (int) (defBoost * 1.5);
    }

    @Override
    public String getDescription() {
        return "Atk: " + atkBoost + " Def: " + defBoost + " Al defender ganas " + (int) (defBoost * 1.5) + " de escudo";
    }

}