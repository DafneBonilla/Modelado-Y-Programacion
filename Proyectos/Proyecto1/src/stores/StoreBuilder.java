package stores;

import clients.*;
import products.*;

public class StoreBuilder {

    protected CatalogIterator iter;

    protected ClientInterface client;

    protected Language lang;

    public Store build() {
        return new Store(this);
    }

    public StoreBuilder iterator(CatalogIterator iter) {
        this.iter = iter;
        return this;
    }

    public StoreBuilder client(ClientInterface client) {
        this.client = client;
        switch (client.getNationality()) {
            case MEXICO:
                this.lang = new SpanishMexico(null);
                break;
            case SPAIN:
                this.lang = new SpanishSpain(null);
                break;
            case USA:
                this.lang = new EnglishUsa(null);
                break;
        }
        return this;
    }

}
