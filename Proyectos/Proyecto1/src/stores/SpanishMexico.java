package stores;

/**
 * Class to represent the spanish Mexico language
 * A spanish Mexico language has a store (instance of {@link Store})
 */
public class SpanishMexico implements Language {

    /* The store */
    private Store store;

    /**
     * Constructor
     * 
     * @param store the store
     */
    public SpanishMexico(Store store) {
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
        return "Este es el catalogo de productos";
    }

    /**
     * Method to get in a string the message "choose a product" in the language
     * 
     * @return the message
     */
    @Override
    public String printAskProd() {
        return "Ingresa el numero del producto que quieres comprar";
    }

    /**
     * Method to get in a string the message "invalid input" in the language
     * 
     * @return the message
     */
    @Override
    public String printInvalid() {
        return "Entrada invalida";
    }

    /**
     * Method to get in a string the message "finish the buy" in the language
     * 
     * @return the message
     */
    @Override
    public String printFinishBuy() {
        return "Terminar de comprar";
    }

    /**
     * Method to get in a string the message "enter the bank number of your account"
     * in the language
     * 
     * @return the message
     */
    @Override
    public String printBank() {
        return "Ingresa el numero de tu cuenta bancaria de tu cuenta";
    }

    /**
     * Method to get in a string the message "Ticket" in the language
     * 
     * @return the message
     */
    @Override
    public String printTicket() {
        return "Recibo";
    }

    /**
     * Method to get in a string the message "Client" in the language
     * 
     * @return the message
     */
    @Override
    public String printClient() {
        return "Cliente";
    }

    /**
     * Method to get in a string the message "Date" in the language
     * 
     * @return the message
     */
    @Override
    public String printDate() {
        return "Fecha";
    }

    /**
     * Method to get in a string the message "Products" in the language
     * 
     * @return the message
     */
    @Override
    public String printProd() {
        return "Producto";
    }

    /**
     * Method to get in a string the message "prices have the discount applied" in
     * the language
     * 
     * @return the message
     */
    @Override
    public String printApply() {
        return "precios con el descuento aplicado";
    }

    /**
     * Method to get in a string the message "Delivery date" in the language
     * 
     * @return the message
     */
    @Override
    public String printDeliver() {
        return "Fecha estimada de entrega";
    }

}
