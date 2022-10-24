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
     * Main method
     * 
     * @param args the arguments
     */
    public static void main(String[] args) {

        Files files = Files.getFiles();
        List<ClientInterface> clients = files.unzipClients();
        Catalog catalog = files.unzipCatalog();
        Walmart2 walmart = new Walmart2(clients, catalog);
        walmart.work();

    }

}
