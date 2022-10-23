package stores;

public class SpanishSpain implements Language {

    private Store store;

    public SpanishSpain(Store store) {
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
        return "Este es el fliplante catalogo de productos";
    }

    @Override
    public String printAskProd() {
        return "Ingrese el numero del articulo que desea comprar";
    }

    @Override
    public String printInvalid() {
        return "Entrada incorrecta";
    }

    @Override
    public String printFinishBuy() {
        return "Finalizar de comprar";
    }

    @Override
    public String printBank() {
        return "Ingrese el numero de su cuenta bancaria relacionada a su cuenta";
    }

    @Override
    public String printClient() {
        return "Comprador";
    }

    @Override
    public String printDate() {
        return "Tiempo";
    }

    @Override
    public String printProd() {
        return "Articulos";
    }

    @Override
    public String printDeliver() {
        return "Fecha esperada de entrega";
    }

}
