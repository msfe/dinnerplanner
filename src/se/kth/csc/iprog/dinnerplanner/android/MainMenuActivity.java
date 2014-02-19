package se.kth.csc.iprog.dinnerplanner.android;

import se.kth.csc.iprog.dinnerplanner.android.view.MainMenuController;
import se.kth.csc.iprog.dinnerplanner.android.view.MainMenuView;
import se.kth.csc.iprog.dinnerplanner.android.view.PopUpMenuController;
import se.kth.csc.iprog.dinnerplanner.android.view.PopUpMenuView;
import se.kth.csc.iprog.dinnerplanner.android.view.TopMenuView;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class MainMenuActivity extends Activity {

	private Button create;
	LayoutInflater inflater;
	DinnerModel model;
	View popUpView;
	MainMenuController mainController;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// Default call to load previous state
		super.onCreate(savedInstanceState);

		model = ((DinnerPlannerApplication) this.getApplication()).getModel();

		inflater = getLayoutInflater();
		getWindow().addContentView(
				inflater.inflate(R.layout.choose_menu_main_screen, null),
				new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
						ViewGroup.LayoutParams.MATCH_PARENT));
		getWindow().addContentView(
				inflater.inflate(R.layout.choose_menu_top_view, null),
				new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
						ViewGroup.LayoutParams.MATCH_PARENT));

		// Creating the view class instance
		MainMenuView mainView = new MainMenuView(
				findViewById(R.id.this_is_chooseMenu_mainScreen), model);
		mainController = new MainMenuController(mainView,
				this, model);
		TopMenuView topView = new TopMenuView(
				findViewById(R.id.this_is_chooseMenu_topView), model);

		//TODO Move this shit out of here! ^^
		create = (Button) this.findViewById(R.id.createMenuButton);
		this.create.setOnClickListener(new OnClickListener() {
			// @Override
			public void onClick(View v) {
				Intent myIntent = new Intent(v.getContext(),
						ChosenActivity.class);
				startActivityForResult(myIntent, 0);
			}
		});
	}

	public void activatePopUp(Dish dish) {
		ViewGroup vg = (ViewGroup) findViewById(android.R.id.content)
				.getRootView();
		popUpView = View.inflate(this, R.layout.choose_menu_choose_dish, vg);

		PopUpMenuView popup = new PopUpMenuView(findViewById(R.id.this_is_chooseMenu_chooseDish),
				dish, model);
		new PopUpMenuController(popup, this, model);
		
		mainController.disableClickable();
	}

	public void killPopUp() {
		ViewGroup vg = (ViewGroup) (popUpView.getRootView());
		vg.removeView(findViewById(R.id.this_is_chooseMenu_chooseDish));
		mainController.enableClickable();
	}
}
