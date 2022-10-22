package stores;

public class SpanishSpain implements Language {

    private Store store;

    public SpanishSpain(Store store) {
        this.store = store;
    }

    @Override
    public Store getStore() {
        return store;
    }

    @Override
    public void setStore(Store store) {
        this.store = store;
    }

    @Override
    public String printX() {
        return "Hola";
    }

}
