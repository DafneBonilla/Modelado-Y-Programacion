package walmart;

import java.util.List;
import stores.*;
import clients.*;
import products.*;

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
    
    private void randomCoupon() {
        
    }   
    
    private void giveCoupons() {
        
    }

    public void work() {
        
    }

    private ClientInterface verify() {
        return null;
    }

    private Store store (ClientInterface client) {
        return null;
    }

    private void close() {

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
