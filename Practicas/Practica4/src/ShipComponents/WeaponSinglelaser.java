package ShipComponents;

/**
 * Class to represent the single laser weapon component of a ship
 */
public class WeaponSinglelaser extends Weapon {

    /**
     * Constructor of the single laser
     */
    public WeaponSinglelaser() {
        name = "Arma Laser Simple";

        atk = 55;
        def = 0;
        spd = 0;
        wt = 10;
        price = 99.99;

        description = name + ", Ataque: " + atk + ", Defensa: " + def + ", Velocidad: " + spd + ", Peso: " + wt
                + ", Precio: $" + price;
    }

}
