package Clients;

import Products.Department;

public enum Country {

    MEXICO, USA, SPAIN;

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

    public Department getDeparment() {
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
