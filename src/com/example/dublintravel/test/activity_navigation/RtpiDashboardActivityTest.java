package com.example.dublintravel.test.activity_navigation;

import com.example.dublintravel.RtpiDashboardActivity;
import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;

public class RtpiDashboardActivityTest extends ActivityInstrumentationTestCase2<RtpiDashboardActivity>{
	
	private Activity activity;
	private Helper helper;
	
	public RtpiDashboardActivityTest(){
		super(RtpiDashboardActivity.class);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		helper = new Helper();
	}
	
	public void testLiveMapButtonClick(){
		activity = getActivity();
		helper.testLiveMapButtonClick(activity, this);
	}
}
