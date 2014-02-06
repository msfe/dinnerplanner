package se.kth.csc.iprog.dinnerplanner.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public class CreatedActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// Default call to load previous state
		super.onCreate(savedInstanceState);

		LayoutInflater inflater = getLayoutInflater();
		getWindow().addContentView(
				inflater.inflate(R.layout.show_info_on_courses_ingridients_screen, null),
				new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
						ViewGroup.LayoutParams.MATCH_PARENT));
		getWindow().addContentView(
				inflater.inflate(R.layout.choose_menu_top_view, null),
				new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
						ViewGroup.LayoutParams.MATCH_PARENT));

		// Creating the view class instance
		// MainMenuView mainView = new
		// MainMenuView(findViewById(R.id.this_is_chooseMenu_mainScreen));

	}
}
