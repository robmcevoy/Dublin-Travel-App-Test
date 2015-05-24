package com.example.dublintravel.test.PTD;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.ImageView;
import com.example.dublintravel.R;
import com.example.dublintravel.PTDActivity;
import com.example.dublintravel.test.helper.Helper;

public class NavigationBar extends ActivityInstrumentationTestCase2<PTDActivity>{
	
	private PTDActivity activity;
	private ImageView irishRail;
	private ImageView dublinBus;
	private ImageView busEireann;
	private ImageView luas;
	private ImageView liveMap;
	private Helper helper;
	
	public NavigationBar(){
		super(PTDActivity.class);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		helper = new Helper();
		Intent intent = new Intent(getInstrumentation().getTargetContext(), PTDActivity.class);
		intent.putExtras(helper.createBundle());
		setActivityIntent(intent);
		activity = getActivity();
		irishRail = (ImageView) activity.findViewById(R.id.irishRailLogo);
		dublinBus = (ImageView) activity.findViewById(R.id.dublinBusLogo);
		busEireann = (ImageView) activity.findViewById(R.id.busEireannLogo);
		luas = (ImageView) activity.findViewById(R.id.luasLogo);
		liveMap = (ImageView) activity.findViewById(R.id.liveMapLogo);
	}

	public void testActiveOperatorFromBundle(){
		Drawable ir_actual = irishRail.getBackground();
		Drawable db_actual = dublinBus.getBackground();
		Drawable lu_actual = luas.getBackground();
		Drawable be_actual = busEireann.getBackground();
		Drawable lm_actual = liveMap.getBackground();
		Drawable expected = activity.getResources().getDrawable(R.drawable.rounded_corner_orange);
		assertTrue(ir_actual.getConstantState().equals(expected.getConstantState()));
		assertTrue(!db_actual.getConstantState().equals(expected.getConstantState()));
		assertTrue(!lu_actual.getConstantState().equals(expected.getConstantState()));
		assertTrue(!be_actual.getConstantState().equals(expected.getConstantState()));
		assertTrue(!lm_actual.getConstantState().equals(expected.getConstantState()));
	}
	
	public void testChangeOperatorToDublinBus(){
		helper.clickButton(dublinBus, activity);
		Drawable ir_actual = irishRail.getBackground();
		Drawable db_actual = dublinBus.getBackground();
		Drawable lu_actual = luas.getBackground();
		Drawable be_actual = busEireann.getBackground();
		Drawable lm_actual = liveMap.getBackground();
		Drawable expected = activity.getResources().getDrawable(R.drawable.rounded_corner_orange);
		assertTrue(!ir_actual.getConstantState().equals(expected.getConstantState()));
		assertTrue(db_actual.getConstantState().equals(expected.getConstantState()));
		assertTrue(!lu_actual.getConstantState().equals(expected.getConstantState()));
		assertTrue(!be_actual.getConstantState().equals(expected.getConstantState()));
		assertTrue(!lm_actual.getConstantState().equals(expected.getConstantState()));
	}
	
	public void testChangeOperatorToLuas(){
		helper.clickButton(luas, activity);
		Drawable ir_actual = irishRail.getBackground();
		Drawable db_actual = dublinBus.getBackground();
		Drawable lu_actual = luas.getBackground();
		Drawable be_actual = busEireann.getBackground();
		Drawable lm_actual = liveMap.getBackground();
		Drawable expected = activity.getResources().getDrawable(R.drawable.rounded_corner_orange);
		assertTrue(!ir_actual.getConstantState().equals(expected.getConstantState()));
		assertTrue(!db_actual.getConstantState().equals(expected.getConstantState()));
		assertTrue(lu_actual.getConstantState().equals(expected.getConstantState()));
		assertTrue(!be_actual.getConstantState().equals(expected.getConstantState()));
		assertTrue(!lm_actual.getConstantState().equals(expected.getConstantState()));
	}
	
	public void testChangeOperatorToBusEireann(){
		helper.clickButton(busEireann, activity);
		Drawable ir_actual = irishRail.getBackground();
		Drawable db_actual = dublinBus.getBackground();
		Drawable lu_actual = luas.getBackground();
		Drawable be_actual = busEireann.getBackground();
		Drawable lm_actual = liveMap.getBackground();
		Drawable expected = activity.getResources().getDrawable(R.drawable.rounded_corner_orange);
		assertTrue(!ir_actual.getConstantState().equals(expected.getConstantState()));
		assertTrue(!db_actual.getConstantState().equals(expected.getConstantState()));
		assertTrue(!lu_actual.getConstantState().equals(expected.getConstantState()));
		assertTrue(be_actual.getConstantState().equals(expected.getConstantState()));
		assertTrue(!lm_actual.getConstantState().equals(expected.getConstantState()));
	}
}
