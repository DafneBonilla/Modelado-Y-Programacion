public class Practica3 {

    public static void main(String[] args) {

        try {
            Cashier cashier = new Cashier();
            System.out.println("Bienvenido a WaySub");
            cashier.askOrder();
            System.out.print("Cocinando");
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.print(".\n");
            System.out.println("Su orden esta lista");
            System.out.println("Aqui esta su ticket\n");
            cashier.printTicket();
        } catch (InterruptedException ie) {
            System.out.println("Algo salio mal con el hilo");
        }
    }
}
