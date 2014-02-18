package se.kth.csc.iprog.dinnerplanner.android.view;

import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import se.kth.csc.iprog.dinnerplanner.model.Ingredient;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class ChosenDishesView implements Observer {
	private boolean instruction;
	private int dishType;
	View view;
	DinnerModel model;

	ImageButton instructionsButton;
	ImageButton starterButton;
	ImageButton mainDishButton;
	ImageButton dessertButton;
	TextView starterText;
	TextView mainText;
	TextView dessertText;
	TextView ingredientsText;

	public ChosenDishesView(View view, DinnerModel model) {
		this.view = view;
		this.model = model;

		instructionsButton = (ImageButton) view.findViewById(
				R.id.showIngredients).findViewById(R.id.dishImage);
		starterButton = (ImageButton) view.findViewById(R.id.starter)
				.findViewById(R.id.dishImage);
		mainDishButton = (ImageButton) view.findViewById(R.id.main)
				.findViewById(R.id.dishImage);
		dessertButton = (ImageButton) view.findViewById(R.id.dessert)
				.findViewById(R.id.dishImage);

		starterText = (TextView) view.findViewById(R.id.starter).findViewById(
				R.id.imageText);
		mainText = (TextView) view.findViewById(R.id.main).findViewById(
				R.id.imageText);
		dessertText = (TextView) view.findViewById(R.id.dessert).findViewById(
				R.id.imageText);
		ingredientsText = (TextView) view.findViewById(R.id.showIngredients)
				.findViewById(R.id.imageText);
		

		model.addObserver(this);
		instruction = false;
		dishType = 0;
		fillPickedMenuImages();
		fillIngredientsList();
	}

	public void fillIngredientsList() {
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
		instruction = false;
	}

	// TODO: Add the images also
	public void fillPickedMenuImages() {

		ingredientsText.setText("Ingredients");

		Dish dish = model.getSelectedDish(Dish.STARTER);
		if (dish == null) {
			starterButton.setImageDrawable(view.getResources().getDrawable(R.drawable.red_screen));
			starterText.setText("No dish");
		} else {
			int id = view.getResources().getIdentifier(dish.getImage().split("\\.")[0], "drawable",this.view.getContext().getPackageName());
			starterButton.setImageResource(id);
			starterText.setText(dish.getName());
		}

		dish = model.getSelectedDish(Dish.MAIN);
		if (dish == null) {
//			mainDishButton.setImageDrawable(view.getResources().getDrawable(R.drawable.red_screen));
			mainText.setText("No dish");
		} else {
			int id = view.getResources().getIdentifier(dish.getImage().split("\\.")[0], "drawable",this.view.getContext().getPackageName());
			mainDishButton.setImageResource(id);
			mainText.setText(dish.getName());
		}

		dish = model.getSelectedDish(Dish.DESERT);
		if (dish == null) {
			dessertButton.setImageDrawable(view.getResources().getDrawable(R.drawable.red_screen));
			dessertText.setText("No dish");
		} else {
			int id = view.getResources().getIdentifier(dish.getImage().split("\\.")[0], "drawable",this.view.getContext().getPackageName());
			System.out.println(id);
			dessertButton.setImageResource(id);
			dessertText.setText(dish.getName());
		}
	}

	public void fillInstruction(int dishType) {
		Dish selectedDish = model.getSelectedDish(dishType);
		if (selectedDish == null) {
			return;
		}
		TextView instructionsTextView = (TextView) view
				.findViewById(R.id.chosenText);
		TextView title = (TextView) view.findViewById(R.id.title);
		TextView subTitle = (TextView) view.findViewById(R.id.subTitle);

		title.setText("Instructions");
		subTitle.setText(model.getNumberOfGuests() + " port");
		instructionsTextView.setText(selectedDish.getDescription());
		instruction = true;
		this.dishType = dishType;
	}

	@Override
	public void update(Observable observable, Object data) {
		if (data instanceof Dish) { // Menu changed
			fillPickedMenuImages();
			if (!instruction) {
				fillIngredientsList();
			} else {
				fillInstruction(dishType);
			}
		}
		if (data instanceof Integer) { // numGuests change
			if (!instruction) {
				fillIngredientsList();
			} else {
				fillInstruction(dishType);
			}
		}
	}
}
