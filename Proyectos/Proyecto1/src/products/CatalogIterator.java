package products;

public interface CatalogIterator {

    public boolean hasNext();

    public Product next();

    public void remove();

    public void restart();

    public String getName();

}
