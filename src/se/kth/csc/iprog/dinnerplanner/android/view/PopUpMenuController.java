package se.kth.csc.iprog.dinnerplanner.android.view;

import se.kth.csc.iprog.dinnerplanner.android.MainMenuActivity;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import android.view.View;
import android.view.View.OnClickListener;

public class PopUpMenuController implements OnClickListener {
	
	PopUpMenuView menu;
	MainMenuActivity activity;
	DinnerModel model;

	public PopUpMenuController(PopUpMenuView popUpMenu,
			MainMenuActivity mainMenuActivity, DinnerModel model) {
		this.menu = popUpMenu;
		this.activity = mainMenuActivity;
		this.model = model;
		
		menu.close.setOnClickListener(this);
		menu.choose.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		if(v == menu.choose){
			model.addDishToMenu(menu.getDish());
			activity.killPopUp();
		}
		if(v == menu.close){
			activity.killPopUp();
		}		
	}


}
