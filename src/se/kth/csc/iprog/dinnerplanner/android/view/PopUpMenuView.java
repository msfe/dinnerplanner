package se.kth.csc.iprog.dinnerplanner.android.view;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PopUpMenuView{

    private View view;
    private Dish dish;
    private DinnerModel model;
    
    Button choose;
    Button close;

    public PopUpMenuView(View view, Dish dish, DinnerModel model) {
    	
    	choose = (Button) view.findViewById(
				R.id.chooseDish);
    	close = (Button) view.findViewById(R.id.close);

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
        
        //Set the image for the dish
        ImageView image = (ImageView) view.findViewById(R.id.show_the_dish);
        int id = view.getResources().getIdentifier(
				dish.getImage().split("\\.")[0], "drawable",
				this.view.getContext().getPackageName());
		image.setImageResource(id);
        
        //set cost of dish (w. one participant)
        TextView dishCostPerPerson = (TextView) view.findViewById(R.id.dishCostPerPerson);  
        dishCostPerPerson.setText("(" + dish.costOfDish() + "kr / Person)");
    }

	public Dish getDish() {
		return dish;
	}

}
