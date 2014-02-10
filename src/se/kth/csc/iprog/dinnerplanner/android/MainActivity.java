package se.kth.csc.iprog.dinnerplanner.android;

import se.kth.csc.iprog.dinnerplanner.android.view.StartView;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	
	Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Default call to load previous state
    	super.onCreate(savedInstanceState);
    	
    	// Set the view for the main activity screen
    	// it must come before any call to findViewById method
        setContentView(R.layout.start_view);
        
    	// Creating the view class instance
    	StartView startView = new StartView(findViewById(R.id.startViewID));	
    	
        next = (Button)this.findViewById(R.id.goToMenuButton);
        this.next.setOnClickListener(new OnClickListener() {
          //@Override
          public void onClick(View v) {
        	  Intent myIntent = new Intent(v.getContext(), MainMenuActivity.class);
              startActivityForResult(myIntent, 0);
          }
        });
    	
    }
}
