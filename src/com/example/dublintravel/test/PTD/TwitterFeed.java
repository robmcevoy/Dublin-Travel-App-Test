package com.example.dublintravel.test.PTD;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import com.example.dublintravel.BusEireannOperator;
import com.example.dublintravel.DublinBusOperator;
import com.example.dublintravel.IrishRailOperator;
import com.example.dublintravel.LuasOperator;
import com.example.dublintravel.PTDActivity;
import com.example.dublintravel.test.helper.Helper;
import com.robotium.solo.Solo;
import com.robotium.solo.WebElement;

public class TwitterFeed extends ActivityInstrumentationTestCase2<PTDActivity>{
	
	private PTDActivity activity;
	private Helper helper;
	private Solo solo;
	private final int MAX_LOAD_TIME = 5000;
	
	public TwitterFeed(){
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
	
	public void testTwitterFeed(){
		if (!helper.isLargeScreen(activity)) {
			solo.scrollToSide(Solo.RIGHT);
			solo.scrollToSide(Solo.RIGHT);
			solo.scrollToSide(Solo.RIGHT);
		}
		irishRail();
		busEireann();
		luas();
		dublinBus();
	}
	
	private void searchTwitterFeed(String opcode){
		try {
			Thread.sleep(MAX_LOAD_TIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		boolean found = false;
		for(WebElement w: solo.getWebElements()){
			if(w.getClassName().equals(opcode)){
				found = true;
			}
		}
		assertTrue(found);
	}
	
	private void irishRail(){
		searchTwitterFeed(new IrishRailOperator().getOperatorCode());
	}
	
	private void busEireann(){
		solo.clickOnImage(0);
		searchTwitterFeed(new BusEireannOperator().getOperatorCode());
	}
	
	private void luas(){
		solo.clickOnImage(1);
		searchTwitterFeed(new LuasOperator().getOperatorCode());
	}
	
	private void dublinBus(){
		solo.clickOnImage(4);
		searchTwitterFeed(new DublinBusOperator().getOperatorCode());
	}	
}