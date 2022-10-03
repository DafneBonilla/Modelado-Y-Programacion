package ShipComponents;

/**
 * Class to represent the fortress armor component of a ship
 */
public class ArmorFortress extends Armor {

    /**
     * Constructor of the fortress armor
     */
    public ArmorFortress() {
        name = "Armadura Fortaleza";
        atk = 0;
        def = 100;
        spd = 0;
        wt = 50;
        price = 1000.75;
        description = name + ", Ataque: " + atk + ", Defensa: " + def + ", Velocidad: " + spd + ", Peso: " + wt
                + ", Precio: $" + price;
    }

}