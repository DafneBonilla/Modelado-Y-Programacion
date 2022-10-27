import java.util.List;
import clients.*;
import products.*;
import utility.*;
import walmart.*;

/**
 * Class to make the proyect 1 work
 */
public class Proyecto1 {

    /**
     * How to use the program
     */
    public static void use() {
        System.out.println("Uso: java Proyecto1 <option>");
        System.out.println("Opciones:");
        System.out.println("0: Uso normal");
        System.out.println("1: Generar archivo de clientes");
        System.out.println("2: Generar archivo de productos");
        System.exit(0);
    }

    /**
     * Main method
     * 
     * @param args the arguments
     */
    public static void main(String[] args) {

        if (args.length != 1) {
            use();
        }
        Files files = Files.getFiles();
        try {
            int option = Integer.parseInt(args[0]);
            switch (option) {
                case 0:
                    List<ClientInterface> clients = files.unzipClients();
                    if (clients == null) {
                        System.out.println("Genera los archivos de clientes con java Proyecto1 1");
                        System.exit(0);
                    }
                    Catalog catalog = files.unzipCatalog();
                    if (catalog == null) {
                        System.out.println("Genera los archivos de productos con java Proyecto1 2");
                        System.exit(0);
                    }
                    Walmart2 walmart = new Walmart2(clients, catalog);
                    walmart.work();
                    break;
                case 1:
                    files.generateClients();
                    System.out.println("Archivo de clientes generado :)");
                    break;
                case 2:
                    files.generateCatalog();
                    System.out.println("Archivo de productos generado :)");
                    break;
                default:
                    use();
            }
        } catch (NumberFormatException e) {
            use();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Si lees esto, algo salio mal :(");
        }

    }

}
