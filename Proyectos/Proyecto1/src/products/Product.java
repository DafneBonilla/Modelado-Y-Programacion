package products;

import java.io.Serializable;

public abstract class Product implements Serializable {

    public abstract long getBarcode();

    public abstract String getName();

    public abstract Department getDepartment();

    public abstract double getPrice();

    @Override
    public String toString() {
        return "Nombre: " + getName() + " | Codigo de Barras: " + getBarcode() + " | Precio: $" + getPrice()
                + " | Departamento: " + getDepartment();
    }

}