package products;

/**
 * Enum to represent departments
 */
public enum Department {

    /* The departments */
    ELECTRONICS, GROCERY, PETS, HOMEAPPLIANCES, VIDEOGAMES;

    /**
     * Method to get the department from an integer
     * In case of not finding the department, the method will return null
     * 
     * @param i the integer to convert
     * @return the department associated with the integer
     */
    public static Department getDepartment(int i) {
        switch (i) {
            case 0:
                return ELECTRONICS;
            case 1:
                return GROCERY;
            case 2:
                return PETS;
            case 3:
                return HOMEAPPLIANCES;
            case 4:
                return VIDEOGAMES;
            default:
                return null;
        }
    }

    /**
     * Method to return an integer from the department that is calling the method
     * In case of not finding the department, the method will return -1
     * 
     * @return the integer associated with the department
     */
    public int getInt() {
        switch (this) {
            case ELECTRONICS:
                return 0;
            case GROCERY:
                return 1;
            case PETS:
                return 2;
            case HOMEAPPLIANCES:
                return 3;
            case VIDEOGAMES:
                return 4;
            default:
                return -1;
        }
    }

    /**
     * Method to return the department as a string
     * 
     * @return the department as a string
     */
    @Override
    public String toString() {
        switch (this) {
            case ELECTRONICS:
                return "Electronica";
            case GROCERY:
                return "Alimentos";
            case PETS:
                return "Mascotas";
            case HOMEAPPLIANCES:
                return "Electrodomesticos";
            case VIDEOGAMES:
                return "Videojuegos";
            default:
                return "";
        }
    }

}
