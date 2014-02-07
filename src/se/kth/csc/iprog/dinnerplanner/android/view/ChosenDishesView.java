package se.kth.csc.iprog.dinnerplanner.android.view;

import java.util.Set;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import se.kth.csc.iprog.dinnerplanner.model.Ingredient;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ChosenDishesView {
	View view;
	DinnerModel model;
	
	public ChosenDishesView(View view, DinnerModel model){
		this.view = view;
		this.model = model;
		fillIngredientsList(model, view);
		
	}
	
	public void fillIngredientsList(DinnerModel model, View view){
		Set<Ingredient> ingredients = model.getAllIngredients();
		TextView ingredientsTextView = (TextView) view.findViewById(R.id.chosenText);
		TextView title = (TextView) view.findViewById(R.id.title);
		TextView subTitle = (TextView) view.findViewById(R.id.subTitle);
		StringBuilder sb = new StringBuilder();
		for(Ingredient ingredient : ingredients){
			sb.append(ingredient.getName());
			sb.append(" ");
			sb.append(ingredient.getQuantity());
			sb.append(" ");
			sb.append(ingredient.getQuantity());
			sb.append("\n");
		}
		
		title.setText("Ingredients");
		subTitle.setText(model.getNumberOfGuests() + " port");
		ingredientsTextView.setText(sb.toString());
	}
	
	// TODO: Change from text to images
//	public void fillPickedMenuImages(DinnerModel model, View view){
//		Set<Dish> dishes = model.getDishes();
//		
//		for(Dish dish : dishes){
//			TextView image = new TextView(view.getContext());
//			image.setText(dish.getName());
//			image.setTag(dish.getName());
//			dishesList.addView(image);
//		}
//	}
	
//	public void fillInstruction(DinnerModel model, View view){
//		
//	}
	
}
