package com.example.dublintravel.test.activity_navigation;

import com.example.dublintravel.LiveMapActivity;
import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;

public class LiveMapActivityTest extends ActivityInstrumentationTestCase2<LiveMapActivity>{

	private Activity activity;
	private Helper helper;
	
	public LiveMapActivityTest(){
		super(LiveMapActivity.class);
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
