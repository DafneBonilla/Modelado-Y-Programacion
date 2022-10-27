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
        return "Este es el fliplante catalogo de articulos";
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
        return "Precios con el fliplante descuento ya aplicado";
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

    /**
     * Method to get in a string the message "Direction" in the language
     * 
     * @return the message
     */
    @Override
    public String printDirection() {
        return "Destino";
    }

    /**
     * Method to get in a string the message "good try but thats not correct,
     * aborting the purchase" in the language
     * 
     * @return the message
     */
    @Override
    public String printNotSecure() {
        return "Buen intento, pero no lo cuela, interrumpiendo la adquisicion";
    }

    /**
     * Method to get in a string the message "goodbye" in the
     * language
     * 
     * @return the message
     */
    @Override
    public String printBye() {
        return "Muchas gracias por su visita, vuelva pronto";
    }

    /**
     * Method to get in a string the message "your account doesnt have money,
     * aborting the purchase" in the language
     * 
     * @return the message
     */
    @Override
    public String printNoMoney() {
        return "No tienes los suficientes pavos en tu cuenta, interrumpiendo la adquisicion";
    }

    /**
     * Method to get in a string the message "the purchase is secure" in the
     * language
     * 
     * @return the message
     */
    @Override
    public String printSecure() {
        return "La adquisicion es fiable";
    }

    /**
     * Method to get in a string the menu of the store in the language
     * 
     * @return the message
     */
    @Override
    public String printMenu() {
        String answer = "";
        answer += "¿Que desias realizar?\n";
        answer += "[0] Exhibir los articulos del catalogo\n";
        answer += "[1] Comenzar a adquirir\n";
        answer += "[2] Irse\n";
        return answer;
    }

    /**
     * Method to get in a string the message "with a discount of" in the language
     * 
     * @return the message
     */
    @Override
    public String printPercent() {
        return "con un flipante descuento del ";
    }

    /**
     * Method to get in a string the message "you have a coupon in" in the language
     * 
     * @return the message
     */
    @Override
    public String printCoup() {
        return "Voz teneis un cupon en ";
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
        return "Enhorabuena, adquisicion realizada con exito";
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
        return "Vuestro saldo es";
    }

}
