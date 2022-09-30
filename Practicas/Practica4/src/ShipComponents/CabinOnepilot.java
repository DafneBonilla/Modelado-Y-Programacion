package ShipComponents;

public class CabinOnepilot extends Cabin {

    public CabinOnepilot() {
        name = "Cabina Un Piloto";
        description = name + ", Ataque: " + atk + ", Defensa: " + def + ", Velocidad: " + spd + ", Peso: " + wt
                + ", Precio: $" + price;
        atk = 0;
        def = 0;
        spd = 0;
        wt = 10;
        price = 149.50;
    }

}
