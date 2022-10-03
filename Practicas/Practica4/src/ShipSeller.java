import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import ShipComponents.*;
import ShipComponents.ShipComponentsFactory.*;
import Ships.*;

/**
 * Class to represent a ship seller, it sells ships to the client
 * A ship seller has an order (an instance of the class {@link Ship}), an
 * instance of the class {@link ShipBuilder} to build the ship, an instance of
 * the class {@link ShipFactory} to create predefined ships, an instance of the
 * class {@link ComponentFactory} to fill components lists, a list of
 * instances of the class {@link Ship} for a catalog, also has a list of
 * propulsions, armors, cabins and weapons (all of them are lists of instances
 * of the class {@link Component}), the budget of a client and a boolean to know
 * if the user can pay for a ship
 */
public class ShipSeller {

    /* Order of the ship seller */
    private Ship order;

    /* Ship builder of the ship seller */
    private ShipBuilder builder;

    /* Ship factory of the ship seller */
    private ShipFactory factory;

    /* Component factory of the ship seller */
    private ComponentFactory tinyFactory;

    /* Catalog of the ship seller */
    private List<Ship> catalog;

    /* List of propulsions of the ship seller */
    private List<Component> propulsions;

    /* List of armors of the ship seller */
    private List<Component> armors;

    /* List of cabins of the ship seller */
    private List<Component> cabins;

    /* List of weapons of the ship seller */
    private List<Component> weapons;

    /* Budget of client */
    private double bugdet;

    /* Boolean to know if the user can pay for a ship */
    private boolean capable;

    /**
     * Constructor of the ship seller
     * Makes the catalog and fill the lists of components
     */
    public ShipSeller() {
        makeCatalog();
        fillComponents();
    }

    /**
     * Makes the catalog of the ship seller
     */
    private void makeCatalog() {
        catalog = new LinkedList<Ship>();
        factory = new ShipFactoryGeneric();
        for (int i = 0; i < 3; i++) {
            Ship s = factory.build(i);
            if (s != null) {
                s.setName(getNameShip(i));
                catalog.add(s);
            }
        }
    }

    /**
     * Returns the i-th name that the ship in the catalog will have
     * 
     * @param i integer of the ship in the catalog
     * @return the name that the ship will have
     */
    private String getNameShip(int i) {
        switch (i) {
            case 0:
                return "Nave individual de combate";
            case 1:
                return "Nave militar de transporte";
            case 2:
                return "Base espacial de guerra";
            default:
                return "Ninguno";
        }
    }

    /**
     * Fills the lists of components of the ship seller
     */
    private void fillComponents() {
        fillPropulsions();
        fillArmors();
        fillCabin();
        fillWeapons();
    }

    /**
     * Fills the list of propulsions of the ship seller
     */
    private void fillPropulsions() {
        propulsions = new LinkedList<Component>();
        tinyFactory = new PropulsionFactory();
        for (int i = 0; i < 3; i++) {
            Component c = tinyFactory.build(i);
            if (c != null) {
                propulsions.add(c);
            }
        }
    }

    /**
     * Fills the list of armors of the ship seller
     */
    private void fillArmors() {
        armors = new LinkedList<Component>();
        tinyFactory = new ArmorFactory();
        for (int i = 0; i < 3; i++) {
            Component c = tinyFactory.build(i);
            if (c != null) {
                armors.add(c);
            }
        }
    }

    /**
     * Fills the list of cabins of the ship seller
     */
    private void fillCabin() {
        cabins = new LinkedList<Component>();
        tinyFactory = new CabinFactory();
        for (int i = 0; i < 3; i++) {
            Component c = tinyFactory.build(i);
            if (c != null) {
                cabins.add(c);
            }
        }
    }

    /**
     * Fills the list of weapons of the ship seller
     */
    private void fillWeapons() {
        weapons = new LinkedList<Component>();
        tinyFactory = new WeaponFactory();
        for (int i = 0; i < 3; i++) {
            Component c = tinyFactory.build(i);
            if (c != null) {
                weapons.add(c);
            }
        }
    }

    /**
     * Makes the ship seller work
     * This method makes the magic happen
     */
    public void work() {
        System.out.println("Bienvenido a la tienda de naves espaciales");
        bugdet = askDouble("Ingresa tu presupuesto");
        normal();
    }

    /**
     * Makes the ship seller work in the normal mode
     * Normal mode is to build the ship depending on what the client wants and then
     * check if the client can pay for it
     */
    private void normal() {
        desingShip();
        check();
    }

    /**
     * Makes the ship seller work in the not normal mode
     * Not normal mode is ask the client to choose a ship from the catalog and then
     * check if the client can pay for it
     */
    private void notNormal() {
        askCatalog();
        check();
    }

    /**
     * Checks if the client can pay for the ship
     * If the client can pay for the ship, the ship will be built and given to the
     * client, but if the client can't pay for the ship, the seller will ask the
     * client if they wanto to build another ship (in the normal mode) or if they
     * want to choose a ship from the catalog (in the not normal mode)
     */
    private void check() {
        if (checkBudget()) {
            System.out.print("Tu nave se esta construyendo");
            for (int i = 0; i < 3; i++) {
                System.out.print(".");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
            System.out.println("Tu nave esta lista");
            System.out.println("Estas son las caracteristicas de tu nave:\n" + order.getDescription());
            System.out.println("Pasa a la caja para pagar $" + order.getPrice());
            System.out.println("Gracias por comprar en la tienda de naves espaciales");
        } else {
            System.out.println("El costo de tu nave es mayor a tu presupuesto");
            int option = askOption("¿Deseas diseniar otra nave o ver el catalogo? (0) Diseniar (1) Catalogo", 0, 1);
            if (option == 0) {
                normal();
            } else {
                notNormal();
            }
        }
    }

    /**
     * Guides the clients to design the ship they are building
     */
    private void desingShip() {
        System.out.println("Es hora de crear tu nave");
        askPersonalized();
        System.out.println("La nave que creaste es:");
        System.out.println(order.getDescription());
    }

    /**
     * Asks the client what components they want for the ship they are building
     * After the client chooses the components, it gives the possibility to the
     * client to give the ship a name
     */
    private void askPersonalized() {
        resetBuilder();
        askPropulsion();
        askArmor();
        askCabin();
        askWeapon();
        order = builder.build();
        int i = askOption("¿Deseas ponerle un nombre a tu nave? (0) Si (1) No", 0, 1);
        if (i == 0) {
            String name = askString("¿Como quieres llamar a tu nave?");
            order.setName(name);
        }
    }

    /**
     * Asks the client what propulsion they want for the ship they are building
     */
    private void askPropulsion() {
        String wowi = "Ingresa el numero de la propulsion que deseas: \n";
        int i = 0;
        for (Component c : propulsions) {
            wowi += "[" + i + "] " + c.getDescription() + "\n";
            i++;
        }
        int res = askOption(wowi, 0, i - 1);
        builder = builder.propulsion(res);
    }

    /**
     * Asks the client what armor they want for the ship they are building
     */
    private void askArmor() {
        String wowi = "Ingresa el numero de armadura que deseas: \n";
        int i = 0;
        for (Component c : armors) {
            wowi += "[" + i + "] " + c.getDescription() + "\n";
            i++;
        }
        int res = askOption(wowi, 0, i - 1);
        builder = builder.armor(res);
    }

    /**
     * Asks the client what cabin they want for the ship they are building
     */
    private void askCabin() {
        String wowi = "Ingresa el numero de cabina que deseas: \n";
        int i = 0;
        for (Component c : cabins) {
            wowi += "[" + i + "] " + c.getDescription() + "\n";
            i++;
        }
        int res = askOption(wowi, 0, i - 1);
        builder = builder.cabin(res);
    }

    /**
     * Asks the client what weapon they want for the ship they are building
     */
    private void askWeapon() {
        String wowi = "Ingresa el numero de arma que deseas: \n";
        int i = 0;
        for (Component c : weapons) {
            wowi += "[" + i + "] " + c.getDescription() + "\n";
            i++;
        }
        int res = askOption(wowi, 0, i - 1);
        builder = builder.weapon(res);
    }

    /**
     * Resets the builder of the ship builder
     */
    private void resetBuilder() {
        builder = new ShipBuilderPersonalized();
    }

    /**
     * Asks the client which ship they want from the catalog
     * If they don't have the budget to buy a ship from the catalog, the client can
     * exit the shop
     */
    private void askCatalog() {
        String s = showCatalog();
        s += "Ingresa el numero de la nave que deseas: ";
        int res;
        if (capable) {
            res = askOption(s, 0, catalog.size() - 1);
            order = catalog.get(res);
        } else {
            res = askOption(s, 0, catalog.size());
            if (res == catalog.size()) {
                System.out.println("Gracias por visitar la tienda de naves espaciales");
                System.exit(0);
            }
            order = catalog.get(res);
        }
    }

    /**
     * Returns a string with all the options of ships from the catalog
     * If the client can't pay for a ship from the catalog, an option to exit the
     * shop will be added
     * 
     * @return a string with all the options of ships from the catalog
     */
    private String showCatalog() {
        System.out.println("Estas son las naves que tenemos en el catalogo");
        int i = 0;
        String wowi = "Naves en catalogo: \n";
        for (Ship s : catalog) {
            wowi += "[" + i + "] " + s.getDescription() + "\n";
            i++;
        }
        if (!checkB()) {
            wowi += "[" + i + "] " + "Salir\n";
        }
        return wowi;
    }

    /**
     * Checks if the client has the budget to buy a ship from the catalog
     * 
     * @return true if the client has the budget to buy a ship from the catalog
     */
    private boolean checkB() {
        boolean res = false;
        for (Ship s : catalog) {
            if (s.getPrice() <= bugdet) {
                res = true;
            }
        }
        capable = res;
        return res;
    }

    /**
     * Checks if the client has the budget to buy the ship they have ordered
     * 
     * @return true if the client has the budget to buy the ship they have ordered
     */
    private boolean checkBudget() {
        if (order == null) {
            return false;
        }
        return order.getPrice() <= bugdet;
    }

    /**
     * Ask the client for an option (an integer)
     * The option must be between min and max
     *
     * @param message the question to ask
     * @param min     the minimum option
     * @param max     the maximum option
     * @return the option chosen by the client
     */
    private int askOption(String message, int min, int max) {
        int answer = -1;
        boolean valid = false;
        Scanner sc = new Scanner(System.in);
        while (!valid) {
            System.out.println(message);
            try {
                String text = sc.nextLine();
                answer = Integer.parseInt(text);
                if (answer >= min && answer <= max) {
                    valid = true;
                } else {
                    System.out.println("Opcion invalida");
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Opcion invalida");
            }
        }
        return answer;
    }

    /**
     * Ask the client for a string
     * The string can't be empty
     *
     * @param message the question to ask
     * @return the string chosen by the client
     */
    private String askString(String message) {
        String answer = "";
        boolean valid = false;
        Scanner sc = new Scanner(System.in);
        while (!valid) {
            System.out.println(message);
            answer = sc.nextLine();
            if (answer.length() > 0) {
                valid = true;
            } else {
                System.out.println("Opcion invalida");
            }
        }
        return answer;
    }

    /**
     * Ask the client for a double
     * The double must be greater than 0
     *
     * @param message the question to ask
     * @return the double chosen by the client
     */
    private double askDouble(String message) {
        double answer = -1;
        boolean valid = false;
        Scanner sc = new Scanner(System.in);
        while (!valid) {
            System.out.println(message);
            try {
                String text = sc.nextLine();
                answer = Double.parseDouble(text);
                if (answer > 0) {
                    valid = true;
                } else {
                    System.out.println("Opcion invalida");
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Opcion invalida");
            }
        }
        return answer;
    }

}
