package stores;

/**
 * Class to represent the english USA language
 * A english USA language has a store (instance of {@link Store})
 */
public class EnglishUsa implements Language {

    /* The store */
    private Store store;

    /**
     * Constructor
     * 
     * @param store the store
     */
    public EnglishUsa(Store store) {
        this.store = store;
    }

    /**
     * Method to get the store of the language
     * 
     * @return the store
     */
    @Override
    public Store getStore() {
        return store;
    }

    /**
     * Method to set the store of the language
     * 
     * @param store the store
     */
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
