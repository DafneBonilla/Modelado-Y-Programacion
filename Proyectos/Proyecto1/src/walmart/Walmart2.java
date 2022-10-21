package walmart;

import stores.*;
import clients.*;
import products.*;
import ask.*;
import java.util.List;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class Walmart2 implements Subject {
    
    private List<ClientInterface> clients;
    
    private Catalog<Catalog<Product>> catalog;

    private AccountManager manager;

    private StoreBuilder storeB;
    
    private Coupon coupon;

    public Walmart2(List<ClientInterface> clients, Catalog<Catalog<Product>> catalog) {
        this.clients = clients;
        this.catalog = catalog;
    }

    private void removeCoupon() {
        this.coupon = null;
        for (ClientInterface client : clients) {
            client.setWalmart(this);
            client.update();
        }
    }
    
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

    public void work() {
        
    }

    private ClientInterface verify() {
        manager = new AccountManager(clients);
        return manager.getAccount();
    }
    
    private Store store (ClientInterface client) {    
        storeB = new StoreBuilder();
        storeB = storeB.client(client);
        storeB = storeB.iterator(generate());
        return storeB.build();

    }

    private CatalogIterator<CatalogIterator<Product>> generate() {
        Catalog2 cat = new Catalog2();
        CatalogIterator<Catalog<Product>> it = catalog.iterator();
        while (it.hasNext()) {
            Catalog<Product> cat2 = it.next();
            CatalogIterator<Product> it2 = cat2.iterator();
            cat.add(it2);
        }
        return cat.iterator();
    }
            
    private void close() {
        Files file = file.getFiles();
        file.zipClients(clients);
    }
    
    @Override
    public void registerObserver(Observer o) {
        clients.add((ClientInterface) o);
    }

    @Override
    public void removeObserver(Observer o) {
        clients.remove((ClientInterface) o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : clients) {
            o.update();
        }
    }

    public Coupon getCoupon() {
        return coupon;
    }  
    
}
