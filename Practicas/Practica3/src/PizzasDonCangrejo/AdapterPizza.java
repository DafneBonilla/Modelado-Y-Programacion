package PizzasDonCangrejo;

import WaySub.Sandwich;

/**
 * Class to represent the adapter of a pizza.
 */
public class AdapterPizza implements Sandwich {

	/* The pizza of the adapter. */
	private Pizza pizza;

	/**
	 * Constructor for the adapter of a pizza.
	 * 
	 * @param pizza the pizza to be adapted.
	 */
	public AdapterPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	/**
	 * Returns the price of the pizza.
	 * 
	 * @return the price of the pizza.
	 */
	@Override
	public double getPrice() {
		return pizza.getPrice();
	}

	/**
	 * Returns the description of the pizza.
	 * 
	 * @return the description of the oizza.
	 */
	@Override
	public String getDescription() {
		return pizza.getName() + ", masa: " + pizza.getDough() + ", carne: " + pizza.getMeat() + ", queso: "
				+ pizza.getCheese();
	}

	/**
	 * Returns the number of times ingredients in the pizza.
	 * 
	 * @param ing the ingredient to check.
	 * @return the number of times the ingredient is in the pizza.
	 */
	@Override
	public int checkIngredient(String ing) {
		if (ing.equals(pizza.getMeat()) || ing.equals(pizza.getCheese()) || ing.equals(pizza.getDough())) {
			return 1;
		}
		return 0;
	}

	/**
	 * Returns the name of the pizza.
	 * 
	 * @return the name of the pizza.
	 */
	@Override
	public String getName() {
		return pizza.getName();
	}

	/**
	 * Returns the price of just the ingredient.
	 * 
	 * @return the price of just the ingredient.
	 */
	@Override
	public double getIngredientPrice() {
		return pizza.getPrice();
	}

}
