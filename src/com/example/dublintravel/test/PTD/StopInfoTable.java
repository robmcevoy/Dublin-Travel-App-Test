package com.example.dublintravel.test.PTD;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.ListView;
import com.example.dublintravel.R;
import com.example.dublintravel.PTDActivity;
import com.example.dublintravel.StopInfo;
import com.example.dublintravel.StopInfoAdapter;
import com.example.dublintravel.test.helper.Helper;
import com.robotium.solo.Solo;

public class StopInfoTable extends ActivityInstrumentationTestCase2<PTDActivity>{
	
	private PTDActivity activity;
	private Helper helper;
	private Solo solo;
	private String TEST_STOP="Connolly";
	
	public StopInfoTable(){
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
	
	public void testStopInfoTable(){
		// pick a stop
		solo.clickOnText(activity.getString(R.string.stop_id_hint));
		solo.waitForDialogToOpen();
		solo.clickOnText(TEST_STOP);
		solo.waitForDialogToClose();
		assertTrue(solo.waitForText(TEST_STOP));
		ListView lv = (ListView) solo.getView(R.id.stopInfoListView);
		StopInfoAdapter tmpAdapter = (StopInfoAdapter) lv.getAdapter();
		assertTrue(!tmpAdapter.isEmpty());
		
		if(tmpAdapter.getCount() == 0){
			assertTrue(!tmpAdapter.getItem(0).getDestination().isEmpty());
		}
		else{
			for(int i=0; i<tmpAdapter.getCount(); i++){
				StopInfo s = tmpAdapter.getItem(i);
				assertTrue(!s.getDestination().isEmpty());
				assertTrue(!s.getDueTime().isEmpty());
				assertTrue(!s.getRouteId().isEmpty());
			}
		}
	}
}
