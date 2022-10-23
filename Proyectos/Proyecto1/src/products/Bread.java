package products;

/**
 * Class to represent the bread product
 */
public class Bread extends Product {

    /**
     * Method to get the barcode of the product
     * 
     * @return the barcode of the product
     */
    @Override
    public long getBarcode() {
        return 7501910211021L;
    }

    /**
     * Method to get the name of the product
     * 
     * @return the name of the product
     */
    @Override
    public String getName() {
        return "Pan Bimbo";
    }

    /**
     * Method to get the department of the product
     * 
     * @return the department of the product
     */
    @Override
    public Department getDepartment() {
        return Department.GROCERY;
    }

    /**
     * Method to get the price of the product
     * 
     * @return the price of the product
     */
    @Override
    public double getPrice() {
        return 25.0;
    }

}
