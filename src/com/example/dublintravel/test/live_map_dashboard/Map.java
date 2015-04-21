package com.example.dublintravel.test.live_map_dashboard;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import com.example.dublintravel.LiveMapActivity;
import com.example.dublintravel.R;
import com.google.android.gms.maps.MapFragment;

public class Map extends ActivityInstrumentationTestCase2<LiveMapActivity>{

	private LiveMapActivity activity;
	
	public Map(){
		super(LiveMapActivity.class);
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
