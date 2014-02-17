package se.kth.csc.iprog.dinnerplanner.android.view;

import java.util.Set;

import se.kth.csc.iprog.dinnerplanner.android.MainMenuActivity;
import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.android.classes.DishImageButton;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainMenuView {

	View view;
	DinnerModel model;

	LinearLayout starterList;
	LinearLayout mainList;
	LinearLayout desertList;

	public MainMenuView(View view, DinnerModel model) {

		// store in the class the reference to the Android View
		this.view = view;
		this.model = model;

		starterList = (LinearLayout) view
				.findViewById(R.id.startersScrollLinear);
		mainList = (LinearLayout) view.findViewById(R.id.mainsScrollLinear);
		desertList = (LinearLayout) view
				.findViewById(R.id.dessertsScrollLinear);

		// Add starter
		Set<Dish> starters = model.getDishesOfType(Dish.STARTER);
		for (Dish starter : starters) {
			addDishToScrollView(starterList, starter);
		}
		Set<Dish> mains = model.getDishesOfType(Dish.MAIN);
		for (Dish main : mains) {
			addDishToScrollView(mainList, main);
		}
		Set<Dish> deserts = model.getDishesOfType(Dish.DESERT);
		for (Dish desert : deserts) {
			addDishToScrollView(desertList, desert);
		}

	}

	public void addDishToScrollView(LinearLayout linearLayout, Dish dish) {

		DishImageButton imageButton = new DishImageButton(view.getContext(),
				dish);
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
				convertDpToPx(100), convertDpToPx(100));
		params.leftMargin = convertDpToPx(10);
		params.rightMargin = convertDpToPx(10);
		imageButton.setLayoutParams(params);
		int id = view.getResources().getIdentifier(
				dish.getImage().split("\\.")[0], "drawable",
				this.view.getContext().getPackageName());
		imageButton.setImageResource(id);
		linearLayout.addView(imageButton);

	}

	private int convertDpToPx(int dp) {
		float scale = view.getContext().getResources().getDisplayMetrics().density;
		return (int) (dp * scale + 0.5f);
	}

}
