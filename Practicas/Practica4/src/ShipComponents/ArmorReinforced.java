package ShipComponents;

public class ArmorReinforced extends Armor {

    public ArmorReinforced() {
        name = "Armadura Reforzada";
        description = name + ", Ataque: " + atk + ", Defensa: " + def + ", Velocidad: " + spd + ", Peso: " + wt
                + ", Precio: $" + price;
        atk = 0;
        def = 50;
        spd = 0;
        wt = 25;
        price = 500.50;
    }

}
