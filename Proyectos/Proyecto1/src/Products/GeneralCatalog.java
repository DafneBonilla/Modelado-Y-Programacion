package Products;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GeneralCatalog implements Catalog<ProductCatalog> {

    private List<ProductCatalog> list;

    private class GeneralCatalogIterator implements CatalogIterator<ProductCatalog> {

        private Iterator<ProductCatalog> iterator;

        private GeneralCatalogIterator() {
            iterator = list.iterator();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public ProductCatalog next() {
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
            return "Catalogo General";
        }

    }

    public GeneralCatalog() {
        this.list = new LinkedList<>();
    }

    @Override
    public void add(ProductCatalog item) {
        list.add(item);
    }

    @Override
    public void remove(ProductCatalog item) {
        list.remove(item);
    }

    @Override
    public CatalogIterator<ProductCatalog> Iterator() {
        return new GeneralCatalogIterator();
    }

    @Override
    public String getName() {
        return "Catalogo General";
    }

}
