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

    /**
     * Method to get in a string the message "show the products in the catalog" in
     * the language
     * 
     * @return the message
     */
    @Override
    public String printShow() {
        return "This is the product catalog";
    }

    /**
     * Method to get in a string the message "choose a product" in the language
     * 
     * @return the message
     */
    @Override
    public String printAskProd() {
        return "Enter the product number you want to buy";
    }

    /**
     * Method to get in a string the message "invalid input" in the language
     * 
     * @return the message
     */
    @Override
    public String printInvalid() {
        return "Invalid input";
    }

    /**
     * Method to get in a string the message "finish buying" in the language
     * 
     * @return the message
     */
    @Override
    public String printFinishBuy() {
        return "Finish buying";
    }

    /**
     * Method to get in a string the message "enter the bank number of your account"
     * in the language
     * 
     * @return the message
     */
    @Override
    public String printBank() {
        return "Enter your accounts bank number";
    }

    /**
     * Method to get in a string the message "Ticket" in the language
     * 
     * @return the message
     */
    @Override
    public String printTicket() {
        return "Ticket";
    }

    /**
     * Method to get in a string the message "Client" in the language
     * 
     * @return the message
     */
    @Override
    public String printClient() {
        return "Client";
    }

    /**
     * Method to get in a string the message "Date" in the language
     * 
     * @return the message
     */
    @Override
    public String printDate() {
        return "Date";
    }

    /**
     * Method to get in a string the message "Products" in the language
     * 
     * @return the message
     */
    @Override
    public String printProd() {
        return "Product";
    }

    /**
     * Method to get in a string the message "prices have the discount applied" in
     * the language
     * 
     * @return the message
     */
    @Override
    public String printApply() {
        return "prices with discount applied";
    }

    /**
     * Method to get in a string the message "Delivery date" in the language
     * 
     * @return the message
     */
    @Override
    public String printDeliver() {
        return "Expected delivery date";
    }

    /**
     * Method to get in a string the message "Direction" in the language
     * 
     * @return the message
     */
    @Override
    public String printDirection() {
        return "Direction";
    }

    /**
     * Method to get in a string the message "good try but thats not correct,
     * aborting the purchase" in the language
     * 
     * @return the message
     */
    @Override
    public String printNotSecure() {
        return "Good try, but thats not correct, aborting the purchase";
    }

    /**
     * Method to get in a string the message "goodbye" in the
     * language
     * 
     * @return the message
     */
    @Override
    public String printBye() {
        return "Thanks for coming, goodbye";
    }

    /**
     * Method to get in a string the message "your account doesnt have money,
     * aborting the purchase" in the language
     * 
     * @return the message
     */
    @Override
    public String printNoMoney() {
        return "Your account doesnt have enough money, aborting the purchase";
    }

    /**
     * Method to get in a string the message "the purchase is secure" in the
     * language
     * 
     * @return the message
     */
    @Override
    public String printSecure() {
        return "The purchase is secure";
    }

    /**
     * Method to get in a string the menu of the store in the language
     * 
     * @return the message
     */
    @Override
    public String printMenu() {
        String answer = "";
        answer += "What do you want to do?\n";
        answer += "[0] Show the products in the catalog\n";
        answer += "[1] Start buying\n";
        answer += "[2] Exit\n";
        return answer;
    }

    /**
     * Method to get in a string the message "with a discount of" in the language
     * 
     * @return the message
     */
    @Override
    public String printPercent() {
        return "with a discount of ";
    }

    /**
     * Method to get in a string the message "you have a coupon in" in the language
     * 
     * @return the message
     */
    @Override
    public String printCoup() {
        return "You have a coupon in ";
    }

    /**
     * Method to get in a string the message "welcome to the store" in the language
     * 
     * @return the message
     */
    @Override
    public String printWelcome() {
        return "Welcome to Walmart2";
    }

    /**
     * Method to get in a string the message "successful purchase" in the language
     * 
     * @return the message
     */
    @Override
    public String printSuccess() {
        return "Successful purchase";
    }

    /**
     * Method to get in a string the message "Total" in the language
     * 
     * @return the message
     */
    @Override
    public String printTotal() {
        return "Total";
    }

    /**
     * Method to get in a string the message "your balance is" in the language
     * 
     * @return the message
     */
    @Override
    public String printMoney() {
        return "Your balance is";
    }

}
