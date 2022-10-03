package ShipComponents;

/**
 * Class to represent the interplanetary propulsion component of a ship
 */
public class PropulsionInterplanetary extends Propulsion {

    /**
     * Constructor of the interplanetary propulsion
     */
    public PropulsionInterplanetary() {
        name = "Propulsion Interplanetaria";
        atk = 0;
        def = 0;
        spd = 50;
        wt = 64;
        price = 1200.43;
        description = name + ", Ataque: " + atk + ", Defensa: " + def + ", Velocidad: " + spd + ", Peso: " + wt
                + ", Precio: $" + price;
    }

}
