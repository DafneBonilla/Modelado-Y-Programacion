import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import ShipComponents.*;
import ShipComponents.ShipComponentsFactory.*;
import Ships.*;

public class ShipSeller {

    private Ship order;

    private ShipBuilder builder;

    private ShipFactory factory;

    private ComponentFactory tinyFactory;

    private List<Ship> catalog;

    private List<Component> propulsions;

    private List<Component> armors;

    private List<Component> cabins;

    private List<Component> weapons;

    private double bugdet;

    private boolean capable;

    public ShipSeller() {
        makeCatalog();
        fillComponents();
    }

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

    private void fillComponents() {
        fillPropulsions();
        fillArmors();
        fillCabin();
        fillWeapons();
    }

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

    public void work() {
        System.out.println("Bienvenido a la tienda de naves espaciales");
        bugdet = askDouble("Ingresa tu presupuesto");
        normal();
    }

    private void normal() {
        desingShip();
        check();
    }

    private void notNormal() {
        askCatalog();
        check();
    }

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

    private void desingShip() {
        System.out.println("Es hora de crear tu nave");
        askPersonalized();
        System.out.println("La nave que creaste es:");
        System.out.println(order.getDescription());
    }

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

    private void resetBuilder() {
        builder = new ShipBuilderPersonalized();
    }

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

    private boolean checkBudget() {
        if (order == null) {
            return false;
        }
        return order.getPrice() <= bugdet;
    }

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
