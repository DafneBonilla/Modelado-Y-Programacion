package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;
import clients.*;
import products.*;

/**
 * Class to manage the reading and writing of files
 * It is a singleton class
 */
public class Files {

    /* Singleton instance */
    private static Files file = new Files();

    /**
     * Private constructor
     */
    private Files() {
    }

    /**
     * Method to get the singleton instance
     * 
     * @return the singleton instance
     */
    public static Files getFiles() {
        return file;
    }

    /**
     * Method to generate a file with a list of clients in it
     * The file will be named "clientes.txt"
     * In case of error, the method will show a message to the user and the program
     * will end
     */
    public void generateClients() {
        List<ClientInterface> clients = new LinkedList<>();
        ClientBuilder clientBuilder = new ClientBuilderDefault();
        clientBuilder = clientBuilder.username("Cheems").password("ContraseniaSegura99").nationality(Country.MEXICO)
                .name("Cheems Oaxaquenio").phone(5569359016L).address("San Francisco Tutla, Oaxaca")
                .bankNumber(98643790L).money(757400.23);
        clients.add(clientBuilder.build());
        clientBuilder = clientBuilder.username("Canek").password("KimPossible").nationality(Country.MEXICO)
                .name("Canek Pelaez").phone(5556223899L)
                .address("Av. Independencia 96, San Simon, Benito Juarez, Ciudad de Mexico").bankNumber(4567894256L)
                .money(1000000.99);
        clients.add(clientBuilder.build());
        clientBuilder = clientBuilder.username("Maximo").password("Ronroneos21").nationality(Country.USA)
                .name("Maximo Decimo Meridio").phone(8309319176L).address("148 East 126th Street New York")
                .bankNumber(81029973L).money(90375.23);
        clients.add(clientBuilder.build());
        clientBuilder = clientBuilder.username("Fernando").password("Pg9tBP95").nationality(Country.USA)
                .name("Fernando Lopez").phone(4232677284L).address("800 Florida Ave, NE Washington DC")
                .bankNumber(456787820L).money(667539.59);
        clients.add(clientBuilder.build());
        clientBuilder = clientBuilder.username("Itzel").password("33jG5gM").nationality(Country.SPAIN)
                .name("Itzel Azucena").phone(3464296089L).address("C. de Ausias March, 31-19, Barcelona")
                .bankNumber(9486024L).money(5680135);
        clients.add(clientBuilder.build());
        clientBuilder = clientBuilder.username("Arturo").password("kCFtV327bzJ").nationality(Country.SPAIN)
                .name("Arturo Lemus").phone(3479325785L).address("Ciudad Universitaria de Cantoblanco, Madrid")
                .bankNumber(34670135L).money(25.01);
        clients.add(clientBuilder.build());
        try {
            FileOutputStream fos = new FileOutputStream("clientes.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(clients);
            oos.flush();
            oos.close();
        } catch (Exception e) {
            System.out.println("Error al intentar generar el archivo de clientes");
            System.exit(0);
        }

    }

    /**
     * Method to generate a file with a catalog in it
     * The file will be named "catalogo.txt"
     * In case of error, the method will show a message to the user and the program
     * will end
     */
    public void generateCatalog() {
        Catalog catalog = new ProductCatalog();
        catalog.add(new Computer());
        catalog.add(new Headphones());
        catalog.add(new Cellphone());
        catalog.add(new Cheese());
        catalog.add(new Milk());
        catalog.add(new Bread());
        catalog.add(new DogFood());
        catalog.add(new CatLitter());
        catalog.add(new DogToys());
        catalog.add(new Fridge());
        catalog.add(new Microwave());
        catalog.add(new AirFryer());
        catalog.add(new Halo());
        catalog.add(new NintendoSwitch());
        catalog.add(new Xbox());
        try {
            FileOutputStream fos = new FileOutputStream("catalogo.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(catalog);
            oos.flush();
            oos.close();
        } catch (Exception e) {
            System.out.println("Error al intentar generar el archivo de catalogo");
            System.exit(0);
        }
    }

    /**
     * Method to save a list of clients in a file
     * The file will be named "clientes.txt"
     * In case of error, the method will show a message to the user
     * 
     * @param list the list of clients to save
     */
    public void zipClients(List<ClientInterface> list) {
        try {
            FileOutputStream fos = new FileOutputStream("clientes.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.flush();
            oos.close();
        } catch (Exception e) {
            System.out.println("Error al intentar guardar el archivo de clientes");
            System.out.println("Los cambios no se guardaron");
        }
    }

    /**
     * Method to read and return a list of clients from a file
     * The file to read will be named "clientes.txt"
     * In case of error, the method will show a message to the user and null will be
     * returned
     * 
     * @return the list of clients read from the file
     */
    public List<ClientInterface> unzipClients() {
        try {
            FileInputStream fis = new FileInputStream("clientes.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            @SuppressWarnings("unchecked")
            List<ClientInterface> list = (List<ClientInterface>) ois.readObject();
            ois.close();
            return list;
        } catch (Exception e) {
            System.out.println("Error al intentar leer el archivo de clientes");
            return null;
        }
    }

    /**
     * Method to read and return a catalog from a file
     * The file to read will be named "catalogo.txt"
     * In case of error, the method will show a message to the user and null will be
     * returned
     * 
     * @return the catalog read from the file
     */
    public Catalog unzipCatalog() {
        try {
            FileInputStream fis = new FileInputStream("catalogo.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            @SuppressWarnings("unchecked")
            Catalog catalog = (Catalog) ois.readObject();
            ois.close();
            return catalog;
        } catch (Exception e) {
            System.out.println("Error al intentar leer el archivo de catalogo");
            return null;
        }
    }

}
