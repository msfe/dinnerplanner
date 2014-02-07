package se.kth.csc.iprog.dinnerplanner.android.view;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import android.view.View;
import android.widget.TextView;

public class TopMenuView {

	View view;
	DinnerModel model;

	public TopMenuView(View view, DinnerModel model) {

		// store in the class the reference to the Android View
		this.view = view;
		this.model = model;
		
		TextView cost = (TextView) view.findViewById(R.id.dynamicCost);
		cost.setText(String.valueOf(model.getTotalMenuPrice()) + " kr");

		// Setup the rest of the view layout
	}

}
