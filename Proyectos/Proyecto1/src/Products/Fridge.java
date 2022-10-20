package Products;

public class Fridge extends Product {

    @Override
    public long getBarcode() {
        return 7501910213001L;
    }

    @Override
    public String getName() {
        return "Refrigerador";
    }

    @Override
    public Department getDepartment() {
        return Department.HOMEAPPLIANCES;
    }

    @Override
    public double getPrice() {
        return 10000.0;
    }

}
