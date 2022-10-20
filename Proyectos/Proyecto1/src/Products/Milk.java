package products;

public class Milk extends Product {

    @Override
    public long getBarcode() {
        return 7501910211014L;
    }

    @Override
    public String getName() {
        return "Leche Lala";
    }

    @Override
    public Department getDepartment() {
        return Department.GROCERY;
    }

    @Override
    public double getPrice() {
        return 38.0;
    }

}
