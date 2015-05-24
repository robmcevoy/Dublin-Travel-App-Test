package com.example.dublintravel.test.MapDashboard;

import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import com.example.dublintravel.MapDashboardActivity;
import com.example.dublintravel.R;
import com.google.android.gms.maps.MapFragment;

public class Map extends ActivityInstrumentationTestCase2<MapDashboardActivity>{

	private MapDashboardActivity activity;
	
	public Map(){
		super(MapDashboardActivity.class);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		activity = getActivity();
		getInstrumentation().waitForIdleSync();
	}
	
	@UiThreadTest
	public void testMap(){
		MapFragment fragment = (MapFragment)activity.getFragmentManager().findFragmentById(R.id.map);
		assertTrue(fragment.isVisible());
	}

}
