package ShipComponents;

public class CabinArmy extends Cabin {

    public CabinArmy() {
        name = "Cabina Ejercito";
        description = name + ", Ataque: " + atk + ", Defensa: " + def + ", Velocidad: " + spd + ", Peso: " + wt
                + ", Precio: $" + price;
        atk = 0;
        def = 0;
        spd = 0;
        wt = 100;
        price = 799.99;
    }

}
