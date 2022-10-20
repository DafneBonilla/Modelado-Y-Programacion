package products;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductCatalog implements Catalog<Product> {

    private List<Product> list;

    private Department department;

    private class ProductCatalogIterator implements CatalogIterator<Product> {

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
            return department.toString();
        }

    }

    public ProductCatalog(Department department) {
        this.list = new LinkedList<>();
        this.department = department;
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
    public CatalogIterator<Product> Iterator() {
        return new ProductCatalogIterator();
    }

    @Override
    public String getName() {
        return department.toString();
    }

}
