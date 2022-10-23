package products;

/**
 * Class to implement the iterator pattern
 * A catalog iterator is used to iterate over the products in a catalog.
 */
public interface CatalogIterator {

    public boolean hasNext();

    public Product next();

    public void remove();

    public void restart();

    public String getName();

}
