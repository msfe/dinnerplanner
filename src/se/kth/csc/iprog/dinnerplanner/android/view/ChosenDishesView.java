package se.kth.csc.iprog.dinnerplanner.android.view;

import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import se.kth.csc.iprog.dinnerplanner.model.Ingredient;
import android.view.View;
import android.widget.TextView;

public class ChosenDishesView implements Observer {
	private boolean instruction;
	View view;
	DinnerModel model;

	public ChosenDishesView(View view, DinnerModel model) {
		this.view = view;
		this.model = model;
		model.addObserver(this);
		instruction = false;
		fillPickedMenuImages(model, view);
		if (instruction) {
			fillInstruction(model, view, Dish.MAIN);
		} else {
			fillIngredientsList(model, view);
		}

	}

	public void fillIngredientsList(DinnerModel model, View view) {
		Set<Ingredient> ingredients = model.getAllIngredients();
		TextView ingredientsTextView = (TextView) view
				.findViewById(R.id.chosenText);
		TextView title = (TextView) view.findViewById(R.id.title);
		TextView subTitle = (TextView) view.findViewById(R.id.subTitle);
		StringBuilder sb = new StringBuilder();
		for (Ingredient ingredient : ingredients) {
			sb.append(ingredient.getName());
			sb.append(" ");
			sb.append(ingredient.getQuantity());
			sb.append(" ");
			sb.append(ingredient.getUnit());
			sb.append("\n");
		}

		title.setText("Ingredients");
		subTitle.setText(model.getNumberOfGuests() + " port");
		ingredientsTextView.setText(sb.toString());
	}

	// TODO: Add the images also
	public void fillPickedMenuImages(DinnerModel model, View view) {
		Set<Dish> dishes = model.getFullMenu();
		TextView starter = (TextView) view.findViewById(R.id.starter)
				.findViewById(R.id.imageText);
		TextView main = (TextView) view.findViewById(R.id.main).findViewById(
				R.id.imageText);
		TextView dessert = (TextView) view.findViewById(R.id.dessert)
				.findViewById(R.id.imageText);

		for (Dish dish : dishes) {
			switch (dish.getType()) {
			case (Dish.STARTER):
				starter.setText(dish.getName());
				break;
			case (Dish.MAIN):
				main.setText(dish.getName());
				break;
			case (Dish.DESERT):
				dessert.setText(dish.getName());
				break;
			}
		}
	}

	// TODO: Add this function
	public void fillInstruction(DinnerModel model, View view, int dishType) {
		Dish selectedDish = model.getSelectedDish(dishType);
		TextView instructionsTextView = (TextView) view
				.findViewById(R.id.chosenText);
		TextView title = (TextView) view.findViewById(R.id.title);
		TextView subTitle = (TextView) view.findViewById(R.id.subTitle);

		title.setText("Instructions");
		subTitle.setText(model.getNumberOfGuests() + " port");
		instructionsTextView.setText(selectedDish.getDescription());
	}

	@Override
	public void update(Observable observable, Object data) {
		if (data instanceof Dish) { //Menu changed
			fillPickedMenuImages(model, view);
			if(!instruction){
				fillIngredientsList(model, view);
			}
		}
		if(data instanceof Integer){ //numGuests change
			if(!instruction){
				fillIngredientsList(model, view);
			}
		}
	}

}
