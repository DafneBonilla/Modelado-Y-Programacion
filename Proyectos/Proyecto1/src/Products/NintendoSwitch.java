package Products;

public class NintendoSwitch extends Product {

    @Override
    public long getBarcode() {
        return 7501910214010L;
    }

    @Override
    public String getName() {
        return "Consola Nintendo Switch";
    }

    @Override
    public Department getDepartment() {
        return Department.VIDEOGAMES;
    }

    @Override
    public double getPrice() {
        return 15000.0;
    }

}
