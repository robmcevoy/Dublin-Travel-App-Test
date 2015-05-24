package com.example.dublintravel.test.PTD;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import com.example.dublintravel.HomepageActivity;
import com.example.dublintravel.MapDashboardActivity;
import com.example.dublintravel.PTDActivity;
import com.example.dublintravel.test.helper.Helper;
import com.robotium.solo.Solo;

public class ActivityChange extends ActivityInstrumentationTestCase2<PTDActivity>{
	
	private PTDActivity activity;
	private Helper helper;
	private Solo solo;
	
	public ActivityChange(){
		super(PTDActivity.class);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		helper = new Helper();
		Intent intent = new Intent(getInstrumentation().getTargetContext(), PTDActivity.class);
		intent.putExtras(helper.createBundle());
		setActivityIntent(intent);
		activity = getActivity();
		solo = new Solo(getInstrumentation(), activity);
	}
	
	public void testActivityChange(){
		
		// launch Live Map Dashboard Activity
		solo.clickOnImage(2);
		assertTrue(solo.waitForActivity(MapDashboardActivity.class));
		
		// launch Homepage activity
		activity = getActivity();
		solo.goBack();
		assertTrue(solo.waitForActivity(HomepageActivity.class));
	}
}
