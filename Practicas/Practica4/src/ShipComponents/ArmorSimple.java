package ShipComponents;

public class ArmorSimple extends Armor {

    public ArmorSimple() {
        name = "Armadura Simple";
        atk = 0;
        def = 25;
        spd = 0;
        wt = 12;
        price = 250.35;
        description = name + ", Ataque: " + atk + ", Defensa: " + def + ", Velocidad: " + spd + ", Peso: " + wt
                + ", Precio: $" + price;
    }

}
