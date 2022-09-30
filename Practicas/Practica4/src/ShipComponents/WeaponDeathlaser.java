package ShipComponents;

public class WeaponDeathlaser extends Weapon {

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
