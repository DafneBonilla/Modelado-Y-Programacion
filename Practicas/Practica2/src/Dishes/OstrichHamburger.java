package Dishes;

public class OstrichHamburger extends Hamburger {

    public OstrichHamburger() {
        this.id = 31;
        this.name = "Hamburguesa de avestruz";
        this.description = "Hamburguesa con carne de avestruz, lechuga, raiz de zanahoria, grillos, ketchup, mostaza y mayonesa";
        this.price = 14.99;
        this.cheese = false;
        this.vegetarian = false;
    }

    @Override
    protected void prepareMeat() {
        System.out.println("Cociendo carne de avestruz");
    }

    @Override
    protected void putMeat() {
        System.out.println("Poniendo carne de avestruz");

    }

    @Override
    protected void putCheese() {
        if (cheese) {
            System.out.println("Poniendo queso");
        }
    }

    @Override
    protected void putVegetables() {
        System.out.println("Poniendo raiz de zanahoria y grillos");
    }

    @Override
    public String toString() {
        return "[ ID: " + id + " | Nombre: " + name + " | Descripción: " + description + " | Precio: " + price
                + "$(USD) | Queso: " + cheese + " | Vegetariano: " + vegetarian + " ]";
    }

}
