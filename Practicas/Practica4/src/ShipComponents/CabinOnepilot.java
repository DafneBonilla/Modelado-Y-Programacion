package ShipComponents;

/**
 * Class to represent the one pilot cabin component of a ship
 */
public class CabinOnepilot extends Cabin {

    /**
     * Constructor of the one pilot cabin
     */
    public CabinOnepilot() {
        name = "Cabina Un Piloto";
        atk = 0;
        def = 0;
        spd = 0;
        wt = 10;
        price = 149.50;
        description = name + ", Ataque: " + atk + ", Defensa: " + def + ", Velocidad: " + spd + ", Peso: " + wt
                + ", Precio: $" + price;
    }

}
