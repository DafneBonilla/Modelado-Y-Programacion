package Products;

public class DogFood extends Product {

    @Override
    public long getBarcode() {
        return 7501910212005L;
    }

    @Override
    public String getName() {
        return "Alimento para perro";
    }

    @Override
    public Department getDepartment() {
        return Department.PETS;
    }

    @Override
    public double getPrice() {
        return 100.0;
    }

}
