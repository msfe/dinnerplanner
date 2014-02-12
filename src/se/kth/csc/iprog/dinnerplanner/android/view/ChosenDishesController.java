package se.kth.csc.iprog.dinnerplanner.android.view;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class ChosenDishesController implements OnClickListener {
	View view;
	DinnerModel model;
	
	ImageButton instructionsButton;
	ImageButton starterButton;
	ImageButton mainDishButton;
	ImageButton dessertButton;
	
	public ChosenDishesController(View view, DinnerModel model) {
		this.view = view;
		this.model = model;
		
		instructionsButton = (ImageButton) view.findViewById(R.id.showIngredients)
				.findViewById(R.id.dishImage);
		
		starterButton = (ImageButton) view.findViewById(R.id.starter)
				.findViewById(R.id.dishImage);
		mainDishButton = (ImageButton) view.findViewById(R.id.main)
				.findViewById(R.id.dishImage);
		dessertButton = (ImageButton) view.findViewById(R.id.dessert)
				.findViewById(R.id.dishImage);
		
		instructionsButton.setOnClickListener(this);
		starterButton.setOnClickListener(this);
		mainDishButton.setOnClickListener(this);
		dessertButton.setOnClickListener(this);
		
	}


	@Override
	public void onClick(View v) {
		System.out.println(v.getId());
		if(v.getId() == instructionsButton.getId()){
			System.out.println("instructions!");
		}
	}

}
