package se.kth.csc.iprog.dinnerplanner.android;

import se.kth.csc.iprog.dinnerplanner.android.view.MainMenuView;
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

	private static final boolean show_popup = false;
	private Button create;

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
		if(show_popup){
		getWindow().addContentView(
				inflater.inflate(R.layout.choose_menu_choose_dish, null),
				new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
						ViewGroup.LayoutParams.MATCH_PARENT));
		}

		// Creating the view class instance
		MainMenuView mainView = new MainMenuView(
				findViewById(R.id.this_is_chooseMenu_mainScreen), model);
		TopMenuView topView = new TopMenuView(
				findViewById(R.id.this_is_chooseMenu_topView), model);
		
		topView.update();
		
		if(show_popup){
		PopUpMenuView popUpMenu = new PopUpMenuView(
				findViewById(R.id.this_is_chooseMenu_chooseDish), (Dish) model
						.getDishes().toArray()[0], model);
		}
		
        create = (Button)this.findViewById(R.id.createMenuButton);
        this.create.setOnClickListener(new OnClickListener() {
          //@Override
          public void onClick(View v) {
        	  Intent myIntent = new Intent(v.getContext(), ChosenActivity.class);
              startActivityForResult(myIntent, 0);
          }
        });
	}
}
