package stores;

import clients.*;
import products.*;

public class StoreBuilder {

    protected CatalogIterator<CatalogIterator<Product>> iter;

    protected ClientInterface client;

    protected Language lang;

    public Store build() {
        return null;
    }

    public StoreBuilder iterator(CatalogIterator<CatalogIterator<Product>> iter) {
        return this;
    }

    public StoreBuilder client(ClientInterface client) {
        return this;
    }

}
