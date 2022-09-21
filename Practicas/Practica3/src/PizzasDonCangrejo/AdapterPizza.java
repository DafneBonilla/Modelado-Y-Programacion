package PizzasDonCangrejo;

import WaySub.Sandwich;

public class AdapterPizza implements Sandwich {

    private Pizza pizza;
    
    public AdapterPizza(Pizza pizza) {
        this.pizza = pizza;
    }

	@Override
	public double getPrice() {
        return pizza.getPrice();
	}

	@Override
	public String getDescription() {
		return "Pizza de masa: " + pizza.getDough() + ", carne: " + pizza.getMeat() + ", queso: " + pizza.getCheese(); 
	}

	@Override
	public int checkIngredient(String ing) {
		if (ing.equals(pizza.getMeat()) || ing.equals(pizza.getCheese()) || ing.equals(pizza.getDough())) {
            return 1;
        }
        return 0;
	}
    
}
