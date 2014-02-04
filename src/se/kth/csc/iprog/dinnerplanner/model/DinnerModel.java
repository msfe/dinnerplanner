package se.kth.csc.iprog.dinnerplanner.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DinnerModel implements IDinnerModel {

	Set<Dish> allDishes = new HashSet<Dish>();
	Set<Dish> pickedDishes = new HashSet<Dish>();
	int numGuests = 0;

	/**
	 * TODO: For Lab2 you need to implement the IDinnerModel interface. When you
	 * do this you will have all the needed fields and methods for the dinner
	 * planner (number of guests, selected dishes, etc.).
	 */

	/**
	 * The constructor of the overall model. Set the default values here
	 */
	public DinnerModel() {

		// Adding some example data, you can add more
		Dish dish1 = new Dish(
				"French toast",
				Dish.STARTER,
				"toast.jpg",
				"In a large mixing bowl, beat the eggs. Add the milk, brown sugar and nutmeg; stir well to combine. Soak bread slices in the egg mixture until saturated. Heat a lightly oiled griddle or frying pan over medium high heat. Brown slices on both sides, sprinkle with cinnamon and serve hot.");
		Ingredient dish1ing1 = new Ingredient("eggs", 0.5, "", 1);
		Ingredient dish1ing2 = new Ingredient("milk", 30, "ml", 6);
		Ingredient dish1ing3 = new Ingredient("brown sugar", 7, "g", 1);
		Ingredient dish1ing4 = new Ingredient("ground nutmeg", 0.5, "g", 12);
		Ingredient dish1ing5 = new Ingredient("white bread", 2, "slices", 2);
		dish1.addIngredient(dish1ing1);
		dish1.addIngredient(dish1ing2);
		dish1.addIngredient(dish1ing3);
		dish1.addIngredient(dish1ing4);
		dish1.addIngredient(dish1ing5);
		allDishes.add(dish1);

		Dish dish2 = new Dish(
				"Meat balls",
				Dish.MAIN,
				"meatballs.jpg",
				"Preheat an oven to 400 degrees F (200 degrees C). Place the beef into a mixing bowl, and season with salt, onion, garlic salt, Italian seasoning, oregano, red pepper flakes, hot pepper sauce, and Worcestershire sauce; mix well. Add the milk, Parmesan cheese, and bread crumbs. Mix until evenly blended, then form into 1 1/2-inch meatballs, and place onto a baking sheet. Bake in the preheated oven until no longer pink in the center, 20 to 25 minutes.");
		Ingredient dish2ing1 = new Ingredient("extra lean ground beef", 115,
				"g", 20);
		Ingredient dish2ing2 = new Ingredient("sea salt", 0.7, "g", 3);
		Ingredient dish2ing3 = new Ingredient("small onion, diced", 0.25, "", 2);
		Ingredient dish2ing4 = new Ingredient("garlic salt", 0.6, "g", 3);
		Ingredient dish2ing5 = new Ingredient("Italian seasoning", 0.3, "g", 3);
		Ingredient dish2ing6 = new Ingredient("dried oregano", 0.3, "g", 3);
		Ingredient dish2ing7 = new Ingredient("crushed red pepper flakes", 0.6,
				"g", 3);
		Ingredient dish2ing8 = new Ingredient("Worcestershire sauce", 16, "ml",
				7);
		Ingredient dish2ing9 = new Ingredient("milk", 20, "ml", 4);
		Ingredient dish2ing10 = new Ingredient("grated Parmesan cheese", 5,
				"g", 8);
		Ingredient dish2ing11 = new Ingredient("seasoned bread crumbs", 115,
				"g", 4);
		dish2.addIngredient(dish2ing1);
		dish2.addIngredient(dish2ing2);
		dish2.addIngredient(dish2ing3);
		dish2.addIngredient(dish2ing4);
		dish2.addIngredient(dish2ing5);
		dish2.addIngredient(dish2ing6);
		dish2.addIngredient(dish2ing7);
		dish2.addIngredient(dish2ing8);
		dish2.addIngredient(dish2ing9);
		dish2.addIngredient(dish2ing10);
		dish2.addIngredient(dish2ing11);
		allDishes.add(dish2);

	}

	/**
	 * Returns all dishes available.
	 */
	public Set<Dish> getDishes() {
		return allDishes;
	}

	/**
	 * Returns the set of dishes of specific type. (1 = starter, 2 = main, 3 =
	 * desert).
	 */
	public Set<Dish> getDishesOfType(int type) {
		Set<Dish> result = new HashSet<Dish>();
		for (Dish d : allDishes) {
			if (d.getType() == type) {
				result.add(d);
			}
		}
		return result;
	}

	/**
	 * Returns the set of dishes of specific type, that contain filter in their
	 * name or name of any ingredient.
	 */
	public Set<Dish> filterDishesOfType(int type, String filter) {
		Set<Dish> result = new HashSet<Dish>();
		for (Dish d : allDishes) {
			if (d.getType() == type && d.contains(filter)) {
				result.add(d);
			}
		}
		return result;
	}

	/**
	 * @return The number of guests
	 */
	@Override
	public int getNumberOfGuests() {
		return numGuests;
	}

	/**
	 * @param The
	 *            new number of guests
	 */
	@Override
	public void setNumberOfGuests(int numberOfGuests) {
		numGuests = numberOfGuests;
	}

	/**
	 * @param get
	 *            selected dish of certain type(1 = starter, 2 = main, 3 =
	 *            desert)
	 * @return returns dish if any is picked, otherwise will return null.
	 */
	@Override
	public Dish getSelectedDish(int type) {
		for (Dish dish : pickedDishes) {
			if (dish.type == type) {
				return dish;
			}
		}
		return null;
	}

	/**
	 * Returns a Set of all the picked dishes.
	 */
	@Override
	public Set<Dish> getFullMenu() {
		return pickedDishes;
	}

	/**
	 * Return all the ingredients in the picked menu
	 */
	@Override
	public Set<Ingredient> getAllIngredients() {
		HashSet<Ingredient> returnListIngredients = new HashSet<Ingredient>();
		ArrayList<Ingredient> existingIngredients = new ArrayList<Ingredient>();
		for (Dish dish : pickedDishes) {
			Set<Ingredient> dishIngredients = dish.getIngredients();
			for (Ingredient ingredient : dishIngredients) {
				if (returnListIngredients.contains(ingredient)) {
					//The set will overwrite and quantity info will be lost
					existingIngredients.add(ingredient);
				} else {
					returnListIngredients.add(ingredient);
				}
			}
		}
		for (Ingredient ingredient : returnListIngredients) {
			while(existingIngredients.contains(ingredient)) {
				int index = existingIngredients
						.indexOf(ingredient);
				ingredient.quantity += existingIngredients.get(index).quantity;
				existingIngredients.remove(index);
			}
		}
		return returnListIngredients;
	}

	/**
	 * Return the total price of the picked menu.
	 */
	@Override
	public float getTotalMenuPrice() {
		float cost = 0;
		Set<Ingredient> ingredients = getAllIngredients();
		for (Ingredient ingrident : ingredients) {
			cost += ingrident.price * ingrident.quantity;
		}
		return cost;
	}

}
