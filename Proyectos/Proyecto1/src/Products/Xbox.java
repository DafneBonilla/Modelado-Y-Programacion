package Products;

public class Xbox extends Product {

    @Override
    public long getBarcode() {
        return 7501910214027L;
    }

    @Override
    public String getName() {
        return "Consola Xbox Series X";
    }

    @Override
    public Department getDepartment() {
        return Department.VIDEOGAMES;
    }

    @Override
    public double getPrice() {
        return 18000.0;
    }

}
