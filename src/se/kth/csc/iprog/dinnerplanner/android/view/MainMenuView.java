package se.kth.csc.iprog.dinnerplanner.android.view;

import java.util.Set;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import android.annotation.SuppressLint;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

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

		TextUnderImageView txtUImageView = new TextUnderImageView(
				view.getContext());
		txtUImageView.addDishImageButton(dish, txtUImageView.convertDpToPx(view.getContext(), 100),
				txtUImageView.convertDpToPx(view.getContext(), 100));
		txtUImageView.addTextView(dish.getName());
		LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		param.rightMargin = txtUImageView.convertDpToPx(view.getContext(), 10);
		param.leftMargin = txtUImageView.convertDpToPx(view.getContext(), 10);
		txtUImageView.setLayoutParams(param);
		linearLayout.addView(txtUImageView);
	}

}
