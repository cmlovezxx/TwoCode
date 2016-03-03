package com.zx.twocode.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;

public class MyViewPager extends ViewPager {

	public MyViewPager(Context context) {
		super(context);

	}

	public MyViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		Log.e("a", "vp");
		return false;
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent arg0) {

		return false;
	}
}
