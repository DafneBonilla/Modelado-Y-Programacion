package walmart;

import stores.*;
import utility.*;
import clients.*;
import products.*;
import java.util.List;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Class to represent a Walmart2
 * A Walmart2 has a list of clients (instances of {@link ClientInterface}), a
 * catalog (instance of {@link Catalog}), a store (instance of {@link Store})
 * and a coupon (instance of {@link Coupon})
 */
public class Walmart2 implements Subject, Serializable {

    /* The list of clients */
    private List<ClientInterface> clients;

    /* The catalog */
    private Catalog catalog;

    /* The coupon */
    private Coupon coupon;

    /**
     * Constructor
     * 
     * @param clients the list of clients
     * @param catalog the catalog
     */
    public Walmart2(List<ClientInterface> clients, Catalog catalog) {
        this.clients = clients;
        this.catalog = catalog;
    }

    /**
     * Method to remove the coupon from all the clients and set the walmart2 of the
     * clients to this
     */
    private void removeCoupon() {
        this.coupon = null;
        for (ClientInterface client : clients) {
            client.setWalmart(this);
            client.update();
        }
    }

    /**
     * Method to generate a random new coupon
     */
    private void randomCoupon() {
        int random2 = ThreadLocalRandom.current().nextInt(0, 3 + 1);
        if (random2 == 0) {
            coupon = null;
        } else {
            List<Country> countries = generateList(random2);
            int random = ThreadLocalRandom.current().nextInt(10, 65 + 1);
            coupon = new Coupon(random, countries);
        }
    }

    /**
     * Method to generate a list of random countries
     * 
     * @param i the number of countries to generate
     * @return the list of countries
     */
    private List<Country> generateList(int i) {
        List<Country> countries = new LinkedList<>();
        for (int j = 0; j < i; j++) {
            int random = ThreadLocalRandom.current().nextInt(0, 2 + 1);
            switch (random) {
                case 0:
                    if (!countries.contains(Country.MEXICO)) {
                        countries.add(Country.MEXICO);
                    }
                    break;
                case 1:
                    if (!countries.contains(Country.USA)) {
                        countries.add(Country.USA);
                    }
                    break;
                case 2:
                    if (!countries.contains(Country.SPAIN)) {
                        countries.add(Country.SPAIN);
                    }
                    break;
                default:
                    break;
            }
        }
        return countries;
    }

    /**
     * Method to give the coupon to all the clients
     */
    private void giveCoupons() {
        if (coupon != null) {
            for (ClientInterface client : clients) {
                Iterator<Country> it = coupon.getCountries().iterator();
                if (client.check(it)) {
                    client.update();
                }
            }
        }
    }

    /**
     * Method to make Walmart2 work
     */
    public void work() {
        notifyObservers();
        while (true) {
            ClientInterface client = verify();
            if (client == null) {
                break;
            }
            if (client.getClass().equals(Client.class)) {
                client.setWalmart(this);
                client.update();
                registerObserver(client);
                client = new ClientProxy((Client) client);
            }
            Store store = store(client);
            store.work();
        }
        close();
    }

    /**
     * Method to get a client using the account manager
     * 
     * @return the client that the account manager obtained
     */
    private ClientInterface verify() {
        AccountManager manager = new AccountManager(clients);
        return manager.getAccount();
    }

    /**
     * Method to build a store that fits the client
     * 
     * @param client the client
     * @return the store that fits the client
     */
    private Store store(ClientInterface client) {
        StoreBuilder storeB = new StoreBuilderDefault();
        storeB = storeB.client(client);
        storeB = storeB.iterator(catalog.iterator());
        return storeB.build();

    }

    /**
     * Method to close Walmart2 and save in a file the clients
     */
    private void close() {
        Files file = Files.getFiles();
        file.zipClients(clients);
    }

    /**
     * Method to register an observer
     * 
     * @param o the observer to register
     */
    @Override
    public void registerObserver(Observer o) {
        clients.add((ClientInterface) o);
    }

    /**
     * Method to remove an observer
     * 
     * @param o the observer to remove
     */
    @Override
    public void removeObserver(Observer o) {
        clients.remove((ClientInterface) o);
    }

    /**
     * Method to notify the observers
     */
    @Override
    public void notifyObservers() {
        removeCoupon();
        randomCoupon();
        giveCoupons();
    }

    /**
     * Method to get the coupon
     * 
     * @return the coupon
     */
    public Coupon getCoupon() {
        return coupon;
    }

}
