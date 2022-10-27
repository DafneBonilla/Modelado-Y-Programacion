import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import PizzasDonCangrejo.*;
import WaySub.*;

/**
 * Class to represent a cashier.
 * A cashier has an order, a list of breads, a list of ingredients and a list of
 * pizzas.
 */
public class Cashier {

    /* The order of the cashier. */
    private Sandwich order;

    /* The list of breads. */
    private List<Sandwich> bread;

    /* The list of ingredients. */
    private List<Sandwich> ingredients;

    /* The list of pizzas. */
    private List<Sandwich> pizzas;

    /**
     * Constructor for cashier.
     */
    public Cashier() {
        order = null;
        bread = new ArrayList<>();
        ingredients = new ArrayList<>();
        pizzas = new ArrayList<>();
        makeList1();
        makeList2();
        makeList3();
    }

    /**
     * FIlls the list of breads.
     */
    private void makeList1() {
        bread.add(new BreadWhite());
        bread.add(new BreadOat());
        bread.add(new BreadOregano());
    }

    /**
     * Fills the list of ingredients.
     */
    private void makeList2() {
        ingredients.add(new Chicken(null));
        ingredients.add(new Pepperoni(null));
        ingredients.add(new Ham(null));
        ingredients.add(new Lettuce(null));
        ingredients.add(new Tomato(null));
        ingredients.add(new Onion(null));
        ingredients.add(new Mustard(null));
        ingredients.add(new Ketchup(null));
        ingredients.add(new Mayonnaise(null));
    }

    /**
     * FIlls the list of pizzas.
     */
    private void makeList3() {
        pizzas.add(new AdapterPizza(new PizzaChicken()));
        pizzas.add(new AdapterPizza(new PizzaHam()));
        pizzas.add(new AdapterPizza(new PizzaSausage()));
        pizzas.add(new AdapterPizza(new PizzaSpecial1()));
        pizzas.add(new AdapterPizza(new PizzaSpecial2()));
    }

    /**
     * Ask the client what is going to order.
     */
    public void askOrder() {
        String question = "¿Que deseas ordenar?\n(0) Sandwich\n(1) Pizza";
        int answer = askOption(question, 0, 1);
        if (answer == 0) {
            askSandwich();
        } else {
            askPizza();
        }
    }

    /**
     * Ask the client what kind of bread he wants.
     */
    private void askSandwich() {
        String question = "¿Que tipo de pan deseas?";
        int index = 0;
        for (Sandwich b : bread) {
            question += "\n(" + index++ + ") " + b.getName() + " $ " + b.getPrice();
        }
        int answer = askOption(question, 0, 2);
        switch (answer) {
            case 0:
                order = new BreadWhite();
                break;
            case 1:
                order = new BreadOat();
                break;
            case 2:
                order = new BreadOregano();
                break;
            default:
                System.out.println("Algo salio mal");
                break;
        }
        askIngredient();
    }

    /**
     * Ask the client what ingredients he wants for his sandwich.
     */
    private void askIngredient() {
        String question = "¿Que ingredientes deseas agregar?";
        int index = 0;
        for (Sandwich i : ingredients) {
            question += "\n(" + index++ + ") " + i.getName() + " $ " + i.getIngredientPrice();
        }
        question += "\n(9) Terminar";
        int answer;
        int num;
        String name;
        do {
            answer = askOption(question, 0, 9);
            switch (answer) {
                case 0:
                    name = ingredients.get(0).getName();
                    num = order.checkIngredient(name);
                    if (num >= 3) {
                        System.out.println("Solo puedes agregar 3 ingredientes de " + name);
                        break;
                    } else {
                        order = new Chicken(order);
                        break;
                    }
                case 1:
                    name = ingredients.get(1).getName();
                    num = order.checkIngredient(name);
                    if (num >= 3) {
                        System.out.println("Solo puedes agregar 3 ingredientes de " + name);
                        break;
                    } else {
                        order = new Pepperoni(order);
                        break;
                    }
                case 2:
                    name = ingredients.get(2).getName();
                    num = order.checkIngredient(name);
                    if (num >= 3) {
                        System.out.println("Solo puedes agregar 3 ingredientes de " + name);
                        break;
                    } else {
                        order = new Ham(order);
                        break;
                    }
                case 3:
                    name = ingredients.get(3).getName();
                    num = order.checkIngredient(name);
                    if (num >= 3) {
                        System.out.println("Solo puedes agregar 3 ingredientes de " + name);
                        break;
                    } else {
                        order = new Lettuce(order);
                        break;
                    }
                case 4:
                    name = ingredients.get(4).getName();
                    num = order.checkIngredient(name);
                    if (num >= 3) {
                        System.out.println("Solo puedes agregar 3 ingredientes de " + name);
                        break;
                    } else {
                        order = new Tomato(order);
                        break;
                    }
                case 5:
                    name = ingredients.get(5).getName();
                    num = order.checkIngredient(name);
                    if (num >= 3) {
                        System.out.println("Solo puedes agregar 3 ingredientes de " + name);
                        break;
                    } else {
                        order = new Onion(order);
                        break;
                    }
                case 6:
                    name = ingredients.get(6).getName();
                    num = order.checkIngredient(name);
                    if (num >= 3) {
                        System.out.println("Solo puedes agregar 3 ingredientes de " + name);
                        break;
                    } else {
                        order = new Mustard(order);
                        break;
                    }
                case 7:
                    name = ingredients.get(7).getName();
                    num = order.checkIngredient(name);
                    if (num >= 3) {
                        System.out.println("Solo puedes agregar 3 ingredientes de " + name);
                        break;
                    } else {
                        order = new Ketchup(order);
                        break;
                    }
                case 8:
                    name = ingredients.get(8).getName();
                    num = order.checkIngredient(name);
                    if (num >= 3) {
                        System.out.println("Solo puedes agregar 3 ingredientes de " + name);
                        break;
                    } else {
                        order = new Mayonnaise(order);
                        break;
                    }
                case 9:
                    break;
                default:
                    System.out.println("Algo salio mal");
                    break;
            }
        } while (answer != 9);
        System.out.println("Orden tomada");
    }

    /**
     * Ask the client what kind of pizza he wants.
     */
    private void askPizza() {
        String question = "¿Que tipo de pizza deseas ordenar?";
        int index = 0;
        for (Sandwich ap : pizzas) {
            question += "\n(" + index++ + ") " + ap.getName() + " $ " + ap.getPrice();
        }
        int answer = askOption(question, 0, 4);
        switch (answer) {
            case 0:
                order = new AdapterPizza(new PizzaChicken());
                break;
            case 1:
                order = new AdapterPizza(new PizzaHam());
                break;
            case 2:
                order = new AdapterPizza(new PizzaSausage());
                break;
            case 3:
                order = new AdapterPizza(new PizzaSpecial1());
                break;
            case 4:
                order = new AdapterPizza(new PizzaSpecial2());
                break;
            default:
                System.out.println("Algo salio mal");
                break;
        }
        System.out.println("Orden tomada");
    }

    /**
     * Ask the client for an option.
     *
     * @param message the question to ask.
     * @param min     the minimum option.
     * @param max     the maximum option.
     * @return the option chosen by the client.
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
            } catch (NumberFormatException nfe) {
                System.out.println("Opcion invalida");
            }
            if (answer >= min && answer <= max) {
                valid = true;
            } else {
                System.out.println("Opcion invalida");
            }
        }
        return answer;
    }

    /**
     * Prints the ticket with a full description of the order.
     */
    public void printTicket() {
        if (order != null) {
            System.out.println("Ticket:");
            System.out.println();
            System.out.println(order.getDescription());
            System.out.println();
            System.out.println("Precio: " + order.getPrice());
            System.out.println();
            System.out.println("Gracias por su compra");
        }
    }
}
