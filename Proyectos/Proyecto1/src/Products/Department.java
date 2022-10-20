package Products;

public enum Department {

    ELECTRONICS, GROCERY, PETS, HOMEAPPLIANCES, VIDEOGAMES;

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
