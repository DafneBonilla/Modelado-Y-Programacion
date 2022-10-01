package Ships;

import java.util.concurrent.ThreadLocalRandom;
import ShipComponents.*;

/**
 * Class to represent a ship
 * A ship has a name, a propulsion, an armor, a cabin and a weapon (all of them
 * are an instance of {@link Component}), also has
 * values for attack, defense, speed, weight and price
 */
public class Ship {

    /* Propulsion of the ship */
    private Component propulsion;

    /* Armor of the ship */
    private Component armor;

    /* Cabin of the ship */
    private Component cabin;

    /* Weapon of the ship */
    private Component weapon;

    /* Name of the ship */
    private String name;

    /* Attack of the ship */
    private int atk;

    /* Defense of the ship */
    private int def;

    /* Speed of the ship */
    private int spd;

    /* Weight of the ship */
    private int wt;

    /* Price of the ship */
    private double price;

    /**
     * Constructor of the ship, uses a builder to build the ship
     * 
     * @param builder builder to build the ship
     */
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

    /**
     * Returns a description of the ship
     * 
     * @return description of the ship
     */
    public String getDescription() {
        String datos = "Nave con nombre: " + name + ", con propulsion: " + propulsion.getName() + ", con armadura: "
                + armor.getName() + ", con cabina: " + cabin.getName() + " y con arma: " + weapon.getName();
        datos += "\nCon las siguientes caracteristicas: Ataque: " + atk + ", Defensa: " + def + ", Velocidad: " + spd
                + " y Peso: " + wt;
        datos += "\nUn precio de: $" + price;
        return datos;
    }

    /**
     * Returns the price of the ship
     * 
     * @return price of the ship
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the name of the ship
     * 
     * @param name name of the ship
     */
    public void setName(String name) {
        this.name = name;
    }

}
