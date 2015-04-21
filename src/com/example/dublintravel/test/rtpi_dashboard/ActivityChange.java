package com.example.dublintravel.test.rtpi_dashboard;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import com.example.dublintravel.HomepageActivity;
import com.example.dublintravel.LiveMapActivity;
import com.example.dublintravel.RtpiDashboardActivity;
import com.example.dublintravel.test.helper.Helper;
import com.robotium.solo.Solo;

public class ActivityChange extends ActivityInstrumentationTestCase2<RtpiDashboardActivity>{
	
	private RtpiDashboardActivity activity;
	private Helper helper;
	private Solo solo;
	
	public ActivityChange(){
		super(RtpiDashboardActivity.class);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		helper = new Helper();
		Intent intent = new Intent(getInstrumentation().getTargetContext(), RtpiDashboardActivity.class);
		intent.putExtras(helper.createBundle());
		setActivityIntent(intent);
		activity = getActivity();
		solo = new Solo(getInstrumentation(), activity);
	}
	
	public void testActivityChange(){
		
		// launch Live Map Dashboard Activity
		solo.clickOnImage(2);
		assertTrue(solo.waitForActivity(LiveMapActivity.class));
		
		// launch Homepage activity
		activity = getActivity();
		solo.goBack();
		assertTrue(solo.waitForActivity(HomepageActivity.class));
	}
}
