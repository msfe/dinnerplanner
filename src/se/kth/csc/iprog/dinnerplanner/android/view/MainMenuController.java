package se.kth.csc.iprog.dinnerplanner.android.view;

import se.kth.csc.iprog.dinnerplanner.android.MainMenuActivity;
import se.kth.csc.iprog.dinnerplanner.android.classes.DishImageButton;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class MainMenuController implements OnClickListener {
	MainMenuView view;
	MainMenuActivity activity;

	public MainMenuController(MainMenuView view, MainMenuActivity acitvity) {
		this.view = view;
		this.activity = acitvity;
		for (int i = 0; i < view.starterList.getChildCount(); i++) {
			if (! (((RelativeLayout)view.starterList.getChildAt(i)).getChildAt(0) instanceof ImageButton)) {
				continue;
			}
			
			ImageButton button = (ImageButton) ((RelativeLayout) view.starterList.getChildAt(i)).getChildAt(0);
			button.setOnClickListener(this);
		}
		for (int i = 0; i < view.mainList.getChildCount(); i++) {
			if (! (((RelativeLayout)view.mainList.getChildAt(i)).getChildAt(0) instanceof ImageButton)) {
				continue;
			}
			
			ImageButton button = (ImageButton) ((RelativeLayout) view.mainList.getChildAt(i)).getChildAt(0);
			button.setOnClickListener(this);
		}
		for (int i = 0; i < view.desertList.getChildCount(); i++) {
			if (! (((RelativeLayout)view.desertList.getChildAt(i)).getChildAt(0) instanceof ImageButton)) {
				continue;
			}
			
			ImageButton button = (ImageButton) ((RelativeLayout) view.desertList.getChildAt(i)).getChildAt(0);
			button.setOnClickListener(this);
		}
	}

	@Override
	public void onClick(View v) {
		if (v instanceof DishImageButton) {
			DishImageButton button = (DishImageButton) v;
			Dish dish = button.getDish();

			activity.activatePopUp(dish);
		}
	}
}
