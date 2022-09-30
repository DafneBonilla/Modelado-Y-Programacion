package ShipComponents;

public class CabinSmallcrew extends Cabin {

    public CabinSmallcrew() {
        name = "Cabina Tripulacion Pequenia";
        atk = 0;
        def = 0;
        spd = 0;
        wt = 50;
        price = 399.50;
        description = name + ", Ataque: " + atk + ", Defensa: " + def + ", Velocidad: " + spd + ", Peso: " + wt
                + ", Precio: $" + price;
    }

}
