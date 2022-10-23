package stores;

public class SpanishMexico implements Language {

    private Store store;

    public SpanishMexico(Store store) {
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
        return "Este es el catalogo de productos";
    }

    @Override
    public String printAskProd() {
        return "Ingresa el numero del producto que quieres comprar";
    }

    @Override
    public String printInvalid() {
        return "Entrada invalida";
    }

    @Override
    public String printFinishBuy() {
        return "Terminar de comprar";
    }

    @Override
    public String printBank() {
        return "Ingresa el numero de tu cuenta bancaria de tu cuenta";
    }

    @Override
    public String printClient() {
        return "Cliente";
    }

    @Override
    public String printDate() {
        return "Fecha";
    }

    @Override
    public String printProd() {
        return "Producto";
    }

    @Override
    public String printDeliver() {
        return "Fecha estimada de entrega";
    }

}
