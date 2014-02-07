package se.kth.csc.iprog.dinnerplanner.android.view;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class TopMenuView {

	View view;
	DinnerModel model;

	public TopMenuView(View view, final DinnerModel model) {

		// store in the class the reference to the Android View
		this.view = view;
		this.model = model;
		
		TextView cost = (TextView) view.findViewById(R.id.dynamicCost);
		cost.setText(String.valueOf(model.getTotalMenuPrice()) + " kr");
		
		Spinner participants = (Spinner) view.findViewById(R.id.numGuestsDropDown);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(view.getContext(), R.array.participants_array, android.R.layout.simple_spinner_dropdown_item);
		
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		participants.setAdapter(adapter);
		participants.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int pos, long id) {
				CharSequence updated = (CharSequence) parent.getItemAtPosition(pos);
				model.setNumberOfGuests(Integer.parseInt(updated.toString()));
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
			
		});
		
		

		// Setup the rest of the view layout
	}

}
