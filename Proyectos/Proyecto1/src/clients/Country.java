package clients;

import products.Department;

/**
 * Enum to represent countries
 */
public enum Country {

    /* The countries */
    MEXICO, USA, SPAIN;

    /**
     * Method to get the country from an integer
     * In case of not finding the country, the method will return null
     * 
     * @param i the integer to convert
     * @return the country associated with the integer
     */
    public static Country getCountry(int i) {
        switch (i) {
            case 0:
                return MEXICO;
            case 1:
                return USA;
            case 2:
                return SPAIN;
            default:
                return null;
        }
    }

    /**
     * Method to return an integer from the country that is calling the method
     * In case of not finding the country, the method will return -1
     * 
     * @return the integer associated with the country
     */
    public int getInt() {
        switch (this) {
            case MEXICO:
                return 0;
            case USA:
                return 1;
            case SPAIN:
                return 2;
            default:
                return -1;
        }
    }

    /**
     * Method to return a department from the country that is calling the method
     * In case of not finding the country, the method will return null
     * 
     * @return the department associated with the country
     */
    public Department getDepartment() {
        switch (this) {
            case MEXICO:
                return Department.GROCERY;
            case USA:
                return Department.ELECTRONICS;
            case SPAIN:
                return Department.HOMEAPPLIANCES;
            default:
                return null;
        }

    }

    /**
     * Method to return the country as a string
     * 
     * @return the country as a string
     */
    @Override
    public String toString() {
        switch (this) {
            case MEXICO:
                return "Mexico";
            case USA:
                return "USA";
            case SPAIN:
                return "Espania";
            default:
                return "";
        }
    }

}
