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

public class PopUpMenuView {

    View view;
    Dish dish;
    DinnerModel model;

    public PopUpMenuView(View view, Dish dish, DinnerModel model) {

        // store in the class the reference to the Android View
        this.view = view;
        this.dish = dish;
        this.model = model;
        
        //set name of Dish
        TextView nameOfDish = (TextView) view.findViewById(R.id.nameOfDish);
        nameOfDish.setText(dish.getName());
        
        //set total cost of dish (according to the number of participants)
        TextView dishCost = (TextView) view.findViewById(R.id.dishCost);
        dishCost.setText("" + dish.costOfDish()*model.getNumberOfGuests() + "kr");
        
        //set cost of dish (w. one participant)
        TextView dishCostPerPerson = (TextView) view.findViewById(R.id.dishCostPerPerson);  
        dishCostPerPerson.setText("(" + dish.costOfDish() + "kr / Person)");
    }

}
