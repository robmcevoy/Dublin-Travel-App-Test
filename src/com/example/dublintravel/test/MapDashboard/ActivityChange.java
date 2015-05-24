package com.example.dublintravel.test.MapDashboard;

import com.example.dublintravel.MapDashboardActivity;
import com.example.dublintravel.test.helper.Helper;
import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;

public class ActivityChange extends ActivityInstrumentationTestCase2<MapDashboardActivity>{

	private Activity activity;
	private Helper helper;
	
	public ActivityChange(){
		super(MapDashboardActivity.class);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		helper = new Helper();
	}
	
	public void testLuasClick(){
		activity = getActivity();
		helper.testLuasButtonClick(activity, this);
	}
	
	public void testIrishRailClick(){
		activity = getActivity();
		helper.testIrishRailButtonClick(activity, this);
	}
	
	public void testDublinBusClick(){
		activity = getActivity();
		helper.testDublinBusButtonClick(activity, this);
	}
	
	public void testBusEireannClick(){
		activity = getActivity();
		helper.testBusEireannButtonClick(activity, this);
	}
	
	public void liveMapClick(){
		activity = getActivity();
		helper.testLiveMapButtonClick(activity, this);
	}

}
