package se.kth.csc.iprog.dinnerplanner.android.view;

import se.kth.csc.iprog.dinnerplanner.android.MainMenuActivity;
import se.kth.csc.iprog.dinnerplanner.android.classes.DishImageButton;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class MainMenuController implements OnClickListener {
	MainMenuView view;
	MainMenuActivity activity;

	public MainMenuController(MainMenuView view, MainMenuActivity acitvity) {
		this.view = view;
		this.activity = acitvity;
		for (int i = 0; i < view.starterList.getChildCount(); i++) {
			if (!(view.starterList.getChildAt(i) instanceof ImageButton)) {
				continue;
			}
			ImageButton button = (ImageButton) view.starterList.getChildAt(i);
			button.setOnClickListener(this);
		}
		for (int i = 0; i < view.mainList.getChildCount(); i++) {
			if (!(view.mainList.getChildAt(i) instanceof ImageButton)) {
				continue;
			}
			ImageButton button = (ImageButton) view.mainList.getChildAt(i);
			button.setOnClickListener(this);
		}
		for (int i = 0; i < view.desertList.getChildCount(); i++) {
			if (!(view.desertList.getChildAt(i) instanceof ImageButton)) {
				continue;
			}
			ImageButton button = (ImageButton) view.desertList.getChildAt(i);
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
