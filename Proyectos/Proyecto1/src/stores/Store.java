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

    private int total;

    public Store(StoreBuilder builder) {
        this.iter = builder.iter;
        this.client = builder.client;
        this.lang = builder.lang;
        lang.setStore(this);
        this.cart = new LinkedList<>();
        this.asker = Asker.getAsker();
        total();
    }

    private void total() {
        total = 0;
        while (iter.hasNext()) {
            iter.next();
            total++;
        }
    }

    public void work() {

    }

    private void showCatalog() {
        System.out.println(printShow());
        int i = 0;
        iter.restart();
        while (iter.hasNext()) {
            Product product = iter.next();
            System.out.println("[" + i + "]" + product);
        }
    }

    private void buy() {
        boolean working = true;
        while (working) {
            showCatalog();
            System.out.println("[" + total + "]" + printFinishBuy());
            working = addElement();
        }
    }

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

    private boolean checkAccount() {
        long ac = asker.askLong(printBank(), 0L, Long.MAX_VALUE, printInvalid());
        long acoriginal = client.getBankNumber();
        return ac == acoriginal;
    }

    private double money() {
        return 0;
    }

    private void generateTicket() {
        String ticket = "";
        ticket += "Ticket " + ThreadLocalRandom.current().nextInt(0, 1000) + "\n";
        ticket += printClient() + ": " + client.getName() + "\t id;" + client.getId() + "\n";
        ticket += printDate() + ":" + LocalDate.now().toString() + "\n";
        ticket += printProd() + ":\n";
        for (Product product : cart) {
            ticket += product.toString() + "\n";
        }
        ticket += "Total: " + money() + "\n";
        ticket += printDeliver() + ":" + generateDate() + "\n";
        System.out.println(ticket);
    }

    // fuente: https://stackoverflow.com/a/40253413
    private String generateDate() {
        LocalDate startD = LocalDate.now();
        long start = startD.toEpochDay();
        LocalDate endD = LocalDate.of(2023, 12, 31);
        long end = endD.toEpochDay();
        long randomDate = ThreadLocalRandom.current().longs(start, end).findAny().getAsLong();
        return LocalDate.ofEpochDay(randomDate).toString();
    }

    private String printShow() {
        return lang.printShow();
    }

    private String printAskProd() {
        return lang.printAskProd();
    }

    private String printInvalid() {
        return lang.printInvalid();
    }

    private String printFinishBuy() {
        return lang.printFinishBuy();
    }

    private String printBank() {
        return lang.printBank();
    }

    private String printClient() {
        return lang.printClient();
    }

    private String printDate() {
        return lang.printDate();
    }

    private String printProd() {
        return lang.printProd();
    }

    private String printDeliver() {
        return lang.printDeliver();
    }

}
