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
        // TODO: add clients to the list
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
     * Method to save a catalog in a file
     * The file will be named "catalogo.txt"
     * In case of error, the method will show a message to the user
     * 
     * @param catalog the catalog to save
     */
    public void zipCatalog(Catalog list) {
        try {
            FileOutputStream fos = new FileOutputStream("catalogo.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.flush();
            oos.close();
        } catch (Exception e) {
            System.out.println("Error al intentar guardar el archivo de catalogo");
            System.out.println("Los cambios no se guardaron");
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
