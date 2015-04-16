package com.example.dublintravel.test.ui_elements;

import com.example.dublintravel.R;
import com.example.dublintravel.RtpiDashboardActivity;
import android.test.ActivityInstrumentationTestCase2;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class RtpiDashboardActivityTest extends ActivityInstrumentationTestCase2<RtpiDashboardActivity>{
	
	private RtpiDashboardActivity activity;
	private ImageView dublinBusImageView;
	private ImageView irishRailImageView;
	private ImageView busEireannImageView;
	private ImageView luasImageView;
	private ImageView liveMapImageView;
	private TextView stopTextView;
	private TextView tableHeader1;
	private TextView tableHeader2;
	private TextView tableHeader3;
	private ListView stopInfosListView;
	private Helper helper;
	private WebView twitterFeed;
	private WebView chartVis;
	
	public RtpiDashboardActivityTest(){
		super(RtpiDashboardActivity.class);
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
		stopTextView = (TextView) activity.findViewById(R.id.stop);
		tableHeader1 = (TextView) activity.findViewById(R.id.tableHeader1);
		tableHeader2 = (TextView) activity.findViewById(R.id.tableHeader2);
		tableHeader3 = (TextView) activity.findViewById(R.id.tableHeader3);
		stopInfosListView = (ListView) activity.findViewById(R.id.stopInfoListView);
		twitterFeed = (WebView) activity.findViewById(R.id.twitterFeed);
		chartVis = (WebView) activity.findViewById(R.id.webView1);
	}
	
	public void testNavigationBar(){
		helper.testNavigationBar(dublinBusImageView, irishRailImageView, luasImageView, busEireannImageView, liveMapImageView);
	}
	
	public void testStopView(){
		helper.testTextView(stopTextView, activity.getString(R.string.stop_id_hint));
	}
	
	public void testStopInfoTable(){
		helper.testTextView(tableHeader1, activity.getString(R.string.route_header));
		helper.testTextView(tableHeader2, activity.getString(R.string.destination_header));
		helper.testTextView(tableHeader3, activity.getString(R.string.duetime_header));
		helper.testVisibility(stopInfosListView);
	}
	
	public void testTwitterPage(){
		helper.testVisibility(twitterFeed);
	}
	
	public void testChartVis(){
		helper.testVisibility(chartVis);
	}
}
