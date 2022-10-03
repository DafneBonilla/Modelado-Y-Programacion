package ShipComponents;

/**
 * Class to represent the intergalactic propulsion component of a ship
 */
public class PropulsionIntergalactic extends Propulsion {

    /**
     * Constructor of the intergalactic propulsion
     */
    public PropulsionIntergalactic() {
        name = "Propulsion Intergalactica";
        atk = 0;
        def = 0;
        spd = 100;
        wt = 128;
        price = 5879.00;
        description = name + ", Ataque: " + atk + ", Defensa: " + def + ", Velocidad: " + spd + ", Peso: " + wt
                + ", Precio: $" + price;
    }

}