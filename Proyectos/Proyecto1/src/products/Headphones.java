package products;

public class Headphones extends Product {

    @Override
    public long getBarcode() {
        return 7501910210018L;
    }

    @Override
    public String getName() {
        return "Audifonos Razer";
    }

    @Override
    public Department getDepartment() {
        return Department.ELECTRONICS;
    }

    @Override
    public double getPrice() {
        return 1000.0;
    }

}
