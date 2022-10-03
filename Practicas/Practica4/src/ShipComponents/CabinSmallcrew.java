package ShipComponents;

/**
 * Class to represent the small crew cabin component of a ship
 */
public class CabinSmallcrew extends Cabin {

    /**
     * Constructor of the small crew cabin
     */
    public CabinSmallcrew() {
        name = "Cabina Tripulacion Pequenia";
        atk = 0;
        def = 0;
        spd = 0;
        wt = 50;
        price = 399.50;
        description = name + ", Ataque: " + atk + ", Defensa: " + def + ", Velocidad: " + spd + ", Peso: " + wt
                + ", Precio: $" + price;
    }

}
