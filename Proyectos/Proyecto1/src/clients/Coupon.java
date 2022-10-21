package clients;

import java.util.List;

public class Coupon {

    private int porcentage;

    private List<Country> countries;

    public Coupon(int porcentage, List<Country> countries) {
        this.porcentage = porcentage;
        this.countries = countries;
    }

    public int getPorcentage() {
        return porcentage;
    }

    public List<Country> getCountries() {
        return countries;
    }

}
