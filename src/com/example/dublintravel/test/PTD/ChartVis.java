package com.example.dublintravel.test.PTD;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.webkit.WebView;
import com.example.dublintravel.R;
import com.example.dublintravel.PTDActivity;
import com.example.dublintravel.test.helper.Helper;
import com.robotium.solo.Solo;

public class ChartVis extends ActivityInstrumentationTestCase2<PTDActivity>{
	
	private PTDActivity activity;
	private Helper helper;
	private Solo solo;
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
		solo.clickOnText(activity.getString(R.string.stop_id_hint));
		solo.waitForDialogToOpen();
		solo.clickOnText(TEST_STOP);
		solo.waitForDialogToClose();
		assertTrue(solo.waitForText(TEST_STOP));
		if (!helper.isLargeScreen(activity)) {
			solo.scrollToSide(Solo.RIGHT);
		}
		// is chart visible?
		WebView chart = (WebView) activity.findViewById(R.id.webView1);
		assertTrue(chart.isShown());
	}

}
