package ShipComponents;

/**
 * Class to represent the death laser weapon component of a ship
 */
public class WeaponDeathlaser extends Weapon {

    /**
     * Constructor of the death laser
     */
    public WeaponDeathlaser() {
        name = "Arma Laser Destructor de Planetas";
        atk = 666;
        def = 0;
        spd = 0;
        wt = 777;
        price = 99599.99;
        description = name + ", Ataque: " + atk + ", Defensa: " + def + ", Velocidad: " + spd + ", Peso: " + wt
                + ", Precio: $" + price;
    }

}
