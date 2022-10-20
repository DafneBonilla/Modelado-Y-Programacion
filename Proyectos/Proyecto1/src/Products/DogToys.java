package Products;

public class DogToys extends Product {

    @Override
    public long getBarcode() {
        return 7501910212039L;
    }

    @Override
    public String getName() {
        return "Juguete para perro";
    }

    @Override
    public Department getDepartment() {
        return Department.PETS;
    }

    @Override
    public double getPrice() {
        return 42.0;
    }

}
