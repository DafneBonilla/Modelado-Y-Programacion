package Manufacture;

import java.util.concurrent.ThreadLocalRandom;
import Parts.*;

public class Ship {

    private Component propulsion;

    private Component armor;

    private Component cabin;

    private Component weapon;

    private String name;

    private int atk;

    private int def;

    private int spd;

    private int wt;

    private double price;

    public Ship(ShipBuilder builder) {
        name = "Nave-" + ThreadLocalRandom.current().nextInt(1000, 9999);
        this.propulsion = builder.propulsion;
        this.armor = builder.armor;
        this.cabin = builder.cabin;
        this.weapon = builder.weapon;
        this.atk = builder.atk;
        this.def = builder.def;
        this.spd = builder.spd;
        this.wt = builder.wt;
        this.price = builder.price;
    }

    public String getDescription() {
        String datos = "Nave con nombre: " + name + ", con propulsion: " + propulsion.getName() + ", con armadura: "
                + armor.getName() + ", con cabina: " + cabin.getName() + " y con arma: " + weapon.getName();
        datos += "\nCon las siguientes caracteristicas: Ataque: " + atk + ", Defensa: " + def + ", Velocidad: " + spd
                + " y Peso: " + wt;
        datos += "\nUn precio de: $" + price;
        return datos;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

}
