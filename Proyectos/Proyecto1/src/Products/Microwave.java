package products;

public class Microwave extends Product {

    @Override
    public long getBarcode() {
        return 7501910213018L;
    }

    @Override
    public String getName() {
        return "Microondas";
    }

    @Override
    public Department getDepartment() {
        return Department.HOMEAPPLIANCES;
    }

    @Override
    public double getPrice() {
        return 5300.0;
    }

}
