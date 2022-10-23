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
    public String printShow() {
        return "This is the product catalog";
    }

    @Override
    public String printAskProd() {
        return "Enter the product number you want to buy";
    }

    @Override
    public String printInvalid() {
        return "Invalid input";
    }

    @Override
    public String printFinishBuy() {
        return "Finish buying";
    }

    @Override
    public String printBank() {
        return "Enter your accounts bank number";
    }

    @Override
    public String printClient() {
        return "Client";
    }

    @Override
    public String printDate() {
        return "Date";
    }

    @Override
    public String printProd() {
        return "Product";
    }

    @Override
    public String printDeliver() {
        return "Expected delivery date";
    }

}
