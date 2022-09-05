public class PikachuSkill extends SpSkill<Dittuu> {

    public PikachuSkill(Dittuu owner) {
        atkBoost = 23;
        defBoost = 17;
        name = "Pikachu";
        this.owner = owner;
    }

    @Override
    public int hit(Fighter target) {
        int damage = atkBoost - target.getBlock();
        owner.lowerHP(5);
        return damage;
    }

    @Override
    public int defend() {
        atkBoost += 5;
        return defBoost;
    }

    @Override
    public String getDescription() {
        return "Nombre: " + name + " Atk: " + atkBoost + " Def: " + defBoost
                + " Al defender aumenta tu ataque en 5 y al atacar te hace 5 de danio";
    }

}
