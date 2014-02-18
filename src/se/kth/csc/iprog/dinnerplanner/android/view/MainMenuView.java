package se.kth.csc.iprog.dinnerplanner.android.view;

import java.util.Set;

import se.kth.csc.iprog.dinnerplanner.android.MainMenuActivity;
import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.android.classes.DishImageButton;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import android.annotation.SuppressLint;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

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

	@SuppressLint("NewApi")
	public void addDishToScrollView(LinearLayout linearLayout, Dish dish) {
		//Create imagebutton
		DishImageButton imageButton = new DishImageButton(view.getContext(),
				dish);
		int id = view.getResources().getIdentifier(
				dish.getImage().split("\\.")[0], "drawable",
				this.view.getContext().getPackageName());
		imageButton.setImageResource(id);
		int a = View.generateViewId();
		imageButton.setId(a);
		
		//Create textview
		TextView textView = new TextView(view.getContext());
		textView.setText(dish.getName());
		
		//Create a relative layout
		RelativeLayout rel = new RelativeLayout(view.getContext());
		rel.addView(imageButton);
		rel.addView(textView);
		
		LinearLayout.LayoutParams relLay = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		relLay.rightMargin = convertDpToPx(10);
		relLay.leftMargin = convertDpToPx(10);
		rel.setLayoutParams(relLay);
		
		//Align text under imagebutton
		RelativeLayout.LayoutParams relParams =  new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		relParams.addRule(RelativeLayout.BELOW, a);
		textView.setLayoutParams(relParams);
		rel.setGravity(Gravity.CENTER);
		
		
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
				convertDpToPx(100), convertDpToPx(100));
		imageButton.setLayoutParams(params);
		
		//Add the image_under_button-view to the linearlayout
		linearLayout.addView(rel);
	}

	private int convertDpToPx(int dp) {
		float scale = view.getContext().getResources().getDisplayMetrics().density;
		return (int) (dp * scale + 0.5f);
	}

}
