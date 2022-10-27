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

    /**
     * Method to get in a string the message "Direction" in the language
     * 
     * @return the message
     */
    public String printDirection();

    /**
     * Method to get in a string the message "good try but thats not correct,
     * aborting the purchase" in the language
     * 
     * @return the message
     */
    public String printNotSecure();

    /**
     * Method to get in a string the message "goodbye" in the
     * language
     * 
     * @return the message
     */
    public String printBye();

    /**
     * Method to get in a string the message "your account doesnt have money,
     * aborting the purchase" in the language
     * 
     * @return the message
     */
    public String printNoMoney();

    /**
     * Method to get in a string the message "the purchase is secure" in the
     * language
     * 
     * @return the message
     */
    public String printSecure();

    /**
     * Method to get in a string the menu of the store in the language
     * 
     * @return the message
     */
    public String printMenu();

    /**
     * Method to get in a string the message "with a discount of" in the language
     * 
     * @return the message
     */
    public String printPercent();

    /**
     * Method to get in a string the message "you have a coupon in" in the language
     * 
     * @return the message
     */
    public String printCoup();

    /**
     * Method to get in a string the message "welcome to the store" in the language
     * 
     * @return the message
     */
    public String printWelcome();

    /**
     * Method to get in a string the message "successful purchase" in the language
     * 
     * @return the message
     */
    public String printSuccess();

    /**
     * Method to get in a string the message "Total" in the language
     * 
     * @return the message
     */
    public String printTotal();

    /**
     * Method to get in a string the message "your balance is" in the language
     * 
     * @return the message
     */
    public String printMoney();

}
