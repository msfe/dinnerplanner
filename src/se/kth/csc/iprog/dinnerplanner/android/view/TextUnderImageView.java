package se.kth.csc.iprog.dinnerplanner.android.view;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TextUnderImageView extends RelativeLayout{
	private ImageButton imageButton;
	private TextView textView;
	
	public TextUnderImageView(Context context) {
		super(context);
		
		textView = new TextView(context);
		imageButton = new ImageButton(context);
	
		getLayoutParams().width = LayoutParams.WRAP_CONTENT;
		getLayoutParams().height = LayoutParams.WRAP_CONTENT;
		setGravity(Gravity.CENTER);
		
	}
	
	
	
	
}
