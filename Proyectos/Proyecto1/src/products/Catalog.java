package products;

import java.io.Serializable;

public interface Catalog extends Serializable {

    public void add(Product item);

    public void remove(Product item);

    public CatalogIterator iterator();

    public String getName();

}
