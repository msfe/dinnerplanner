package se.kth.csc.iprog.dinnerplanner.android.view;

import java.util.Observable;
import java.util.Observer;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class TopMenuView implements Observer {

	View view;
	DinnerModel model;

	public TopMenuView(View view, final DinnerModel model) {

		// store in the class the reference to the Android View
		this.view = view;
		this.model = model;
		model.addObserver(this);

		TextView cost = (TextView) view.findViewById(R.id.dynamicCost);
		cost.setText(String.valueOf(model.getTotalMenuPrice()) + " kr");

		Spinner participants = (Spinner) view
				.findViewById(R.id.numGuestsDropDown);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				view.getContext(), R.array.participants_array,
				android.R.layout.simple_spinner_dropdown_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		participants.setAdapter(adapter);
		participants.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int pos, long id) {
				CharSequence updated = (CharSequence) parent
						.getItemAtPosition(pos);
				model.setNumberOfGuests(Integer.parseInt(updated.toString()));
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}

		});
		participants.setSelection(adapter.getPosition(String.valueOf(model
				.getNumberOfGuests())));

		// Setup the rest of the view layout
	}

	/**
	 * This method is called by the DinnerModel, it should performe
	 * update to the topbar booth if a dish is updated or if the number
	 * of guests is changed.
	 */
	@Override
	public void update(Observable observable, Object data) {
		updateVisuals();		
	}
	
	private void updateVisuals(){
		Spinner participants = (Spinner) view
				.findViewById(R.id.numGuestsDropDown);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				view.getContext(), R.array.participants_array,
				android.R.layout.simple_spinner_dropdown_item);
		participants.setSelection(adapter.getPosition(String.valueOf(model
				.getNumberOfGuests())));
		TextView cost = (TextView) view.findViewById(R.id.dynamicCost);
		cost.setText(String.valueOf(model.getTotalMenuPrice()) + " kr");
	}
	
	

}
