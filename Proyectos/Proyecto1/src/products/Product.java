package products;

import java.io.Serializable;

/**
 * Class to represent a product
 * A product must return a barcode, a name, a department and a price
 */
public abstract class Product implements Serializable {

    /**
     * Method to get the barcode of the product
     * 
     * @return the barcode of the product
     */
    public abstract long getBarcode();

    /**
     * Method to get the name of the product
     * 
     * @return the name of the product
     */
    public abstract String getName();

    /**
     * Method to get the department of the product
     * 
     * @return the department of the product
     */
    public abstract Department getDepartment();

    /**
     * Method to get the price of the product
     * 
     * @return the price of the product
     */
    public abstract double getPrice();

    /**
     * Method to return the product as a string
     * 
     * @return the product as a string
     */
    @Override
    public String toString() {
        return "Nombre: " + getName() + " | Codigo de Barras: " + getBarcode() + " | Precio: $" + getPrice()
                + " | Departamento: " + getDepartment();
    }

    /**
     * Method to return the product as a string but with a discount in the price
     * 
     * @param por the percentage of the discount
     * @return the product as a string with a discount in the price
     */
    public String toString(int por) {
        return "Nombre: " + getName() + " | Codigo de Barras: " + getBarcode() + " | Precio: $"
                + (getPrice() * (1 - por / 100.0)) + " | Departamento: " + getDepartment();
    }

}