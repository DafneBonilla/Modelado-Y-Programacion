package products;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Catalog2 implements Catalog<CatalogIterator<Product>> {

    private List<CatalogIterator<Product>> list;

    private class Catalog2Iterator implements CatalogIterator<CatalogIterator<Product>> {

        private Iterator<CatalogIterator<Product>> iterator;

        private Catalog2Iterator() {
            iterator = list.iterator();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public CatalogIterator<Product> next() {
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
            return "Catalog2";
        }
        
    }
    
    public Catalog2() {
        list = new LinkedList<>();
    }

    @Override
    public void add(CatalogIterator<Product> item) {
        list.add(item);
    }

    @Override
    public void remove(CatalogIterator<Product> item) {
        list.remove(item);
    }

    @Override
    public CatalogIterator<CatalogIterator<Product>> iterator() {
        return new Catalog2Iterator();
    }

    @Override
    public String getName() {
        return "Catalog2";
    }

}
