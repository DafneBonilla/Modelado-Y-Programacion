package Products;

public class Computer extends Product {

    @Override
    public long getBarcode() {
        return 7501910210009L;
    }

    @Override
    public String getName() {
        return "Computadora de Canek";
    }

    @Override
    public Department getDepartment() {
        return Department.ELECTRONICS;
    }

    @Override
    public double getPrice() {
        return 100000.0;
    }

}
