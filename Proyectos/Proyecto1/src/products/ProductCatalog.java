package products;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductCatalog implements Catalog {

    private List<Product> list;

    private class ProductCatalogIterator implements CatalogIterator {

        private Iterator<Product> iterator;

        private ProductCatalogIterator() {
            iterator = list.iterator();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public Product next() {
            return iterator.next();
        }

        @Override
        public void remove() {
            iterator.remove();
        }

        @Override
        public void restart() {
            iterator = list.iterator();
        }

        @Override
        public String getName() {
            return "Catalogo";
        }

    }

    public ProductCatalog() {
        this.list = new LinkedList<>();
    }

    @Override
    public void add(Product item) {
        list.add(item);
    }

    @Override
    public void remove(Product item) {
        list.remove(item);
    }

    @Override
    public CatalogIterator iterator() {
        return new ProductCatalogIterator();
    }

    @Override
    public String getName() {
        return "Catalogo";
    }

}
