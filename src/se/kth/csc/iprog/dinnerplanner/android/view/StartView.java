package se.kth.csc.iprog.dinnerplanner.android.view;

import se.kth.csc.iprog.dinnerplanner.android.R;
import android.R.string;
import android.view.View;
import android.widget.TextView;

public class StartView {

	View view;

	public StartView(View view) {

		// store in the class the reference to the Android View
		this.view = view;

		TextView example = (TextView) view.findViewById(R.id.startInfo888);
		
		example.setText(R.string.welcomeString);

		// Setup the rest of the view layout
	}

}
