package se.kth.csc.iprog.dinnerplanner.android.view;

import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.android.classes.DishImageButton;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import android.graphics.Typeface;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class MainMenuView implements Observer {

	View view;
	DinnerModel model;

	LinearLayout starterList;
	LinearLayout mainList;
	LinearLayout desertList;
	Button clearButton;

	public MainMenuView(View view, DinnerModel model) {

		// store in the class the reference to the Android View
		this.view = view;
		this.model = model;
		model.addObserver(this);

		starterList = (LinearLayout) view
				.findViewById(R.id.startersScrollLinear);
		mainList = (LinearLayout) view.findViewById(R.id.mainsScrollLinear);
		desertList = (LinearLayout) view
				.findViewById(R.id.dessertsScrollLinear);
		clearButton = (Button) view.findViewById(R.id.clearButton);

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
		txtUImageView.addDishImageButton(dish,
				txtUImageView.convertDpToPx(view.getContext(), 100),
				txtUImageView.convertDpToPx(view.getContext(), 100));
		txtUImageView.addTextView(dish.getName());
		LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		param.rightMargin = txtUImageView.convertDpToPx(view.getContext(), 10);
		param.leftMargin = txtUImageView.convertDpToPx(view.getContext(), 10);
		txtUImageView.setLayoutParams(param);
		linearLayout.addView(txtUImageView);
	}

	public void setBold(Dish dish) {
		LinearLayout list = null;
		if (dish.getType() == Dish.STARTER) {
			list = starterList;
		} else if (dish.getType() == Dish.MAIN) {
			list = mainList;
		} else { // Dish == DESERT
			list = desertList;
		}

		Set<Dish> fullMenu = model.getFullMenu();
		for (int i = 0; i < list.getChildCount(); i++) {
			if (!(list.getChildAt(i) instanceof TextUnderImageView)) {
				continue;
			}
			TextUnderImageView txtImg = (TextUnderImageView) list.getChildAt(i);
			DishImageButton img = txtImg.getDishImageButton();
			TextView txt = txtImg.getTextView();
			if (dish.equals(img.getDish()) && fullMenu.contains(dish)) {
				txt.setTypeface(null, Typeface.BOLD);
			} else {
				txt.setTypeface(null, Typeface.NORMAL);
			}
		}
	}

	@Override
	public void update(Observable observable, Object data) {
		System.out.println(data);
		if (data instanceof Dish) {
			setBold(((Dish) data));
		}
	}
}
