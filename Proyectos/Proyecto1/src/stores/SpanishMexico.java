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
        return "Poned el numero del producto que quieres comprar";
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
        return "Poned el numero de tu cuenta bancaria de tu cuenta";
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
        return "Precios con el descuento aplicado";
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

    /**
     * Method to get in a string the message "Direction" in the language
     * 
     * @return the message
     */
    @Override
    public String printDirection() {
        return "Direccion";
    }

    /**
     * Method to get in a string the message "good try but thats not correct,
     * aborting the purchase" in the language
     * 
     * @return the message
     */
    @Override
    public String printNotSecure() {
        return "Buen intento, pero eso no es correcto, abortando la compra";
    }

    /**
     * Method to get in a string the message "goodbye" in the
     * language
     * 
     * @return the message
     */
    @Override
    public String printBye() {
        return "Gracias por su visita";
    }

    /**
     * Method to get in a string the message "your account doesnt have money,
     * aborting the purchase" in the language
     * 
     * @return the message
     */
    @Override
    public String printNoMoney() {
        return "Tu cuenta no tiene dinero suficiente, abortando la compra. Hoy no se fia, maniana si.";
    }

    /**
     * Method to get in a string the message "the purchase is secure" in the
     * language
     * 
     * @return the message
     */
    @Override
    public String printSecure() {
        return "La compra es segura";
    }

    /**
     * Method to get in a string the menu of the store in the language
     * 
     * @return the message
     */
    @Override
    public String printMenu() {
        String answer = "";
        answer += "¿Que quieres hacer?\n";
        answer += "[0] Mostrar los productos del catalogo\n";
        answer += "[1] Empezar a comprar\n";
        answer += "[2] Salir\n";
        return answer;
    }

    /**
     * Method to get in a string the message "with a discount of" in the language
     * 
     * @return the message
     */
    @Override
    public String printPercent() {
        return "con un descuento del ";
    }

    /**
     * Method to get in a string the message "you have a coupon in" in the language
     * 
     * @return the message
     */
    @Override
    public String printCoup() {
        return "Tienes un cupon en ";
    }

    /**
     * Method to get in a string the message "welcome to the store" in the language
     * 
     * @return the message
     */
    @Override
    public String printWelcome() {
        return "Bienvenido a Walmart2";
    }

    /**
     * Method to get in a string the message "successful purchase" in the language
     * 
     * @return the message
     */
    @Override
    public String printSuccess() {
        return "Compra exitosa";
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
        return "Tu saldo es";
    }

}
