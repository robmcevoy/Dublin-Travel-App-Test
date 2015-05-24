package com.example.dublintravel.test.PTD;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import com.example.dublintravel.PTDActivity;
import com.example.dublintravel.R;
import com.example.dublintravel.test.helper.Helper;
import com.robotium.solo.Solo;

public class ChooseStopDialog extends ActivityInstrumentationTestCase2<PTDActivity>{
	
	private PTDActivity activity;
	private Helper helper;
	private Solo solo;
	private final String FAVOURITE_STOP = "Adamstown";
	private final String SEARCH_STOP = "Connolly";
	private final String SELECT_STOP = "Bayside";
	
	public ChooseStopDialog(){
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
	
	public void testDialog(){

		// click and wait for dialog to open
		solo.clickOnText(activity.getString(R.string.stop_id_hint));
		assertTrue(solo.waitForDialogToOpen());
		
		favouriteStopTest();
		searchTest();
		selectStopTest();
	}
	
	private void favouriteStopTest(){
		solo.clickOnText(activity.getString(R.string.tab_all_stops));
		solo.clickLongOnText(FAVOURITE_STOP);
		solo.clickOnText(activity.getString(R.string.tab_favourites));
		assertTrue(solo.searchText(FAVOURITE_STOP));
		solo.clickLongOnText(FAVOURITE_STOP);
	}
	
	private void searchTest(){
		for(int i=1; i<SEARCH_STOP.length(); i++){
			solo.clearEditText(0);
			solo.enterText(0, SEARCH_STOP.substring(0, i));
			assertTrue(solo.searchText(SEARCH_STOP));
		}
	}
	
	private void selectStopTest(){
		solo.clickOnText(activity.getString(R.string.tab_all_stops));
		solo.clickOnText(SELECT_STOP);
		assertTrue(solo.waitForDialogToClose());
		assertTrue(solo.searchText(SELECT_STOP));
	}
}
