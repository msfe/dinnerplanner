package se.kth.csc.iprog.dinnerplanner.android.view;

import se.kth.csc.iprog.dinnerplanner.android.R;
import android.view.View;
import android.widget.TextView;

public class ExampleView {

	View view;

	public ExampleView(View view) {

		// store in the class the reference to the Android View
		this.view = view;

		TextView example = (TextView) view.findViewById(R.id.blabla);
		
		
		//example.setText("Hello world");

		// Setup the rest of the view layout
	}

}
