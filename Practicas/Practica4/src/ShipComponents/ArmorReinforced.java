package ShipComponents;

/**
 * Class to represent the reinforced armor component of a ship
 */
public class ArmorReinforced extends Armor {

    /**
     * Constructor of the reinforced armor
     */
    public ArmorReinforced() {
        name = "Armadura Reforzada";
        atk = 0;
        def = 50;
        spd = 0;
        wt = 25;
        price = 500.50;
        description = name + ", Ataque: " + atk + ", Defensa: " + def + ", Velocidad: " + spd + ", Peso: " + wt
                + ", Precio: $" + price;
    }

}
