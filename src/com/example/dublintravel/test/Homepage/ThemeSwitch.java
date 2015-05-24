package com.example.dublintravel.test.Homepage;

import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dublintravel.HomepageActivity;
import com.example.dublintravel.R;
import com.example.dublintravel.test.helper.Helper;
import com.robotium.solo.Solo;

public class ThemeSwitch extends ActivityInstrumentationTestCase2<HomepageActivity>{
	
	private Solo solo;
	private Activity activity;
	private Helper helper;
	private final int DARK_COLOR = Color.parseColor("#333333");
	private final int LIGHT_COLOR = Color.parseColor("#CCCCCC");

	public ThemeSwitch(){
		super(HomepageActivity.class);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		activity = getActivity();
		solo = new Solo(getInstrumentation(), activity);
		helper = new Helper();
	}
	
	public void testInitialTheme(){
		final TextView subHeading = (TextView) activity.findViewById(R.id.homepageSubheading);
		assertEquals(DARK_COLOR,getCurrentBackgroundColor());
		assertEquals(LIGHT_COLOR, subHeading.getCurrentTextColor());
	}
	
	public void testThemeSwitch(){
		ImageView themeToggle = (ImageView) activity .findViewById(R.id.themeToggle);
		helper.clickButton(themeToggle, activity);
		activity = solo.getCurrentActivity();
		assertEquals(LIGHT_COLOR,getCurrentBackgroundColor());
		TextView subHeading = (TextView) activity.findViewById(R.id.homepageSubheading);
		assertEquals(DARK_COLOR, subHeading.getCurrentTextColor());
	}
	
	public void testDoubleSwitch(){
		ImageView themeToggle = (ImageView) activity .findViewById(R.id.themeToggle);
		helper.clickButton(themeToggle, activity);
		activity = solo.getCurrentActivity();
		themeToggle = (ImageView) activity .findViewById(R.id.themeToggle);
		helper.clickButton(themeToggle, activity);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
		activity = solo.getCurrentActivity();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
		assertEquals(DARK_COLOR,getCurrentBackgroundColor());
		TextView subHeading = (TextView) activity.findViewById(R.id.homepageSubheading);
		assertEquals(LIGHT_COLOR, subHeading.getCurrentTextColor());
	}
	
	private int getCurrentBackgroundColor(){
		TypedArray array = activity.getTheme().obtainStyledAttributes(new int[] {  
			    android.R.attr.windowBackground
			}); 
		return array.getColor(0, 0xFF00FF); 
	}	
}
