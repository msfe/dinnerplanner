package se.kth.csc.iprog.dinnerplanner.android.view;

import java.util.Set;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainMenuView {

    View view;
    DinnerModel model;

    public MainMenuView(View view, DinnerModel model) {

        // store in the class the reference to the Android View
        this.view = view;
        this.model = model;

        //Add Starters to view
        LinearLayout ll = (LinearLayout) view.findViewById(R.id.startersScrollLinear);
        Set<Dish> starters = model.getDishesOfType(Dish.STARTER);

        for(Dish starter : starters){

            TextView tv = new TextView(view.getContext());
            tv.setPadding(20, 10, 20, 10);
            tv.setTextSize(30);
            tv.setText(starter.getName());
            ll.addView(tv);

        }

        //Add Main Courses to view
        LinearLayout ll2 = (LinearLayout) view.findViewById(R.id.mainsScrollLinear);
        Set<Dish> mains = model.getDishesOfType(Dish.MAIN);

        for(Dish main : mains){

            TextView tv2 = new TextView(view.getContext());
            tv2.setPadding(20, 10, 20, 10);
            tv2.setTextSize(30);
            tv2.setText(main.getName());
            ll2.addView(tv2);

        }

        //Add Desserts to view
        LinearLayout ll3 = (LinearLayout) view.findViewById(R.id.dessertsScrollLinear);
        Set<Dish> desserts = model.getDishesOfType(Dish.DESERT);
        
        for(Dish dessert : desserts){

            TextView tv3 = new TextView(view.getContext());
            tv3.setPadding(20, 10, 20, 10);
            tv3.setTextSize(30);
            tv3.setText(dessert.getName());
            ll3.addView(tv3);

        }



        //		TextView mainMenu = (TextView) view.findViewById(R.id.this_is_chooseMenu_mainScreen);
        //example.setText("Hello world");

        // Setup the rest of the view layout
    }

}
