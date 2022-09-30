package ShipComponents;

public class PropulsionInterplanetary extends Propulsion {

    public PropulsionInterplanetary() {
        name = "Propulsion Interplanetaria";
        atk = 0;
        def = 0;
        spd = 50;
        wt = 64;
        price = 1200.43;
        description = name + ", Ataque: " + atk + ", Defensa: " + def + ", Velocidad: " + spd + ", Peso: " + wt
                + ", Precio: $" + price;
    }

}
