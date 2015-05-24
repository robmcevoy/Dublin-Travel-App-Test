package com.example.dublintravel.test.helper;


import com.example.dublintravel.BusEireannOperator;
import com.example.dublintravel.DublinBusOperator;
import com.example.dublintravel.IrishRailOperator;
import com.example.dublintravel.MapDashboardActivity;
import com.example.dublintravel.LuasOperator;
import com.example.dublintravel.NavigationBar;
import com.example.dublintravel.Operator;
import com.example.dublintravel.R;
import com.example.dublintravel.PTDActivity;
import junit.framework.TestCase;
import android.app.Activity;
import android.app.Instrumentation.ActivityMonitor;
import android.content.res.Configuration;
import android.os.Bundle;
import android.test.ActivityTestCase;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Helper extends TestCase {
	
	private int MAX_WAIT_TIME = 5000;
	private int CLICK_SLEEP = 100;
	
	public void testButtonClickActivityLaunch(ActivityTestCase instrument, Activity current, String expectedName, View view){
		ActivityMonitor activityMonitor = instrument.getInstrumentation().addMonitor(expectedName, null, false);
		clickButton(view, current);
		Activity launchedActivity = instrument.getInstrumentation().waitForMonitorWithTimeout(activityMonitor, MAX_WAIT_TIME);
		assertNotNull(launchedActivity);
		instrument.getInstrumentation().removeMonitor(activityMonitor);
		launchedActivity.finish();
	}
	
	public void testLuasButtonClick(Activity activity, ActivityTestCase instrument){
		String expected = PTDActivity.class.getName();
		final ImageView luasBtn = (ImageView) activity .findViewById(R.id.luasLogo);
		testButtonClickActivityLaunch(instrument, activity, expected, luasBtn);
	}
	
	public void testDublinBusButtonClick(Activity activity, ActivityTestCase instrument){
		String expected = PTDActivity.class.getName();
		final ImageView dublinBusBtn = (ImageView) activity .findViewById(R.id.dublinBusLogo);
		testButtonClickActivityLaunch(instrument, activity, expected, dublinBusBtn);
	}
	
	public void testIrishRailButtonClick(Activity activity, ActivityTestCase instrument){
		String expected = PTDActivity.class.getName();
		final ImageView irishRailBtn = (ImageView) activity .findViewById(R.id.irishRailLogo);
		testButtonClickActivityLaunch(instrument, activity, expected, irishRailBtn);
	}
	
	public void testBusEireannButtonClick(Activity activity, ActivityTestCase instrument){
		String expected = PTDActivity.class.getName();
		final ImageView busEireannBtn = (ImageView) activity .findViewById(R.id.busEireannLogo);
		testButtonClickActivityLaunch(instrument, activity, expected, busEireannBtn);
	}
	
	public void testLiveMapButtonClick(Activity activity, ActivityTestCase instrument){
		String expected = MapDashboardActivity.class.getName();
		final ImageView busEireannBtn = (ImageView) activity .findViewById(R.id.liveMapLogo);
		testButtonClickActivityLaunch(instrument, activity, expected, busEireannBtn);
	}
	
	public void testNavigationBar(ImageView dublinBusImageView, ImageView irishRailImageView,
		ImageView luasImageView, ImageView busEireannImageView, ImageView liveMapView){
		testVisibility(dublinBusImageView);
		testVisibility(luasImageView);
		testVisibility(busEireannImageView);
		testVisibility(irishRailImageView);
		testVisibility(liveMapView);
		testButton(dublinBusImageView);
		testButton(luasImageView);
		testButton(busEireannImageView);
		testButton(irishRailImageView);
		testButton(liveMapView);
	}

	public void testTextView(final TextView textView, final String expected){
		final String actual = textView.getText().toString();
		assertEquals(expected, actual);
		testVisibility(textView);
	}

	public void testVisibility(View view){
		assertTrue(View.VISIBLE == view.getVisibility());
	}

	public void testButton(View view){
		assertTrue(view.isClickable());
		testVisibility(view);
	}
	
	public void clickButton(final View view, Activity current){
		current.runOnUiThread(new Runnable() {
		    public void run() {
		    	view.performClick();
		    }
		  });
		try {
			Thread.sleep(CLICK_SLEEP);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Bundle createBundle(){
		Operator[] operators = new Operator[4];
		DublinBusOperator dbOp = new DublinBusOperator();
		operators[dbOp.getIndex()] = dbOp;
		IrishRailOperator irOp = new IrishRailOperator();
		irOp.activate();
		operators[irOp.getIndex()] = irOp;
		BusEireannOperator beOp = new BusEireannOperator();
		operators[beOp.getIndex()] = beOp;
		LuasOperator luOp = new LuasOperator();
		operators[luOp.getIndex()] = luOp;
		Bundle bundle = new Bundle();  
    	bundle.putSerializable(NavigationBar.getOperatorsKey(), operators);
    	return bundle;
	}
	
	public boolean isLargeScreen(Activity activity){
		return (activity.getResources().getConfiguration().screenLayout & 
			    Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_LARGE;
	}

}