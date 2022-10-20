package Products;

public class Bread extends Product {

    @Override
    public long getBarcode() {
        return 7501910211021L;
    }

    @Override
    public String getName() {
        return "Pan Bimbo";
    }

    @Override
    public Department getDepartment() {
        return Department.GROCERY;
    }

    @Override
    public double getPrice() {
        return 25.0;
    }

}
