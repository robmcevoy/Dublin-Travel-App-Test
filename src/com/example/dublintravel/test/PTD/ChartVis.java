package com.example.dublintravel.test.PTD;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.webkit.WebView;
import com.example.dublintravel.ChartWebView;
import com.example.dublintravel.R;
import com.example.dublintravel.PTDController;
import com.example.dublintravel.PTDActivity;
import com.example.dublintravel.test.helper.Helper;
import com.robotium.solo.Solo;
import org.json.JSONObject;

public class ChartVis extends ActivityInstrumentationTestCase2<PTDActivity>{
	
	private PTDActivity activity;
	private Helper helper;
	private Solo solo;
	private final int MAX_LOAD_TIME = 5000;
	private String TEST_STOP="Connolly";
	
	public ChartVis(){
		super(PTDActivity.class);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		helper = new Helper();
		Intent intent = new Intent(getInstrumentation().getTargetContext(), PTDActivity.class);
		intent.putExtras(helper.createBundle());
		setActivityIntent(intent);
		activity = getActivity();
		solo = new Solo(getInstrumentation(), activity);
	}
	
	public void testChart(){
		// pick stop
		/*
		solo.clickOnText(activity.getString(R.string.stop_id_hint));
		solo.waitForDialogToOpen();
		solo.clickOnText(TEST_STOP);
		solo.waitForDialogToClose();
		assertTrue(solo.waitForText(TEST_STOP));
		if (!helper.isLargeScreen(activity)) {
			solo.scrollToSide(Solo.RIGHT);
		}
		assertTrue(solo.waitForLogMessage("chart ready"));
		RtpiController controller = activity.getController();
		ChartWebView chartWebView = controller.getChartWebView();
		JSONObject testData = chartWebView.getTestData();
		Log.d("CHART_LOG", testData.toString());
		*/
	}

}
