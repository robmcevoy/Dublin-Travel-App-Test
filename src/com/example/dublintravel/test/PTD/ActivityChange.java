package com.example.dublintravel.test.PTD;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import com.example.dublintravel.PTDActivity;
import com.example.dublintravel.test.helper.Helper;

public class ActivityChange extends ActivityInstrumentationTestCase2<PTDActivity>{
	
	private PTDActivity activity;
	private Helper helper;
	
	public ActivityChange(){
		super(PTDActivity.class);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		helper = new Helper();
		Intent intent = new Intent(getInstrumentation().getTargetContext(), PTDActivity.class);
		intent.putExtras(helper.createBundle());
		setActivityIntent(intent);
		activity = getActivity();
	}
	
	public void liveMapClick(){
		activity = getActivity();
		helper.testLiveMapButtonClick(activity, this);
	}	
}
