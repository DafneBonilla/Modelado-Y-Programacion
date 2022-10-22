package stores;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import products.*;
import utility.*;
import clients.*;

public class Store {

    private CatalogIterator iter;

    private ClientInterface client;

    private Language lang;

    private List<Product> cart;

    private Asker asker;

    public Store(StoreBuilder builder) {
        this.iter = builder.iter;
        this.client = builder.client;
        this.lang = builder.lang;
        lang.setStore(this);
        this.cart = new LinkedList<>();
        this.asker = Asker.getAsker();
    }

    public void work() {

    }

    private void showCatalog() {

    }

    private void buy() {

    }

    private void addElement() {

    }

    private boolean checkAccount() {
        return false;
    }

    private void generateTicket() {

    }

    // fuente: https://stackoverflow.com/a/40253413
    private String generateDate() {
        LocalDate startD = LocalDate.now();
        long start = startD.toEpochDay();
        LocalDate endD = LocalDate.of(2030, 12, 31);
        long end = endD.toEpochDay();
        long randomDate = ThreadLocalRandom.current().longs(start, end).findAny().getAsLong();
        return LocalDate.ofEpochDay(randomDate).toString();
    }

    private String printX() {
        return lang.printX();
    }

}
