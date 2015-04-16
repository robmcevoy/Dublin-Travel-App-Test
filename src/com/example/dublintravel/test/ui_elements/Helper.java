package com.example.dublintravel.test.ui_elements;


import junit.framework.TestCase;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Helper extends TestCase{
	
	public void testNavigationBar(ImageView dublinBusImageView, ImageView irishRailImageView,
								ImageView luasImageView, ImageView busEireannImageView, ImageView liveMapView){
		testVisibility(dublinBusImageView);
		testVisibility(luasImageView);
		testVisibility(busEireannImageView);
		testVisibility(irishRailImageView);
		testVisibility(liveMapView);
		testButton(dublinBusImageView);
		testButton(luasImageView);
		testButton(busEireannImageView);
		testButton(irishRailImageView);
		testButton(liveMapView);
	}
	
	public void testTextView(final TextView textView, final String expected){
	    final String actual = textView.getText().toString();
	    assertEquals(expected, actual);
	    testVisibility(textView);
	}
	
	public void testVisibility(View view){
		assertTrue(View.VISIBLE == view.getVisibility());
	}
	
	public void testButton(View view){
		assertTrue(view.isClickable());
		testVisibility(view);
	}

}
