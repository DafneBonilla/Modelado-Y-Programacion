package clients;

import java.util.List;

public class Coupon {

    private double porcentage;

    private List<Country> countries;

    public Coupon(double porcentage, List<Country> countries) {
        this.porcentage = porcentage;
        this.countries = countries;
    }

    public double getPorcentage() {
        return porcentage;
    }

    public List<Country> getCountries() {
        return countries;
    }

}
