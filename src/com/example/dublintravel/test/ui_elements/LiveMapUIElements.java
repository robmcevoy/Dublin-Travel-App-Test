package com.example.dublintravel.test.ui_elements;

import com.example.dublintravel.LiveMapActivity;
import com.example.dublintravel.R;
import com.google.android.gms.maps.MapFragment;
import android.test.ActivityInstrumentationTestCase2;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

public class LiveMapUIElements extends ActivityInstrumentationTestCase2<LiveMapActivity>{
	
	private LiveMapActivity activity;
	private Helper helper;
	private ImageView dublinBusImageView;
	private ImageView irishRailImageView;
	private ImageView busEireannImageView;
	private ImageView liveMapImageView;
	private ImageView luasImageView;
	private MapFragment mapFragment;
	private ImageView dublinBusMarker;
	private ImageView irishRailMarker;
	private ImageView busEireannMarker;
	private ImageView luasMarker;
	private WebView twitterFeed;
	private TextView dublinBusStop;
	private TextView luasStop;
	private TextView busEireannStop;
	private TextView irishRailStop;
	private TextView dublinBusDriving;
	private TextView luasDriving;
	private TextView busEireannDriving;
	private TextView irishRailDriving;
	private TextView dublinBusWalking;
	private TextView luasWalking;
	private TextView busEireannWalking;
	private TextView irishRailWalking;
	private TextView dublinBusCycling;
	private TextView luasCycling;
	private TextView busEireannCycling;
	private TextView irishRailCycling;
	
	public LiveMapUIElements(){
		super(LiveMapActivity.class);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		activity = getActivity();
		helper = new Helper();
		dublinBusImageView = (ImageView) activity.findViewById(R.id.dublinBusLogo);
		luasImageView = (ImageView) activity.findViewById(R.id.luasLogo);
		busEireannImageView = (ImageView) activity.findViewById(R.id.busEireannLogo);
		irishRailImageView = (ImageView) activity.findViewById(R.id.irishRailLogo);
		liveMapImageView = (ImageView) activity.findViewById(R.id.liveMapLogo);
		mapFragment = (MapFragment) activity.getFragmentManager().findFragmentById(R.id.map);
		dublinBusMarker = (ImageView) activity.findViewById(R.id.dublinBusMarker);
		irishRailMarker  = (ImageView) activity.findViewById(R.id.irishRailMarker);
		busEireannMarker =  (ImageView) activity.findViewById(R.id.busEireannMarker);
		luasMarker = (ImageView) activity.findViewById(R.id.luasMarker);
		twitterFeed = (WebView) activity.findViewById(R.id.twitterFeed);
		dublinBusStop = (TextView) activity.findViewById(R.id.dublinBusStopName);
		luasStop =  (TextView) activity.findViewById(R.id.luasStopName);
		busEireannStop = (TextView) activity.findViewById(R.id.busEireannStopName);
		irishRailStop  = (TextView) activity.findViewById(R.id.irishRailStopName);
		dublinBusDriving = (TextView) activity.findViewById(R.id.dublinBusStopDriving);
		luasDriving =  (TextView) activity.findViewById(R.id.luasStopDriving);
		busEireannDriving = (TextView) activity.findViewById(R.id.busEireannStopDriving);
		irishRailDriving  = (TextView) activity.findViewById(R.id.irishRailStopDriving);
		dublinBusWalking = (TextView) activity.findViewById(R.id.dublinBusStopWalk);
		luasWalking =  (TextView) activity.findViewById(R.id.luasStopWalk);
		busEireannWalking = (TextView) activity.findViewById(R.id.busEireannStopWalk);
		irishRailWalking  = (TextView) activity.findViewById(R.id.irishRailStopWalk);
		dublinBusCycling = (TextView) activity.findViewById(R.id.dublinBusStopCycling);
		luasCycling =  (TextView) activity.findViewById(R.id.luasStopCycling);
		busEireannCycling = (TextView) activity.findViewById(R.id.busEireannStopCycling);
		irishRailCycling  = (TextView) activity.findViewById(R.id.irishRailStopCycling);
	}
	
	public void testNavigationBar(){
		helper.testNavigationBar(dublinBusImageView, irishRailImageView, luasImageView, busEireannImageView, liveMapImageView);
	}
	
	public void testLiveMap(){
		assertTrue(mapFragment.isVisible());
	}
	
	public void testMapLegend(){
		helper.testVisibility(dublinBusMarker);
		helper.testVisibility(irishRailMarker);
		helper.testVisibility(luasMarker);
		helper.testVisibility(busEireannMarker);
		helper.testTextView(busEireannStop, "");
		helper.testTextView(dublinBusStop, "");
		helper.testTextView(irishRailStop, "");
		helper.testTextView(luasStop, "");
		helper.testTextView(busEireannDriving, "");
		helper.testTextView(dublinBusDriving, "");
		helper.testTextView(irishRailDriving, "");
		helper.testTextView(luasDriving, "");
		helper.testTextView(busEireannWalking, "");
		helper.testTextView(dublinBusWalking, "");
		helper.testTextView(irishRailWalking, "");
		helper.testTextView(luasWalking, "");
		helper.testTextView(busEireannCycling, "");
		helper.testTextView(dublinBusCycling, "");
		helper.testTextView(irishRailCycling, "");
		helper.testTextView(luasCycling, "");
	}
	
	public void testTwitterPage(){
		helper.testVisibility(twitterFeed);
	}
}
