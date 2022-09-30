package ShipComponents;

public class PropulsionIntergalactic extends Propulsion {

    public PropulsionIntergalactic() {
        name = "Propulsion Intergalactica";
        description = name + ", Ataque: " + atk + ", Defensa: " + def + ", Velocidad: " + spd + ", Peso: " + wt
                + ", Precio: $" + price;
        atk = 0;
        def = 0;
        spd = 100;
        wt = 128;
        price = 5879.00;
    }

}