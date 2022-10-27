package clients;

import java.io.Serializable;
import java.util.List;

/**
 * Class to represent a coupon
 * A coupon has a percentage of discount and a list of countries (instances of
 * {@link Country}) that can use it
 */
public class Coupon implements Serializable {

    /* The percentage of discount */
    private int percentage;

    /* The list of countries that can use the coupon */
    private List<Country> countries;

    /**
     * Constructor
     * 
     * @param percentage the percentage of discount
     * @param countries  the list of countries that can use the coupon
     */
    public Coupon(int percentage, List<Country> countries) {
        this.percentage = percentage;
        this.countries = countries;
    }

    /**
     * Method to get the percentage of discount
     * 
     * @return the percentage of discount
     */
    public int getPercentage() {
        return percentage;
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
