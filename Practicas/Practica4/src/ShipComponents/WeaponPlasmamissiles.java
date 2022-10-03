package ShipComponents;

/**
 * Class to represent the plasma missiles weapon component of a ship
 */
public class WeaponPlasmamissiles extends Weapon {

    /**
     * Constructor of the plasma missiles
     */
    public WeaponPlasmamissiles() {
        name = "Arma Misiles de Plasma";
        atk = 100;
        def = 0;
        spd = 0;
        wt = 56;
        price = 291.08;
        description = name + ", Ataque: " + atk + ", Defensa: " + def + ", Velocidad: " + spd + ", Peso: " + wt
                + ", Precio: $" + price;
    }

}
