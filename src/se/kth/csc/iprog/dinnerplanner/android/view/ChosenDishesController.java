package se.kth.csc.iprog.dinnerplanner.android.view;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import android.view.View;
import android.view.View.OnClickListener;

public class ChosenDishesController implements OnClickListener {
	ChosenDishesView view;
	DinnerModel model;

	
	public ChosenDishesController(ChosenDishesView view, DinnerModel model) {
		this.view = view;
		this.model = model;
		
		
		view.instructionsButton.setOnClickListener(this);
		view.starterButton.setOnClickListener(this);
		view.mainDishButton.setOnClickListener(this);
		view.dessertButton.setOnClickListener(this);
		
	}


	@Override
	public void onClick(View v) {
		System.out.println(v.getId());
		if(v == view.instructionsButton){
			view.fillIngredientsList();
		}
		if(v == view.starterButton){
			view.fillInstruction(Dish.STARTER);
		}
		if(v == view.mainDishButton){
			view.fillInstruction(Dish.MAIN);
		}
		if(v == view.dessertButton){
			view.fillInstruction(Dish.DESERT);
		}
	}

}
