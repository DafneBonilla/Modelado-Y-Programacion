package stores;

import clients.*;
import products.*;

/**
 * Class to represent a store builder default
 * A store builder default will build a store (instance of {@link Store})
 */
public class StoreBuilderDefault extends StoreBuilder {

    /**
     * Builds a store with the attributes of the builder
     * 
     * @return the store built
     */
    @Override
    public Store build() {
        return new Store(this);
    }

    /**
     * Method to set the iterator of products
     * 
     * @param iter the iterator of products
     * @return the builder
     */
    @Override
    public StoreBuilder iterator(CatalogIterator iter) {
        this.iter = iter;
        return this;
    }

    /**
     * Method to set the client and the language
     * 
     * @param client the client
     * @return the builder
     */
    @Override
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
