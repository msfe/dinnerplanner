package se.kth.csc.iprog.dinnerplanner.android.view;

import se.kth.csc.iprog.dinnerplanner.android.classes.DishImageButton;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TextUnderImageView extends RelativeLayout{
	private DishImageButton imageButton;
	private TextView textView;
	
	private Context context;
	private int imageId;
	
	@SuppressLint("NewApi")
	public TextUnderImageView(Context context) {
		super(context);
		this.context = context;
		setGravity(Gravity.CENTER);
		imageId = View.generateViewId();
	}
	
	public void addDishImageButton(Dish dish, int imgHeight, int imgWidth){
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
				imgHeight, imgWidth);
		
		imageButton = new DishImageButton(context,
				dish);
		int imgId = context.getResources().getIdentifier(
				dish.getImage().split("\\.")[0], "drawable",
				context.getPackageName());
		imageButton.setImageResource(imgId);
		imageButton.setId(imageId);
		
		
		imageButton.setLayoutParams(params);
		addView(imageButton);
	}
	
	public void addTextView(String text){
		RelativeLayout.LayoutParams relParams =  new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		
		textView = new TextView(context);
		textView.setText(text);
		
		relParams.addRule(RelativeLayout.BELOW, imageId);
		textView.setLayoutParams(relParams);
		addView(textView);
	}
	
	public TextView getTextView(){
		return textView;
	}
	
	public DishImageButton getDishImageButton(){
		return imageButton;
	}
	
	public int getImageId(){
		return imageId;
	}
	
	public int convertDpToPx(Context context, int dp) {
		float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dp * scale + 0.5f);
	}
}
