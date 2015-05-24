package com.example.dublintravel.test.MapDashboard;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;
import com.example.dublintravel.MapDashboardActivity;
import com.example.dublintravel.R;
import com.example.dublintravel.test.helper.Helper;

public class MapLegend extends ActivityInstrumentationTestCase2<MapDashboardActivity>{

	private MapDashboardActivity activity;
	private Helper helper;
	
	public MapLegend(){
		super(MapDashboardActivity.class);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		helper = new Helper();
		Intent intent = new Intent(getInstrumentation().getTargetContext(), MapDashboardActivity.class);
		intent.putExtras(helper.createBundle());
		setActivityIntent(intent);
		activity = getActivity();
		getInstrumentation().waitForIdleSync();
	}
	
	public void testMapLegend(){
		TextView dbStopName = (TextView)activity.findViewById(R.id.dublinBusStopName);
		assertTrue(dbStopName.getText().equals("Test Stop"));
		//wait for travel times to load
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {}
		
		//distance
		TextView dbDistance = (TextView)activity.findViewById(R.id.dublinBusStopDistance);
		assertTrue(dbDistance.getText().length() > 0);
		
		//walk time
		TextView dbWalkTime = (TextView)activity.findViewById(R.id.dublinBusStopWalk);
		assertTrue(dbWalkTime.getText().length() > 0);
		
		//cycle time
		TextView dbCycleTime = (TextView)activity.findViewById(R.id.dublinBusStopCycling);
		assertTrue(dbCycleTime.getText().length() > 0);
		
		//driving time
		TextView dbDrivingTime = (TextView)activity.findViewById(R.id.dublinBusStopDriving);
		assertTrue(dbDrivingTime.getText().length() > 0);
	}
}
