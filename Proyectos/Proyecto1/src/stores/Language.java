package stores;

/**
 * Interface to implement the Strategy pattern
 * A language will help the store to communicate with the client in the clients
 * language
 */
public interface Language {

    /**
     * Method to get the store of the language
     * 
     * @return the store
     */
    public Store getStore();

    /**
     * Method to set the store of the language
     * 
     * @param store the store
     */
    public void setStore(Store store);

    public String printShow();

    public String printAskProd();

    public String printInvalid();

    public String printFinishBuy();

    public String printBank();

    public String printClient();

    public String printDate();

    public String printProd();

    public String printDeliver();

}
