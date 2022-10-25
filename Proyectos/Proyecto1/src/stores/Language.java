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

    /**
     * Method to get in a string the message "show the products in the catalog" in
     * the language
     * 
     * @return the message
     */
    public String printShow();

    /**
     * Method to get in a string the message "choose a product" in the language
     * 
     * @return the message
     */
    public String printAskProd();

    /**
     * Method to get in a string the message "invalid input" in the language
     * 
     * @return the message
     */
    public String printInvalid();

    /**
     * Method to get in a string the message "finish buying" in the language
     * 
     * @return the message
     */
    public String printFinishBuy();

    /**
     * Method to get in a string the message "enter the bank number of your account"
     * in the language
     * 
     * @return the message
     */
    public String printBank();

    /**
     * Method to get in a string the message "Ticket" in the language
     * 
     * @return the message
     */
    public String printTicket();

    /**
     * Method to get in a string the message "Client" in the language
     * 
     * @return the message
     */
    public String printClient();

    /**
     * Method to get in a string the message "Date" in the language
     * 
     * @return the message
     */
    public String printDate();

    /**
     * Method to get in a string the message "Products" in the language
     * 
     * @return the message
     */
    public String printProd();

    /**
     * Method to get in a string the message "prices have the discount applied" in
     * the language
     * 
     * @return the message
     */
    public String printApply();

    /**
     * Method to get in a string the message "Delivery date" in the language
     * 
     * @return the message
     */
    public String printDeliver();

}
