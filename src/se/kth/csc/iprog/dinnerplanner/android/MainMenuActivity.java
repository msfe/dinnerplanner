package se.kth.csc.iprog.dinnerplanner.android;

import se.kth.csc.iprog.dinnerplanner.android.view.MainMenuView;
import se.kth.csc.iprog.dinnerplanner.android.view.PopUpMenuView;
import se.kth.csc.iprog.dinnerplanner.android.view.TopMenuView;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public class MainMenuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// Default call to load previous state
		super.onCreate(savedInstanceState);

		DinnerModel model = ((DinnerPlannerApplication) this.getApplication())
				.getModel();

		LayoutInflater inflater = getLayoutInflater();
		getWindow().addContentView(
				inflater.inflate(R.layout.choose_menu_main_screen, null),
				new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
						ViewGroup.LayoutParams.MATCH_PARENT));
		getWindow().addContentView(
				inflater.inflate(R.layout.choose_menu_top_view, null),
				new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
						ViewGroup.LayoutParams.MATCH_PARENT));
//		getWindow().addContentView(
//                inflater.inflate(R.layout.choose_menu_choose_dish, null),
//                new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
//                        ViewGroup.LayoutParams.MATCH_PARENT));

		// Creating the view class instance
		MainMenuView mainView = new MainMenuView(
				findViewById(R.id.this_is_chooseMenu_mainScreen), model);
		TopMenuView topMenu = new TopMenuView(
				findViewById(R.id.this_is_chooseMenu_topView), model);
//		PopUpMenuView popUpMenu = new PopUpMenuView(
//                findViewById(R.id.this_is_chooseMenu_chooseDish), (Dish) model.getDishes().toArray()[0], model);

	}
}
