public class Rayquaza extends SpSkill<Dittuu> {

    public Rayquaza(Dittuu owner) {
        atkBoost = 20;
        defBoost = 20;
        name = "Rayquaza";
        this.owner = owner;
    }

    @Override
    public int hit(Fighter target) {
        int damage = atkBoost - target.getBlock();
        atkBoost += 20;
        if (defBoost > 0) {
            defBoost -= 10;
        }
        return damage;
    }

    @Override
    public int defend() {
        return defBoost;
    }

    @Override
    public String getDescription() {
        return "Atk: " + atkBoost + " Def: " + defBoost
                + " Al atacar aumenta tu ataque en 20 y disminuye tu defensa en 10";
    }
}
