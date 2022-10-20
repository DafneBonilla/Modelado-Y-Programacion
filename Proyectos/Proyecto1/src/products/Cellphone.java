package products;

public class Cellphone extends Product {

    @Override
    public long getBarcode() {
        return 7501910210025L;
    }

    @Override
    public String getName() {
        return "Celular Samsung";
    }

    @Override
    public Department getDepartment() {
        return Department.ELECTRONICS;
    }

    @Override
    public double getPrice() {
        return 12000.0;
    }

}
