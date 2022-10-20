package Products;

public class CatLitter extends Product {

    @Override
    public long getBarcode() {
        return 7501910212012L;
    }

    @Override
    public String getName() {
        return "Arena para gato";
    }

    @Override
    public Department getDepartment() {
        return Department.PETS;
    }

    @Override
    public double getPrice() {
        return 75.0;
    }

}
