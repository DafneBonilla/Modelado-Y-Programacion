package products;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Class to represent a prodcut catalog
 * A product catalog is a list of products
 * It has a private class product catalog iterator to iterate over the products
 */
public class ProductCatalog implements Catalog {

    /* List of products */
    private List<Product> list;

    /**
     * Private class to represent a product catalog iterator
     * A product catalog iterator has a iterator of the list of product
     */
    private class ProductCatalogIterator implements CatalogIterator {

        /* Iterator of the list of products */
        private Iterator<Product> iterator;

        /**
         * Constructor
         */
        private ProductCatalogIterator() {
            iterator = list.iterator();
        }

        /**
         * Method to check if there is a next product
         * 
         * @return true if there is a next product, false otherwise
         */
        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        /**
         * Method to get the next product
         * 
         * @return the next product
         */
        @Override
        public Product next() {
            return iterator.next();
        }

        /**
         * Method to remove the current product
         */
        @Override
        public void remove() {
            iterator.remove();
        }

        /**
         * Method to restart the iterator
         */
        @Override
        public void restart() {
            iterator = list.iterator();
        }

        /**
         * Method to get the name of the catalog
         * 
         * @return the name of the catalog
         */
        @Override
        public String getName() {
            return "Catalogo";
        }

    }

    /**
     * Constructor
     */
    public ProductCatalog() {
        this.list = new LinkedList<>();
    }

    /**
     * Method to add a product to the catalog
     * 
     * @param item the product to add
     */
    @Override
    public void add(Product item) {
        list.add(item);
    }

    /**
     * Method to remove a product from the catalog
     * 
     * @param item the product to remove
     */
    @Override
    public void remove(Product item) {
        list.remove(item);
    }

    /**
     * Method to get an iterator to iterate over the products in the catalog
     * 
     * @return an iterator of the products in the catalog
     */
    @Override
    public CatalogIterator iterator() {
        return new ProductCatalogIterator();
    }

    /**
     * Method to get the name of the catalog
     * 
     * @return the name of the catalog
     */
    @Override
    public String getName() {
        return "Catalogo";
    }

}
