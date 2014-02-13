package se.kth.csc.iprog.dinnerplanner.android.view;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import android.view.View;
import android.view.View.OnClickListener;

public class MainMenuController implements OnClickListener {
    MainMenuView view;
    DinnerModel model;

    
    public MainMenuController(MainMenuView view, DinnerModel model) {
        this.view = view;
        this.model = model;
        
        
        view.frenchToastButton.setOnClickListener(this);
        view.boiledEggsButton.setOnClickListener(this);
        view.meatballsButton.setOnClickListener(this);
        view.chocolateButton.setOnClickListener(this);
        
    }


    @Override
    public void onClick(View v) {
        System.out.println(v.getId());
        if(v == view.frenchToastButton){
            view.showPopUp(0);
        }
        if(v == view.boiledEggsButton){
            view.showPopUp(1);
        }
        if(v == view.meatballsButton){
            view.showPopUp(2);
        }
        if(v == view.chocolateButton){
            view.showPopUp(3);
        }
    }
}

