package com.example.dublintravel.test.activity_navigation;

import com.example.dublintravel.LiveMapActivity;
import com.example.dublintravel.R;
import com.example.dublintravel.RtpiDashboardActivity;
import com.example.dublintravel.UserManualActivity;

import junit.framework.TestCase;
import android.app.Activity;
import android.app.Instrumentation.ActivityMonitor;
import android.test.ActivityTestCase;
import android.view.View;
import android.widget.ImageView;

public class Helper extends TestCase {
	
	private int MAX_WAIT_TIME = 5000;
	
	private void testButtonClickActivityLaunch(ActivityTestCase instrument, Activity current, String expectedName, final View view){
		ActivityMonitor activityMonitor = instrument.getInstrumentation().addMonitor(expectedName, null, false);
		current.runOnUiThread(new Runnable() {
		    public void run() {
		    	view.performClick();
		    }
		  });
		Activity launchedActivity = instrument.getInstrumentation().waitForMonitorWithTimeout(activityMonitor, MAX_WAIT_TIME);
		assertNotNull(launchedActivity);
		instrument.getInstrumentation().removeMonitor(activityMonitor);
		launchedActivity.finish();
	}
	
	public void testLuasButtonClick(Activity activity, ActivityTestCase instrument){
		String expected = RtpiDashboardActivity.class.getName();
		final ImageView luasBtn = (ImageView) activity .findViewById(R.id.luasLogo);
		testButtonClickActivityLaunch(instrument, activity, expected, luasBtn);
	}
	
	public void testDublinBusButtonClick(Activity activity, ActivityTestCase instrument){
		String expected = RtpiDashboardActivity.class.getName();
		final ImageView dublinBusBtn = (ImageView) activity .findViewById(R.id.dublinBusLogo);
		testButtonClickActivityLaunch(instrument, activity, expected, dublinBusBtn);
	}
	
	public void testIrishRailButtonClick(Activity activity, ActivityTestCase instrument){
		String expected = RtpiDashboardActivity.class.getName();
		final ImageView irishRailBtn = (ImageView) activity .findViewById(R.id.irishRailLogo);
		testButtonClickActivityLaunch(instrument, activity, expected, irishRailBtn);
	}
	
	public void testBusEireannButtonClick(Activity activity, ActivityTestCase instrument){
		String expected = RtpiDashboardActivity.class.getName();
		final ImageView busEireannBtn = (ImageView) activity .findViewById(R.id.busEireannLogo);
		testButtonClickActivityLaunch(instrument, activity, expected, busEireannBtn);
	}
	
	public void testLiveMapButtonClick(Activity activity, ActivityTestCase instrument){
		String expected = LiveMapActivity.class.getName();
		final ImageView busEireannBtn = (ImageView) activity .findViewById(R.id.liveMapLogo);
		testButtonClickActivityLaunch(instrument, activity, expected, busEireannBtn);
	}
	
	public void testUserManualBtnClick(Activity activity, ActivityTestCase instrument){
		String expected = UserManualActivity.class.getName();
		final ImageView userManualBtn = (ImageView) activity .findViewById(R.id.userManual);
		testButtonClickActivityLaunch(instrument, activity, expected, userManualBtn);
	}

}