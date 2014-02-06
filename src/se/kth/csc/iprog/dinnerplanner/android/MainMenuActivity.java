package se.kth.csc.iprog.dinnerplanner.android;

import se.kth.csc.iprog.dinnerplanner.android.view.MainMenuView;
import android.app.Activity;
import android.os.Bundle;

public class MainMenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Default call to load previous state
    	super.onCreate(savedInstanceState);
    	
    	// Set the view for the main activity screen
    	// it must come before any call to findViewById method
        setContentView(R.layout.choose_menu_top_view);
        setContentView(R.layout.choose_menu_main_screen);
        setContentView(R.layout.choose_menu_choose_dish);
        
    	// Creating the view class instance
    	MainMenuView mainView = new MainMenuView(findViewById(R.id.this_is_chooseMenu_mainScreen));
    	

    }

}
