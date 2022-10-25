package stores;

/**
 * Class to represent the spanish Spain language
 * A spanish Spain language has a store (instance of {@link Store})
 */
public class SpanishSpain implements Language {

    /* The store */
    private Store store;

    /**
     * Constructor
     * 
     * @param store the store
     */
    public SpanishSpain(Store store) {
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
        return "Este es el fliplante catalogo de productos";
    }

    /**
     * Method to get in a string the message "choose a product" in the language
     * 
     * @return the message
     */
    @Override
    public String printAskProd() {
        return "Ingrese el numero del articulo que desea comprar";
    }

    /**
     * Method to get in a string the message "invalid input" in the language
     * 
     * @return the message
     */
    @Override
    public String printInvalid() {
        return "Entrada incorrecta";
    }

    /**
     * Method to get in a string the message "finish buying" in the language
     * 
     * @return the message
     */
    @Override
    public String printFinishBuy() {
        return "Finalizar de comprar";
    }

    /**
     * Method to get in a string the message "enter the bank number of your account"
     * in the language
     * 
     * @return the message
     */
    @Override
    public String printBank() {
        return "Ingrese el numero de su cuenta bancaria relacionada a su cuenta";
    }

    /**
     * Method to get in a string the message "Ticket" in the language
     * 
     * @return the message
     */
    @Override
    public String printTicket() {
        return "Comprobante de compra";
    }

    /**
     * Method to get in a string the message "Client" in the language
     * 
     * @return the message
     */
    @Override
    public String printClient() {
        return "Comprador";
    }

    /**
     * Method to get in a string the message "Date" in the language
     * 
     * @return the message
     */
    @Override
    public String printDate() {
        return "Tiempo";
    }

    /**
     * Method to get in a string the message "Products" in the language
     * 
     * @return the message
     */
    @Override
    public String printProd() {
        return "Articulos";
    }

    /**
     * Method to get in a string the message "prices have the discount applied" in
     * the language
     * 
     * @return the message
     */
    @Override
    public String printApply() {
        return "precios con el fliplante descuento ya aplicado";
    }

    /**
     * Method to get in a string the message "Delivery date" in the language
     * 
     * @return the message
     */
    @Override
    public String printDeliver() {
        return "Fecha esperada de entrega";
    }

}
