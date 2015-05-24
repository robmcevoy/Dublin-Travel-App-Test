package com.example.dublintravel.test.Homepage;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.ImageView;

import com.example.dublintravel.HomepageActivity;
import com.example.dublintravel.R;
import com.example.dublintravel.test.helper.Helper;

public class ActivityChange extends ActivityInstrumentationTestCase2<HomepageActivity>{
	
	private Activity activity;
	private Helper helper;
	private static final String USER_MANUAL_FILE= "https://drive.google.com/file/d/0B9Dvsu3ZVoTWZ0xBeTktcEdLSmM/view?usp=sharing";

	public ActivityChange(){
		super(HomepageActivity.class);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		helper = new Helper();
	}
	
	public void testDublinBusClick(){
		activity = getActivity();
		helper.testDublinBusButtonClick(activity, this);
	}
	
	public void testBusEireannClick(){
		activity = getActivity();
		helper.testBusEireannButtonClick(activity, this);
	}
	
	public void testIrishRailClick(){
		activity = getActivity();
		helper.testIrishRailButtonClick(activity, this);
	}
	
	public void testLuasClick(){
		activity = getActivity();
		helper.testLuasButtonClick(activity, this);
	}
	
	public void liveMapClick(){
		activity = getActivity();
		helper.testLiveMapButtonClick(activity, this);
	}
	
	public void userManualClick(){
		final ImageView userManualButton = (ImageView) activity.findViewById(R.id.userManual);
		activity = getActivity();
		helper.testButtonClickActivityLaunch(this, activity, USER_MANUAL_FILE, userManualButton);
	}

}