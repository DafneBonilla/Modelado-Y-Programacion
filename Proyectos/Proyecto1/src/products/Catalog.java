package products;

import java.io.Serializable;

public interface Catalog<T> extends Serializable {

    public void add(T item);

    public void remove(T item);

    public CatalogIterator<T> iterator();

    public String getName();

}
