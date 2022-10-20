package products;

public class AirFryer extends Product {

    @Override
    public long getBarcode() {
        return 7501910213025L;
    }

    @Override
    public String getName() {
        return "Freidora de aire";
    }

    @Override
    public Department getDepartment() {
        return Department.HOMEAPPLIANCES;
    }

    @Override
    public double getPrice() {
        return 6000.0;
    }

}
