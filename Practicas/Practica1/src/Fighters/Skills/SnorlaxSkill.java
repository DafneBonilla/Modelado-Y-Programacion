public class SnorlaxSkill extends SpSkill<Dittuu> {

    public SnorlaxSkill(Dittuu owner) {
        atkBoost = 7;
        defBoost = 33;
        name = "Snorlax";
        this.owner = owner;
    }

    @Override
    public int hit(Fighter target) {
        return atkBoost - target.getBlock();
    }

    @Override
    public int defend() {
        owner.gainHP(10);
        return defBoost;
    }

    @Override
    public String getDescription() {
        return "Atk: " + atkBoost + " Def: " + defBoost + " Al defender te curas 10 de vida";
    }

}
