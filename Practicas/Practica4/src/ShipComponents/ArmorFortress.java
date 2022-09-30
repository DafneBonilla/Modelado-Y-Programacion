package ShipComponents;

public class ArmorFortress extends Armor {

    public ArmorFortress() {
        name = "Armadura Fortaleza";
        description = name + ", Ataque: " + atk + ", Defensa: " + def + ", Velocidad: " + spd + ", Peso: " + wt
                + ", Precio: $" + price;
        atk = 0;
        def = 100;
        spd = 0;
        wt = 50;
        price = 1000.75;
    }

}