package se.kth.csc.iprog.dinnerplanner.android.view;

import java.util.Set;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainMenuView {

	View view;
	DinnerModel model;

	public MainMenuView(View view, DinnerModel model) {

		// store in the class the reference to the Android View
		this.view = view;
		this.model = model;
		
		//Add Starters to view
		LinearLayout ll = (LinearLayout) view.findViewById(R.id.startersScrollLinear);
		Set<Dish> starters = model.getDishesOfType(Dish.STARTER);
		
		for(Dish starter : starters){
			
			TextView tv = new TextView(view.getContext());
			tv.setPadding(20, 10, 20, 10);
			tv.setTextSize(30);
			tv.setText(starter.getName());
			ll.addView(tv);
			
		}
		
		
		//		TextView mainMenu = (TextView) view.findViewById(R.id.this_is_chooseMenu_mainScreen);
		//example.setText("Hello world");

		// Setup the rest of the view layout
	}

}
