package stores;

public class EnglishUsa implements Language {

    private Store store;

    public EnglishUsa(Store store) {
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
        return "Hello";
    }

}
