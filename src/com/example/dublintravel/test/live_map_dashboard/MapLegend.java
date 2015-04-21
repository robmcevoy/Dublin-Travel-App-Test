package com.example.dublintravel.test.live_map_dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.test.ActivityInstrumentationTestCase2;
import com.example.dublintravel.BundleKeys;
import com.example.dublintravel.BusEireannOperator;
import com.example.dublintravel.DublinBusOperator;
import com.example.dublintravel.IrishRailOperator;
import com.example.dublintravel.LiveMapActivity;
import com.example.dublintravel.LuasOperator;
import com.example.dublintravel.Operator;
import com.example.dublintravel.Stop;
import com.example.dublintravel.test.helper.Helper;
import com.robotium.solo.Solo;

public class MapLegend extends ActivityInstrumentationTestCase2<LiveMapActivity>{

	private LiveMapActivity activity;
	private Solo solo;
	private Helper helper;
	
	public MapLegend(){
		super(LiveMapActivity.class);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		helper = new Helper();
		Intent intent = new Intent(getInstrumentation().getTargetContext(), LiveMapActivity.class);
		intent.putExtras(helper.createBundle());
		setActivityIntent(intent);
		activity = getActivity();
		getInstrumentation().waitForIdleSync();
		solo = new Solo(getInstrumentation(), activity);
	}
	
	public void testMap(){
	}

}
