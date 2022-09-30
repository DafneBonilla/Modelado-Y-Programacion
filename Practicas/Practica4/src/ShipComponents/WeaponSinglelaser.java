package ShipComponents;

public class WeaponSinglelaser extends Weapon {

    public WeaponSinglelaser() {
        name = "Arma Laser Simple";
        description = name + ", Ataque: " + atk + ", Defensa: " + def + ", Velocidad: " + spd + ", Peso: " + wt
                + ", Precio: $" + price;
        atk = 55;
        def = 0;
        spd = 0;
        wt = 10;
        price = 99.99;
    }

}
