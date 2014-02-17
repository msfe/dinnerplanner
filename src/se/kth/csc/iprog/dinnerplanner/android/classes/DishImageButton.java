package se.kth.csc.iprog.dinnerplanner.android.classes;

import se.kth.csc.iprog.dinnerplanner.model.Dish;
import android.content.Context;
import android.widget.ImageButton;

public class DishImageButton extends ImageButton {

	Dish dish;

	public DishImageButton(Context context) {
		super(context);
	}

	public DishImageButton(Context context, Dish dish) {
		super(context);
		this.dish = dish;
	}

	public Dish getDish() {
		return dish;
	}

}
