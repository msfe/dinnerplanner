package se.kth.csc.iprog.dinnerplanner.android.view;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import android.view.View;
import android.widget.TextView;

public class MainMenuView {

	View view;

	public MainMenuView(View view) {

		// store in the class the reference to the Android View
		this.view = view;

		TextView mainMenu = (TextView) view.findViewById(R.id.this_is_chooseMenu_mainScreen);
		//example.setText("Hello world");

		// Setup the rest of the view layout
	}

}
