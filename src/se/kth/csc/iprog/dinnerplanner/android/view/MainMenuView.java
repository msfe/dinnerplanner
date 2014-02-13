package se.kth.csc.iprog.dinnerplanner.android.view;

import java.util.Set;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainMenuView {

    View view;
    DinnerModel model;
    
    ImageButton boiledEggsButton;
    ImageButton frenchToastButton;
    ImageButton meatballsButton;
    ImageButton chocolateButton;

    public MainMenuView(View view, DinnerModel model) {

        // store in the class the reference to the Android View
        this.view = view;
        this.model = model;

        //Add Starters to view
        LinearLayout ll = (LinearLayout) view.findViewById(R.id.startersScrollLinear);
        Set<Dish> starters = model.getDishesOfType(Dish.STARTER);

        int i = 0;
        for(Dish starter : starters){
            if(i == 0) {
               
               boiledEggsButton = new ImageButton(view.getContext());
               //boiledEggsButton.setPadding(50, 10, 50, 10);
               boiledEggsButton.setImageResource(R.drawable.french_toast);
               ll.addView(boiledEggsButton);
               
//               TextView tv = new TextView(view.getContext());
//               tv.setPadding(20, 10, 20, 10);
//               tv.setTextSize(10);
//               tv.setText(starter.getName());
//               ll.addView(tv);
               i++;
            }
            else {
                frenchToastButton = new ImageButton(view.getContext());
                //frenchToastButton.setPadding(50, 10, 50, 10);
                frenchToastButton.setImageResource(R.drawable.boiled_eggs);
                ll.addView(frenchToastButton);
                
//                TextView tv = new TextView(view.getContext());
//                tv.setPadding(50, 65, 50, 10);
//                tv.setTextSize(10);
//                tv.setText(starter.getName());
//                ll.addView(tv);
            }
        }

        //Add Main Courses to view
        LinearLayout ll2 = (LinearLayout) view.findViewById(R.id.mainsScrollLinear);
        Set<Dish> mains = model.getDishesOfType(Dish.MAIN);

        for(Dish main : mains){

            meatballsButton = new ImageButton(view.getContext());
            meatballsButton.setImageResource(R.drawable.meatballs);
            ll2.addView(meatballsButton);
            
//            TextView tv2 = new TextView(view.getContext());
//            tv2.setPadding(20, 10, 20, 10);
//            tv2.setTextSize(30);
//            tv2.setText(main.getName());
//            ll2.addView(tv2);

        }

        //Add Desserts to view
        LinearLayout ll3 = (LinearLayout) view.findViewById(R.id.dessertsScrollLinear);
        Set<Dish> desserts = model.getDishesOfType(Dish.DESERT);
        
        for(Dish dessert : desserts){
            
            chocolateButton = new ImageButton(view.getContext());
            chocolateButton.setImageResource(R.drawable.chocolate);
            ll3.addView(chocolateButton);
            
//            TextView tv3 = new TextView(view.getContext());
//            tv3.setPadding(20, 10, 20, 10);
//            tv3.setTextSize(30);
//            tv3.setText(dessert.getName());
//            ll3.addView(tv3);

        }
    }
    
    public void showPopUp(int choice) {
        if(choice == 0) {
            
        }
        else if(choice == 1) {
            
        }
        else if(choice == 2) {
            
        }
        else if(choice == 3) {
            
        }
    }

}
