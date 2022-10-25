package stores;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import products.*;
import utility.*;
import clients.*;

/**
 * Class to represent a store
 * A store has a iterator of products (instance of {@link CatalogueIterator}), a
 * client (instance of {@link ClientInterface}), a language (instance of
 * {@link Language}), a list of products (instance of {@link Product}), an asker
 * (instance of {@link Asker}), a number of products in the iterator and a price
 * for the list of products
 */
public class Store {

    /* The iterator of products */
    private CatalogIterator iter;

    /* The client */
    private ClientInterface client;

    /* The language */
    private Language lang;

    /* The list of products */
    private List<Product> cart;

    /* The asker */
    private Asker asker;

    /* The number of products in the iterator */
    private int total;

    /* The price for the list of products */
    private double price;

    /**
     * Constructor
     * 
     * @param builder the builder to build the store
     */
    public Store(StoreBuilder builder) {
        this.iter = builder.iter;
        this.client = builder.client;
        this.lang = builder.lang;
        lang.setStore(this);
        this.cart = new LinkedList<>();
        this.asker = Asker.getAsker();
        total();
    }

    /**
     * Method to obtain and set the number of products in the iterator
     */
    private void total() {
        total = 0;
        while (iter.hasNext()) {
            iter.next();
            total++;
        }
    }

    /**
     * Method to make the store work
     */
    public void work() {
        // TODO: Implement this method
    }

    /**
     * Method to show the products in the catalog
     */
    private void showCatalog() {
        System.out.println(printShow());
        int i = 0;
        iter.restart();
        while (iter.hasNext()) {
            Product product = iter.next();
            System.out.println("[" + i + "]" + product);
        }
    }

    /**
     * Method for the client to start shopping
     */
    private void buy() {
        boolean working = true;
        while (working) {
            showCatalog();
            System.out.println("[" + total + "]" + printFinishBuy());
            working = addElement();
        }
    }

    /**
     * Method to add a product to the list of products
     * 
     * @return true if the client wants to continue shopping, false otherwise
     */
    private boolean addElement() {
        int i = asker.askOption(printAskProd(), 0, total, printInvalid());
        if (i == total) {
            return false;
        }
        iter.restart();
        for (int j = 0; j < i; j++) {
            iter.next();
        }
        cart.add(iter.next());
        return true;
    }

    /**
     * Method to check if the clients gives the correct bank number of the account
     * 
     * @return true if the client gives the correct bank number of the account,
     *         false otherwise
     */
    private boolean checkAccount() {
        long ac = asker.askLong(printBank(), 0L, Long.MAX_VALUE, printInvalid());
        long acoriginal = client.getBankNumber();
        return ac == acoriginal;
    }

    /**
     * Method to calculate and set the price of the list of products
     */
    private void money() {
        Coupon coupon = client.getCoupon();
        Country country = client.getNationality();
        double sum = 0;
        if (coupon != null) {
            Department department = country.getDepartment();
            int discount = coupon.getPorcentage();
            for (Product product : cart) {
                if (product.getDepartment() == department) {
                    sum += product.getPrice() * (1 - discount / 100.0);
                } else {
                    sum += product.getPrice();
                }
            }
        } else {
            for (Product product : cart) {
                sum += product.getPrice();
            }
        }
        price = sum;
    }

    /**
     * Method to check if the client has enough money to pay for the list of
     * products
     * 
     * @return true if the client has enough money to pay for the list of products,
     *         false otherwise
     */
    private boolean verifyMoney() {
        double actual = client.getMoney();
        return actual >= price;
    }

    /**
     * Method to generate a ticket for the client
     */
    private void generateTicket() {
        String ticket = "";
        ticket += printTicket() + " " + ThreadLocalRandom.current().nextInt(0, 1000) + "\n";
        ticket += printClient() + ": " + client.getName() + "\t id;" + client.getId() + "\n";
        ticket += printDate() + ": " + LocalDate.now().toString() + "\n";
        ticket += printProd() + ":\n";
        for (Product product : cart) {
            ticket += product.toString() + "\n";
        }
        ticket += "Total: $" + price + ", " + printApply() + "\n";
        ticket += printDeliver() + ": " + generateDate() + "\n";
        System.out.println(ticket);
    }

    /**
     * Method to generate a date for the delivery
     * Source: https://stackoverflow.com/a/40253413
     * 
     * @return the date for the delivery
     */
    private String generateDate() {
        LocalDate startD = LocalDate.now();
        long start = startD.toEpochDay();
        LocalDate endD = LocalDate.of(2023, 12, 31);
        long end = endD.toEpochDay();
        long randomDate = ThreadLocalRandom.current().longs(start, end).findAny().getAsLong();
        return LocalDate.ofEpochDay(randomDate).toString();
    }

    /**
     * Method to get in a string the message "show the products in the catalog" in
     * the clients language
     * 
     * @return the message
     */
    private String printShow() {
        return lang.printShow();
    }

    /**
     * Method to get in a string the message "choose a product" in the clients
     * language
     * 
     * @return the message
     */
    private String printAskProd() {
        return lang.printAskProd();
    }

    /**
     * Method to get in a string the message "invalid input" in the clients language
     * 
     * @return the message
     */
    private String printInvalid() {
        return lang.printInvalid();
    }

    /**
     * Method to get in a string the message "finish buying" in the clients language
     * 
     * @return the message
     */
    private String printFinishBuy() {
        return lang.printFinishBuy();
    }

    /**
     * Method to get in a string the message "enter the bank number of your account"
     * in the clients language
     * 
     * @return the message
     */
    private String printBank() {
        return lang.printBank();
    }

    /**
     * Method to get in a string the message "Ticket" in the clients language
     * 
     * @return the message
     */
    private String printTicket() {
        return lang.printTicket();
    }

    /**
     * Method to get in a string the message "Client" in the clients language
     * 
     * @return the message
     */
    private String printClient() {
        return lang.printClient();
    }

    /**
     * Method to get in a string the message "Date" in the clients language
     * 
     * @return the message
     */
    private String printDate() {
        return lang.printDate();
    }

    /**
     * Method to get in a string the message "Products" in the clients
     * language
     * 
     * @return the message
     */
    private String printProd() {
        return lang.printProd();
    }

    /**
     * Method to get in a string the message "prices have the discount applied" in
     * the clients language
     * 
     * @return the message
     */
    private String printApply() {
        return lang.printApply();
    }

    /**
     * Method to get in a string the message "Delivery date" in the clients
     * language
     * 
     * @return the message
     */
    private String printDeliver() {
        return lang.printDeliver();
    }

}
