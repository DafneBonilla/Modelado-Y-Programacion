package ShipComponents;

/**
 * Class to represent the army cabin component of a ship
 */
public class CabinArmy extends Cabin {

    /**
     * Constructor of the army cabin
     */
    public CabinArmy() {
        name = "Cabina Ejercito";
        atk = 0;
        def = 0;
        spd = 0;
        wt = 100;
        price = 799.99;
        description = name + ", Ataque: " + atk + ", Defensa: " + def + ", Velocidad: " + spd + ", Peso: " + wt
                + ", Precio: $" + price;
    }

}
