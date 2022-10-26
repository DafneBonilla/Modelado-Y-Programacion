package stores;

import clients.*;
import products.*;

/**
 * Abstract class to implement the Builder pattern
 * A store builder will build a store (instance of {@link Store})
 * A store builder has a iterator of products (instance of
 * {@link CatalogIterator}), a client (instance of {@link ClientInterface}), a
 * language (instance of {@link Language})
 */
public abstract class StoreBuilder {

    /* The iterator of products */
    protected CatalogIterator iter;

    /* The client */
    protected ClientInterface client;

    /* The language */
    protected Language lang;

    /**
     * Builds a store with the attributes of the builder
     * 
     * @return the store built
     */
    public abstract Store build();

    /**
     * Method to set the iterator of products
     * 
     * @param iter the iterator of products
     * @return the builder
     */
    public abstract StoreBuilder iterator(CatalogIterator iter);

    /**
     * Method to set the client and the language
     * 
     * @param client the client
     * @return the builder
     */
    public abstract StoreBuilder client(ClientInterface client);
}
