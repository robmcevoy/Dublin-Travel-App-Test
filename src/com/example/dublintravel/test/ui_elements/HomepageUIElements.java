package com.example.dublintravel.test.ui_elements;

import com.example.dublintravel.HomepageActivity;
import com.example.dublintravel.R;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.ImageView;
import android.widget.TextView;

public class HomepageUIElements extends ActivityInstrumentationTestCase2<HomepageActivity>{
	
	private HomepageActivity activity;
	private TextView appNameTextView;
	private TextView subHeadingTextView;
	private ImageView dublinBusImageView;
	private ImageView irishRailImageView;
	private ImageView busEireannImageView;
	private ImageView liveMapImageView;
	private ImageView luasImageView;
	private ImageView userManualButton;
	private Helper helper; 
	
	public HomepageUIElements() {
		super(HomepageActivity.class);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		this.activity = getActivity();
		helper = new Helper();
		appNameTextView = (TextView) activity.findViewById(R.id.homepageHeading);
		subHeadingTextView = (TextView) activity.findViewById(R.id.homepageSubheading);
		dublinBusImageView = (ImageView) activity.findViewById(R.id.dublinBusLogo);
		luasImageView = (ImageView) activity.findViewById(R.id.luasLogo);
		busEireannImageView = (ImageView) activity.findViewById(R.id.busEireannLogo);
		irishRailImageView = (ImageView) activity.findViewById(R.id.irishRailLogo);
		liveMapImageView = (ImageView) activity.findViewById(R.id.liveMapLogo);
		userManualButton = (ImageView) activity.findViewById(R.id.userManual);
	}
	
	public void testAppNameTextView(){
	    helper.testTextView(appNameTextView, activity.getString(R.string.app_name));
	}
	
	public void testHomepageSubheadng(){
	    helper.testTextView(subHeadingTextView, activity.getString(R.string.homepage_subheading));
	}
	
	public void testNavigationBar(){
		helper.testNavigationBar(dublinBusImageView, irishRailImageView, luasImageView, busEireannImageView, liveMapImageView);
	}
	
	public void testUserManualButton(){
		helper.testButton(userManualButton);
	}

}
