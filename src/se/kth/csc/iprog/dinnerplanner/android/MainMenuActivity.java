package se.kth.csc.iprog.dinnerplanner.android;

import se.kth.csc.iprog.dinnerplanner.android.view.ExampleView;
import android.app.Activity;
import android.os.Bundle;

public class MainMenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Default call to load previous state
    	super.onCreate(savedInstanceState);
    	
    	// Set the view for the main activity screen
    	// it must come before any call to findViewById method
        setContentView(R.layout.main_menu_view);
        
    	// Creating the view class instance
    	ExampleView mainView = new ExampleView(findViewById(R.id.main_menu_view_id));

    }

}
