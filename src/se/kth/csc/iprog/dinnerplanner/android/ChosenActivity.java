package se.kth.csc.iprog.dinnerplanner.android;

import se.kth.csc.iprog.dinnerplanner.android.view.ChosenDishesView;
import se.kth.csc.iprog.dinnerplanner.android.view.CreatedView;
import se.kth.csc.iprog.dinnerplanner.android.view.TopMenuView;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public class ChosenActivity extends Activity {

	private static final boolean debug = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// Default call to load previous state
		super.onCreate(savedInstanceState);

		DinnerModel model = ((DinnerPlannerApplication) this.getApplication()).getModel();
		//TODO Remove line below
		if(debug){
		model.addDishToMenu((Dish) model.getDishesOfType(Dish.MAIN).toArray()[0]);
		model.setNumberOfGuests(2);
		}
		LayoutInflater inflater = getLayoutInflater();
		getWindow().addContentView(
				inflater.inflate(R.layout.show_info_on_courses_ingredients_screen, null),
				new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
						ViewGroup.LayoutParams.MATCH_PARENT));
		getWindow().addContentView(
				inflater.inflate(R.layout.choose_menu_top_view, null),
				new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
						ViewGroup.LayoutParams.MATCH_PARENT));

		// Creating the view class instance
		 ChosenDishesView mainView = new ChosenDishesView(findViewById(R.id.this_is_showInfoOnCourses_ingridientsScreen), model);
		TopMenuView topView = new TopMenuView(findViewById(R.id.this_is_chooseMenu_topView), model);

	}
}
