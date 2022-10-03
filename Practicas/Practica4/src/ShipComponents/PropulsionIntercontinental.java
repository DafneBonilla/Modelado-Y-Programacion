package ShipComponents;

/**
 * Class to represent the intercontinental propulsion component of a ship
 */
public class PropulsionIntercontinental extends Propulsion {

    /**
     * Constructor of the intercontinental propulsion
     */
    public PropulsionIntercontinental() {
        name = "Propulsion Intercontinental";
        atk = 0;
        def = 0;
        spd = 25;
        wt = 32;
        price = 700.01;
        description = name + ", Ataque: " + atk + ", Defensa: " + def + ", Velocidad: " + spd + ", Peso: " + wt
                + ", Precio: $" + price;
    }

}
