package stores;

public class SpanishMexico implements Language {

    private Store store;

    public SpanishMexico(Store store) {
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
