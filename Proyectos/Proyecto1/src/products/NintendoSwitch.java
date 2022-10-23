package products;

/**
 * Class to represent the Nintendo Switch product
 */
public class NintendoSwitch extends Product {

    /**
     * Method to get the barcode of the product
     * 
     * @return the barcode of the product
     */
    @Override
    public long getBarcode() {
        return 7501910214010L;
    }

    /**
     * Method to get the name of the product
     * 
     * @return the name of the product
     */
    @Override
    public String getName() {
        return "Consola Nintendo Switch";
    }

    /**
     * Method to get the department of the product
     * 
     * @return the department of the product
     */
    @Override
    public Department getDepartment() {
        return Department.VIDEOGAMES;
    }

    /**
     * Method to get the price of the product
     * 
     * @return the price of the product
     */
    @Override
    public double getPrice() {
        return 15000.0;
    }

}
