package se.kth.csc.iprog.dinnerplanner.android;

import se.kth.csc.iprog.dinnerplanner.android.view.ExampleView;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Default call to load previous state
    	super.onCreate(savedInstanceState);
    	
    	// Set the view for the main activity screen
    	// it must come before any call to findViewById method
        setContentView(R.layout.activity_main);
        
    	// Creating the view class instance
    	ExampleView mainView = new ExampleView(findViewById(R.id.this_is_example_view_id));
    	
    	Button next = (Button)this.findViewById(R.id.chooseDish);
        next.setOnClickListener(new OnClickListener() {
          //@Override
          public void onClick(View v) {
        	  Intent myIntent = new Intent(v.getContext(), MainMenuActivity.class);
              startActivityForResult(myIntent, 0);
          }
        });
    }

}
