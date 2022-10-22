package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;
import clients.*;
import products.*;

public class Files {

    private static Files file = new Files();

    private Files() {
    }

    public static Files getFiles() {
        return file;
    }

    public void generateClients() {
        List<ClientInterface> clients = new LinkedList<>();
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

    public void generateCatalog() {
        List<Product> catalog = new LinkedList<>();
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
