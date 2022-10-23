package clients;

import java.util.List;

/**
 * Class to represent a coupon
 * A coupon has a porcentage of discount and a list of countries (instances of
 * {@link Country}) that can use it
 */
public class Coupon {

    /* The porcentage of discount */
    private int porcentage;

    /* The list of countries that can use the coupon */
    private List<Country> countries;

    /**
     * Constructor
     * 
     * @param porcentage the porcentage of discount
     * @param countries  the list of countries that can use the coupon
     */
    public Coupon(int porcentage, List<Country> countries) {
        this.porcentage = porcentage;
        this.countries = countries;
    }

    /**
     * Method to get the porcentage of discount
     * 
     * @return the porcentage of discount
     */
    public int getPorcentage() {
        return porcentage;
    }

    /**
     * Method to get the list of countries that can use the coupon
     * 
     * @return the list of countries that can use the coupon
     */
    public List<Country> getCountries() {
        return countries;
    }

}
