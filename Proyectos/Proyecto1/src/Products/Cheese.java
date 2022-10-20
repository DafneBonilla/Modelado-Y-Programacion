package Products;

public class Cheese extends Product {

    @Override
    public long getBarcode() {
        return 7501910211003L;
    }

    @Override
    public String getName() {
        return "Queso Oaxaca";
    }

    @Override
    public Department getDepartment() {
        return Department.GROCERY;
    }

    @Override
    public double getPrice() {
        return 200.0;
    }

}
