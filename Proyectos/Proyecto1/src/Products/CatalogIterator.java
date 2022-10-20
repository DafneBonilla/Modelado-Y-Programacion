package products;

public interface CatalogIterator<T> {

    public boolean hasNext();

    public T next();

    public void remove();

    public void restart();

    public String getName();

}
