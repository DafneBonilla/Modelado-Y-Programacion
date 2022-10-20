package products;

public class Halo extends Product {

    @Override
    public long getBarcode() {
        return 7501910214003L;
    }

    @Override
    public String getName() {
        return "Videojuego Halo";
    }

    @Override
    public Department getDepartment() {
        return Department.VIDEOGAMES;
    }

    @Override
    public double getPrice() {
        return 1500.0;
    }

}
