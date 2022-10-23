package products;

import java.io.Serializable;

/**
 * Class to represent a catalog of products (instances of {@link Product})
 * It can be serialized to a file.
 */
public interface Catalog extends Serializable {

    /**
     * Method to add a product to the catalog
     * 
     * @param item the product to add
     */
    public void add(Product item);

    /**
     * Method to remove a product from the catalog
     * 
     * @param item the product to remove
     */
    public void remove(Product item);

    /**
     * Method to get an iterator to iterate over the products in the catalog
     * 
     * @return an iterator of the products in the catalog
     */
    public CatalogIterator iterator();

    /**
     * Method to get the name of the catalog
     * 
     * @return the name of the catalog
     */
    public String getName();

}
